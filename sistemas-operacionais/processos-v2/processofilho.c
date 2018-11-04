#include "parametros.h"//utilizacao de uma biblioteca predefinida pelo programador.

int filho(int id_tp,FILE* log,int semid){

	int localVar,cont,acao,aux;//variavel local,contador do loop,identificador da acao a ser executada na pilha e variavel auxiliar.
	int topo;// recebe o topo da pilha 
	mc mem_comp;//apontador para memoria compartilhada
	int memoriaid;//id da memoria compartilhada
	int dormir;//tempo que o processo/thread ira dormir
		
	srand( time(NULL) );
	mem_comp = acoplar_mem(&memoriaid,"processopai.c",id_tp,log);//recuperacao do id da memoria compratilhada e acoplamento na mesma.
	if(mem_comp == '\0')//sai do programa caso ocorra um erro no acoplamento. 
		return 0;
	for(cont = 1; cont <= 100; cont++){
		localVar = ((rand()+(int)getpid())%100);
		acao = (((rand()+(int)getpid())%100) %2);
		sem_pedido(semid);//efetua pedido de semáforo.
		topo = mem_comp->topo;
		dormir = (((rand()+(int)getpid())%401)+100)*1000;
		usleep(dormir);
		if (!acao){
            		if((aux = push(localVar, mem_comp->p, &topo,log))){
            			mem_comp->topo = topo;
			
            	}
        	}//acao sorteada foi empilhar
		else{
	    		localVar = pop(mem_comp->p, &topo,log);	
	    		if(localVar>=0){
	    			mem_comp->topo = topo;
	    		}
		}//acao sorteada foi desempilhar
		sem_libera(semid);//libera o semaforo
		if(id_tp){
			printf("%s-> Thread - PID = %d - Thread_ID -%d\n",AMARELO, getpid(),(int)pthread_self());
			fprintf(log,"-> Thread - PID = %d - Thread_ID -%d\n",getpid(),(int)pthread_self());
		}
		else{
			printf("%s-> Processo Filho - PID = %d\n",AZUL, getpid());
			fprintf(log,"-> Processo Filho - PID = %d\n",getpid());
		}//identifica se e o processo ou a thread que esta executando
		printf("LOOP: %d; LOCALVAR: %d; TOPO_LOCAL: %d; TOPO_REAL: %d\n",cont,localVar,topo,mem_comp->topo);//----------vvv
		fprintf(log,"LOOP: %d; LOCALVAR: %d; TOPO_LOCAL: %d; TOPO_REAL: %d\n",cont,localVar,topo,mem_comp->topo);
		if(!acao){
			printf("PUSH - ");
			fprintf(log,"PUSH - ");
		}
		else{
			printf("POP - ");
			fprintf(log,"POP - ");
		}
		printf("PILHA:");
		fprintf(log,"PILHA:");
		imprimir_pilha(log,mem_comp);//imprime informacoes relevantes sobre a acao envolvendo a pilha-^^^
		fflush(log);//limpa buffer de saida		
	}//loop
	if( shmdt(mem_comp) == -1){
		if(id_tp){
			printf("%sErro ao desacoplar a thread da area de memoria compartilhada.",VERMELHO);
			fprintf(log,"Erro ao desacoplar da area de memoria compartilhada.");
		}
		else{
			printf("%sErro ao desacoplar o processo filho da area de memoria compartilhada.",VERMELHO);
			fprintf(log,"Erro ao desacoplar da area de memoria compartilhada.");
		}
			
		perror("Erro no shmdt.");
		
	}//desacopla da memoria e verifica se ocorreu erro no desacoplamento
	printf("%s\n",NORMAL);
	return 0;
}
