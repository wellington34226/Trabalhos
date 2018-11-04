package bloco;

import java.io.*;
  
public class Entrada extends Thread{
	private final Buffer buffer;
	private int incrementsize=0;
	private int sizeinit;
	private boolean sair=false;
	private final int nprodutores;
	private final int nconsumidores;
	private final boolean execinfi;
	Produtor[] produtores;
	Consumidor[] consumidores;
	
	public Entrada (Buffer buff,int sizeinit,int produtores,int consumidores,boolean infinito) {
		buffer=buff;
		this.sizeinit=sizeinit;
		nprodutores=produtores;
		nconsumidores=consumidores;
		execinfi=infinito;
	}

        @Override
	public void run () {
		produtores = new Produtor[nprodutores];
		consumidores = new Consumidor[nconsumidores];
		inicializar();
		try {
			while(!sair){
				try{
                                        switch((char)System.in.read()){
                                            case '.':
                                                sair=true;
                                            case '+':
                                                incrementsize++;
                                            case '-':
                                                incrementsize--;
                                            default:
                                                if(buffer.testaFim()&&!sair)System.out.println("Termino do programa! Digite ponto para sair");
                                                break;
                                        }
				}catch (java.io.IOException e){
					System.out.println("Erro de digitacao: " + e);
				}
                                if(buffer.testaDead())System.out.println("Deadlock! Digite ponto para sair");
				if(buffer.testaFim()&&!sair)System.out.println("Termino do programa! Digite ponto para sair");
				if(incrementsize!=0){
					try{
						while(!buffer.setSize(sizeinit+incrementsize)){}
					}catch(java.lang.InterruptedException e){
						System.out.println("Erro ao modificar tamanho do buffer." + e + buffer);
					}
					sizeinit+=incrementsize;
					incrementsize=0;
				}
			}
			if(sair){
				terminar();
			}
			System.out.println ("Fim das Producoes e dos Consumos.");
		}catch(java.lang.IllegalArgumentException e){
			System.out.println("Erro ao criar a entrada: " + e);
		}
	}
	public void inicializar(){
			for (int i = 0; i < nprodutores; i++) {
				produtores [i] = new Produtor (i+1, buffer,execinfi);          
			} 
			for (int i = 0; i < nconsumidores; i++) {
				consumidores [i] = new Consumidor (i+1, buffer,execinfi);          
			}
			for (int i = 0; i < nprodutores; i++) {
				produtores [i].start();          
			} 
			for (int i = 0; i < nconsumidores; i++) {
				consumidores [i].start();          
			}
	}
	
	public void terminar(){
		int contador;
		if(nprodutores>nconsumidores)contador=nconsumidores;
		else contador=nprodutores;
		try{
			for (int i = 0; i < contador; i++) {
				produtores[i].terminar();
				produtores[i].join();
				consumidores[i].terminar();
				consumidores[i].join();
			}
			if(contador<nprodutores){
				for (int i = contador; i < nprodutores; i++) {
					produtores[i].terminar();
					produtores[i].join();
				}
			}else{
				for (int i = contador; i < nconsumidores; i++) {
					consumidores[i].terminar();
					consumidores[i].join();
				}
			}
			
		}catch (java.lang.InterruptedException e){
			System.out.println("Atencao - Thread interrompida!!!");
		}
	}
}