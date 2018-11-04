package bloco;

import java.util.Random;

public class Produtor extends Thread {
	private final Buffer buffer;
	private final int id;
	private final boolean infinito;
	private final Random randomNumbers=new Random();
	private static boolean sair=false;
  
	public Produtor(int numid, Buffer b, boolean infinity){
		id=numid;
		buffer=b;
		sair=false;
		infinito = infinity;
	}

        @Override
	public void run () {
		int i=0;
		
		try{
			while(!sair&&(infinito||(!infinito&&(i<100)))){
				i++;
				Produtor.sleep (randomNumbers.nextInt(101));
				int item=randomNumbers.nextInt(101);
				String mensagem=toString();
				mensagem+=(" contador:" + i + " >>>> produziu:");
				while(!buffer.put(item,mensagem)&&!sair){
					Produtor.sleep (randomNumbers.nextInt(101));
				}
				if(i==java.lang.Integer.MAX_VALUE){
					i=0;
					System.out.println ("Contador atingiu o máximo do inteiro:" + java.lang.Integer.MAX_VALUE + toString() + " reiniciou o contador " + i);
				}
			}
			System.out.println ("Fim do " + toString());
			buffer.fimProdutor();
		}catch (java.lang.InterruptedException e) {
			System.out.println ("Erro na sincronizacao.\n" + toString());
		}
		catch (java.lang.ArrayIndexOutOfBoundsException e){
			System.out.println("Erro com o buffer: " + e);
		}
	}
	
        @Override
	public String toString(){
		String retorno = "Produtor:";
		retorno+=id;
		return retorno;
	}
	
	 public void terminar(){
		sair=true;
	}
}
