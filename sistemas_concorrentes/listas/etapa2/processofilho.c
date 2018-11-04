#include "parametros.h"//utilizacao de uma biblioteca predefinida pelo programador.

void filho(int id_tp){

	int localVar,cont;//variavel local,contador do loop
	double media=0,desvio=0;//tempo medio desvio padrao
	double temps[100];//array guardar os tempos de execucao de cada rodada, para futuro calculo de media e desvio padrao.
	double variancia[100];//array guarda os tempos ao quadrado.
	int dormir;//tempo que o processo ira dormir
	char* padrao;//padrao de cor do processo
	srand( time(NULL) );//setagem da funcao rand para geracao de numeros de acordo com o tempo do relogio.
	struct timeb iniciof,fimf;//captura em uma estrutura os tempos de inicio e fim.
	int meupid=(int)getpid();
	/*
	mem_comp = acoplar_mem(id_tp);//recuperacao do id da memoria compratilhada e acoplamento na mesma.
	if(mem_comp == '\0')exit(0);//sai do programa caso ocorra um erro no acoplamento. 
	*/
	switch (id_tp){
		case 0:{
			padrao=AZUL;
			break;
		}
		case 1:{
			padrao=VERDE;
			break;
		}
		case 2:{
			padrao=AMARELO;
			break;
		}
		default:{
			break;
		}
	}
	for(cont = 0; cont < 100; cont++){
		ftime(&iniciof);
		dormir = rand();
		dormir= ((dormir*dormir+meupid*meupid)%496)+5;
		if(dormir<0)dormir=(dormir*dormir)/2;
		if(dormir>500)dormir=(dormir%496)+5;
		if(dormir<5)dormir+=5;
		sem_pedido(semid);//efetua pedido de semáforo.
		localVar=mem_comp->boton;
		localVar++;
		usleep(dormir*1000);
		mem_comp->boton=localVar;
		mem_comp->top--;
		ftime(&fimf);		
		temps[cont]=((double)fimf.time + (double)fimf.millitm*0.001) - ((double)iniciof.time + (double)iniciof.millitm*0.001);
		media+=temps[cont];
		dormir = rand();
		dormir= ((dormir*dormir+meupid*meupid)%496)+5;
		if(dormir<0)dormir=(dormir*dormir)/2;
		if(dormir>500)dormir=(dormir%496)+5;
		if(dormir<5)dormir+=5;
		printf("%s-> Processo Filho %d - PID = %d\nPasso %d: Variavel boton: %d - Variavel top: %d - Variavel local: %d.\nTempo de execucao: %.3lf segundos. Irei dormir %d milissegundos.\n\n",padrao,id_tp,meupid,cont+1,mem_comp->boton,mem_comp->top,localVar,temps[cont],dormir);
		fprintf(arq_log,"-> Processo Filho %d - PID = %d\nPasso %d: Variavel boton: %d - Variavel top: %d - Variavel local: %d.\nTempo de execucao: %.3lf segundos. Irei dormir %d milissegundos\n\n",id_tp,meupid,cont+1,mem_comp->boton,mem_comp->top,localVar,temps[cont],dormir);
		fflush(arq_log);//limpa buffer de saida
		sem_libera(semid);//libera o semaforo
		usleep(dormir*1000);			
	}//loop
	media=media/100;
	for(cont=0;cont<100;cont++){
		variancia[cont]=pow(temps[cont]-media,2);
		desvio+=variancia[cont];
	}
	desvio=desvio/100;
	desvio=pow(desvio,1/2);
	printf("%sFilho %d - PID %d ->Media: %.3lf segundos Desvio padrao: %.3lf",padrao,id_tp,meupid,media,desvio);
	if( shmdt(mem_comp) == -1){
		printf("%sErro ao desacoplar o processo filho %d - PID %d da area de memoria compartilhada.\n",VERMELHO,id_tp,meupid);
		fprintf(arq_log,"Erro ao desacoplar o processo filho %d - PID %d da area de memoria compartilhada.\n",id_tp,meupid);
		perror("Erro no shmdt.");
	}//desacopla da memoria e verifica se ocorreu erro no desacoplamento
	printf("%s\n",NORMAL);
}//codigo que sera executado pelos processos filhos
