package bloco;

import java.util.ArrayList;
import java.util.Iterator;

public class Buffer {
    private final ArrayList<Integer> buf;//elementos
    private int size;
    private boolean setresize=false;
    private int produtores;
    private int consumidores;
    private final Object putMonitor = new Object(); 
    private final Object getMonitor = new Object();
    // a idéia é a seguinte...
    private final Object resizeMonitor = new Object(); 
    private int watingClearToResize = 0;
    private boolean resize = false;

    public Buffer(int sizeinit,int p,int c) {
        size = sizeinit;
        buf = new ArrayList<>();
        produtores=p;
        consumidores=c;
    }

    public boolean put(int o,String mensagem) throws InterruptedException { 
        boolean retorno=false;

        synchronized(resizeMonitor) { // antes de fazer o put, verifica se tem resize
            if (setresize) {            // se tiver...
                while (!resize) { // e o buffer não pode ser encolhido porque está cheio..
                    ++watingClearToResize;  // vou embarreirar o produtor
                    try {
                        resizeMonitor.wait();// faco o wait
                    }catch(InterruptedException ie) {
                        throw ie;
                    } 
                    finally { 
                        --watingClearToResize;  // saindo do wait tem menos 1 esperando na berreira
                        if (watingClearToResize>0) resizeMonitor.notify(); // se ainda tem prod embarreirado...
                        else resize = false;           // ... libero, caso contrario, termineio resize
                    }
                }
            }
        }

        synchronized(putMonitor) { 
            try{
                if(!bufferCheio())
                    retorno=buf.add(o);
                if(retorno)
                    System.out.println(mensagem + o + "\n" + imprimirBuffer());
            }catch(java.lang.InterruptedException e){
                System.out.println("Erro ao inserir no buffer, falha de sincronizacao: " + e);
            }catch(java.lang.ArrayIndexOutOfBoundsException e){
                System.out.println("Erro ao inserir no buffer, falha no buffer: " + e);
            }
            return retorno;
        }
    }

    public int get(String mensagem) throws InterruptedException { 
        int num = -1;

        synchronized(resizeMonitor) { // antes de fazer o put, verifica se tem resize
            if (setresize) {            // se tiver...
                while (!resize) { // e o buffer não pode ser encolhido porque está cheio..
                    ++watingClearToResize;  // vou embarreirar o produtor
                    try {
                        resizeMonitor.wait();
                    } // faco o wait
                    catch(InterruptedException ie) {
                        throw ie;
                    } 
                    finally { 
                        --watingClearToResize;  // saindo do wait tem menos 1 esperando na berreira
                        if (watingClearToResize>0) resizeMonitor.notify(); // se ainda tem prod embarreirado...
                        else resize = false;           // ... libero, caso contrario, termineio resize
                    }
                }
            }
        }

        synchronized(getMonitor) {
            try{
                if(!bufferVazio())
                    num = buf.remove(0);
                if(num>=0)
                    System.out.println(mensagem + num + "\n" + imprimirBuffer());
            }catch(java.lang.InterruptedException e){
                System.out.println("Erro ao retirar do buffer, falha de sincronizacao: " + e);
            }catch(java.lang.ArrayIndexOutOfBoundsException e){
                System.out.println("Erro ao retirar do buffer, falha no buffer: " + e);
            }
                return (num);
        }
    }

    public boolean bufferVazio(){
        return buf.isEmpty();
    }
    
    public boolean bufferCheio(){
        return buf.size()==size;
    }
    
    public boolean setSize(int newsize) throws InterruptedException{
        synchronized(resizeMonitor){
        resize=false;
        setresize=true;
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
        }catch(java.lang.ArrayIndexOutOfBoundsException e){
            System.out.println("Erro ao redimencionar o buffer, falha no buffer: " + e);
            resize=false;
        }
            resizeMonitor.notifyAll();
            return resize;
        }
    }

    public String imprimirBuffer() throws InterruptedException{
        synchronized(this){
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
            s = null;
        }
        return s;
    }
    public void fimProdutor(){
        produtores--;
    }
    public void fimConsumidor(){
        consumidores--;
    }
    public boolean testaFim(){
        synchronized(this){
            return (produtores<=0)&&(consumidores<=0);
        }
    }
    public boolean testaDead(){
        synchronized(this){
            return ((produtores<=0)&&(consumidores>0))||((produtores>0)&&(consumidores<=0));
        }
    }
}