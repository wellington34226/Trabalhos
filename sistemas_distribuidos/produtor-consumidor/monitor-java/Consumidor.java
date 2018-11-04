package monitor;

import java.util.Random;

public class Consumidor extends Thread {
	public int id;
	private final MonitorConsumidor mymonitor;
	private final Random randomNumbers=new Random();
	private boolean sair;
	private final boolean infinito;

	public Consumidor(int numid, MonitorConsumidor monitor, boolean infinity){
		id=numid;
		mymonitor=monitor;
		sair=false;
		infinito = infinity;
	}
	
        @Override
	public void run(){
		int i=0;
		try{
			while(!sair&&(infinito||(!infinito&&(i<100)))){
				i++;
				Consumidor.sleep (randomNumbers.nextInt(101));
				String mensagem=toString();
				mensagem+=(" contador:" + i + " >>>> consumiu:");
				while((MonitorConsumidor.consumir(mensagem)==-1)&&!sair){
					Consumidor.sleep (randomNumbers.nextInt(101));
				}
				if(i==java.lang.Integer.MAX_VALUE){
					i=0;
					System.out.println ("Contador atingiu o m�ximo do inteiro:" + java.lang.Integer.MAX_VALUE + toString() + " reiniciou o contador " + i);
				}
			}
			System.out.println ("Fim do " + toString());
			mymonitor.fimConsumidor();
		}catch (java.lang.InterruptedException e) {
			System.out.println ("Erro na sincronizacao.\n" + toString());
		}
		catch (java.lang.ArrayIndexOutOfBoundsException e){
			System.out.println("Erro com o buffer: " + e);
		}
	}
	
        @Override
	public String toString(){
		String retorno = "Consumidor:";
		retorno+=id;
		return retorno;
	}
	
	 public void terminar(){
		sair=true;
	}

}