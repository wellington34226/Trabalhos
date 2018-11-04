#include "parametros.h"//utilizacao de uma biblioteca edefinida pelo programador.

int sizememo = sizeof(struct pilha);//determinacao do tamanho da memoria compartilhada

int push(int n,int* pilha, int* topo,FILE* log){

	if(*topo == 10){
		printf("%sPilha Overflow.",VERMELHO);
		fprintf(log,"Pilha Overflow.\n");
		printf("%s\n",NORMAL);
	}
	else{
		pilha[++(*topo)]	= n;
		return 1;
	}
	return 0;
}//funcao de empilhamento

int pop(int* pilha, int* topo,FILE* log){

	if(!(*topo)){
		printf("%sPilha Underflow.",VERMELHO);
		fprintf(log,"Pilha Underflow.\n");
		printf("%s\n",NORMAL);	
	}
	else
		return pilha[(*topo)--];
	return -1;
}//funcao de desempilhamento

void imprimir_pilha(FILE* log,mc pilha){
	int i;
	
	for(i = 1;i <= pilha->topo;i++){
		printf(" [%d]",pilha->p[i]);
		fprintf(log," [%d]",pilha->p[i]);
	}
	fprintf(log,"\n\n");
	printf("\n\n");
}//imprime o conteudo da pilha

mc acoplar_mem(int *memoriaid,char *pai,int id_tp,FILE* log){
	mc mem_comp;
	
	if ( (*memoriaid = shmget( ftok( pai, (key_t)KEY), sizememo, 0666) ) == -1){
		printf("%sErro ao recuperar o id da memoria compartilhadda.\n",VERMELHO);
		fprintf(log,"Erro ao recuperar o id da memoria compartilhadda.\n");
		perror("Erro no shmget.");
    	}
	else{
		if ( (mem_comp = shmat(*memoriaid, NULL, 0666) ) == (mc)-1){
			printf("%sErro ao se acoplar a memoria compartilhada.\n",VERMELHO);
			fprintf(log,"Erro ao se acoplar a memoria compartilhada.\n");
			perror("Erro no shmat.");
		}
		else{
			if(id_tp){
				printf("%sA thread %d foi acoplada a memoria compartilhada: %d.\n",AMARELO,getpid(),*memoriaid);
				fprintf(log,"A thread %d foi acoplada a memoria compartilhada: %d.\n",getpid(),*memoriaid);
			}
			else{
				fprintf(log,"A thread %d foi acoplada a memoria compartilhada: %d.\n",getpid(),*memoriaid);
				printf("%sO processo %d foi acoplado a memoria compartilhada: %d.\n",AZUL, getpid(),*memoriaid);
			}
			printf("%s\n",NORMAL);
			return mem_comp;
		}
	}
	printf("%s\n",NORMAL);
	return '\0';
}//acopla a memoria compartilhada recuperando o apontador e tratando os erros.

mc criar_mem(int *memoriaid,char *pai,FILE* log){
	mc mem_comp;
	
	if( ( *memoriaid = shmget((ftok(pai, (key_t)KEY )), sizememo, IPC_CREAT|IPC_EXCL|SHM_R|SHM_W) ) == -1){
		printf("Area de memoria compartilhada ja criada, vou apenas me acoplar a ela.\n");
		fprintf(log,"Area de memoria compartilhada ja criada, vou apenas me acoplar a ela.\n");
	}
	else{
		printf("Area de memoria compartilhada criada pelo processo pai %d com id: %d\n", getpid(),*memoriaid);
		fprintf(log,"Area de memoria compartilhada ja criada, vou apenas me acoplar a ela.\n");
	}
	if( ( mem_comp = shmat(*memoriaid,0,0) ) == (mc)-1){
		printf("%sErro ao tentar se acoplar a area de memoria compartilhada.\n",VERMELHO);  
		fprintf(log,"Erro ao tentar se acoplar a area de memoria compartilhada.\n",VERMELHO);        
		perror("Erro no shmat.");
		printf("%s\n",NORMAL);
	}
	else{
		mem_comp->topo = 0;
		return mem_comp;
	}
	return '\0';
}//cria/acopla a memoria compartilhada(recuperando o apontador) e tratando os erros
