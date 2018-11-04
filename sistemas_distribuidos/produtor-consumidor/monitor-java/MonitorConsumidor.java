package monitor;

public class MonitorConsumidor{
	private static Buffer buffer;
	private static int retorno;
	
	public MonitorConsumidor(Buffer buff){
		buffer = buff;
		retorno=-1;
	}
	
	public static synchronized int consumir(String mensagemThread) throws InterruptedException{
		retorno=-1;
		if(!buffer.bufferVazio()){
			retorno=buffer.get();
			mensagemThread+=retorno;
		}
		if(retorno>=0){
			System.out.println(mensagemThread + retorno + "\n" + buffer.imprimirBuffer());
		}
		return retorno;
	}
	
	public synchronized void fimConsumidor() throws InterruptedException{
		buffer.fimConsumidor();
	}
}