package monitor;

public class MonitorProdutor{
	private static Buffer buffer;
	private static boolean retorno;
	
	public MonitorProdutor(Buffer buff){
		buffer = buff;
		retorno=false;
	}
	
	public static synchronized boolean produzir(int valor,String mensagemThread) throws InterruptedException{
		retorno=false;
		if(!buffer.bufferCheio()){
			if(buffer.put(valor)){
				retorno = true;
			}
		}
		if(retorno){
			System.out.println(mensagemThread + valor + "\n" + buffer.imprimirBuffer());
		}
		return retorno;
	}
	
	public synchronized void fimProdutor() throws InterruptedException{
		buffer.fimProdutor();
	}
}