package metodo;

public class PCB{
	private static int TAM = 2;
	private static Buffer buffer;
	private static int numProd=1;
	private static int numCons=1;
	private static boolean fechar=false;
	
	public static void main (String[] args) {
                boolean infinito=false;

		try{
                    TAM = Integer.parseInt(args[0]);
                    numProd = Integer.parseInt(args[1]);
                    numCons = Integer.parseInt(args[2]);
                    if(args.length>3){
			if(args.length==4){
                            if((args[3].compareToIgnoreCase("infinito")==0)||(args[3].compareToIgnoreCase("i")==0)){
                                infinito=true;
                            }else {
                                System.out.println("Entrada invalida.!");
                                System.out.println("Voce nao informou corretamente os parametros.!");
                                System.out.println("i ou infinito - para execucao infinita.!");
                                fechar=true;
                            }
			}else {
                            System.out.println("Entrada invalida.!");
                            System.out.println("Numero de argumentos errado.!");
                            fechar=true;
			}
                    }
		}catch (java.lang.NumberFormatException e){
			System.out.println("Entrada invalida.!\n");
			System.out.println("Voce nao digitou inteiros validos.!\n");
			fechar=true;
		}
		
		if(!fechar){
			buffer= new Buffer(TAM,numProd,numCons);
			Entrada entrada = new Entrada(buffer,TAM,numProd,numCons,infinito);
			entrada.start();
			try{
				entrada.join();
			}catch (java.lang.InterruptedException e){
				System.out.println("Atencao - Thread interrompida!!!");
			}
		}
		System.out.println("Fechando programa.");
	}
}
