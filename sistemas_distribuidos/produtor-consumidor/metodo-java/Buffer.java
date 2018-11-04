package metodo;

import java.util.ArrayList;
import java.util.Iterator;

public class Buffer {
    private final ArrayList<Integer> buf;
    private int size;
    private boolean setresize=false;
    private int produtores;
    private int consumidores;

    public Buffer(int sizeinit,int p,int c) {
        size = sizeinit;
        buf = new ArrayList<>();
	produtores=p;
	consumidores=c;
    }

    public synchronized boolean put(int o,String mensagem) throws InterruptedException {
        boolean retorno=false;

        try{
            if(!setresize)
                if(!bufferCheio())
                    retorno=buf.add(o);
                if(retorno)
                    System.out.println(mensagem + o + "\n" + imprimirBuffer());
                notifyAll();
        }catch(java.lang.InterruptedException e){
            System.out.println("Erro ao inserir no buffer, falha de sincronizacao: " + e);
        }
        catch(java.lang.ArrayStoreException e){
            System.out.println("Erro ao inserir no buffer, falha no buffer: " + e);
        }
        return retorno;
    }

    public synchronized int get(String mensagem) throws InterruptedException {
        int num=-1;

        try{
            if(!setresize){
                if(!bufferVazio()){
                    num =  buf.remove(0);
                }
            }
            if(num>=0)
                System.out.println(mensagem + num + "\n" + imprimirBuffer());
            notifyAll();
        }catch(java.lang.InterruptedException e){
            System.out.println("Erro ao retirar do buffer, falha de sincronizacao: " + e);
        }
        catch(java.lang.ArrayIndexOutOfBoundsException e){
            System.out.println("Erro ao retirar do buffer, falha no buffer: " + e);
        }
        return (num);
    }
    
    public boolean bufferVazio(){
        return buf.isEmpty();
    }
    
    public boolean bufferCheio(){
        return buf.size()==size;
    }
    
    public synchronized boolean setSize(int newsize) throws InterruptedException{
        boolean resize=false;
        try{
            if(newsize<buf.size()){
                if(size==buf.size()){
                        setresize=true;
                }else{
                        size=newsize;
                        setresize=false;
                        resize=true;
                }
            }else {
                size=newsize;
                setresize=false;
                resize=true;
            }
            notifyAll();
        }catch(java.lang.ArrayIndexOutOfBoundsException e){
            System.out.println("Erro ao redimencionar o buffer, falha no buffer: " + e);
            resize=false;
        }
        return resize;
    }
	
    public synchronized String imprimirBuffer() throws InterruptedException{
        String buffer;
        try{
            buffer = "Buffer:" + toString();
            notifyAll();
        }catch(java.lang.ArrayIndexOutOfBoundsException e){
            System.out.println("Erro ao imprimir o buffer, falha no buffer: " + e);
            buffer=null;
        }
        return buffer;
    }
	
        @Override
	public String toString () {
            String s = new String();
            int j=0;
            try{
                if(!buf.isEmpty())
                    for(Iterator<Integer> iterator = buf.iterator(); iterator.hasNext();j++)
                        s=s.concat("[" + j + "]=" + iterator.next() + " ");
            }catch(java.lang.ArrayIndexOutOfBoundsException e){
                System.out.println("Erro ao imprimir buffer, falha no buffer: " + e);
                s = new String();
            }
            return s;
    }
	
    public void fimProdutor(){
        produtores--;
    }
    public void fimConsumidor(){
        consumidores--;
    }

    public synchronized boolean testaFim(){
        return (produtores<=0)&&(consumidores<=0);
    }

    public synchronized boolean testaDead(){
        return ((produtores<=0)&&(consumidores>0))||((produtores>0)&&(consumidores<=0));
    }
}