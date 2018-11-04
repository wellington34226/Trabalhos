#include "parametros.h"//utilizacao de uma biblioteca predefinida pelo programador.

int main(){

	int i;
	pid_t filhoid[3],filterm;//pid dos processos filhos e do processo filho que terminou
	arq_log = fopen ("log.txt","w");//cria arquivo de log para escrita
	pai=getpid();
	int priori=0,priorit=19;//prioridade atual e prioridade modificada respectivamente
	//signal(SIGINT,CapturarCtrlC);
	if (arq_log==NULL){
		printf("%sERRO ao criar arquivo de arq_log.\n",VERMELHO);
		printf("%s\n",NORMAL);
		exit(0);
  	}
	printf("%sEu sou o pai - PID %d.\n",NORMAL, pai);	
	printf("Vou criar uma area de memoria para meus filhos.\n");
	fprintf(arq_log,"Eu sou o pai - PID %d.\nVou criar uma area de memoria para meus filhos.\n", pai);
	mem_comp = criar_mem();//cria memoria compartilhada e retorna o apontador para a mesma
	if(mem_comp == '\0'){
		printf("%s\n",NORMAL);
		exit(0);
	}//se ocorrer erro na criação da memoria compartilhada,sai do programa
	printf("Ja criei uma area de memoria para meus filhos.\nVou criar os semaforos para exclusao mutua dos meus filhos.\n");
	fprintf(arq_log,"Ja criei uma area de memoria para meus filhos.\nVou criar os semaforos para exclusao mutua dos meus filhos.\n");
	semid = sem_criar(1);
	if(semid<=0){
		if(semid<0){
			printf("%sNao consegui criar o semaforo para meus filhos.\nIrei encerrar minha execucao.\n",VERMELHO,pai);
			fprintf(arq_log,"Nao consegui criar o semaforo para meus filhos.\nIrei encerrar minha execucao.\n",pai);
		}
		else{
			printf("%sNao consegui inicializar o semaforo para meus filhos.\nIrei  encerrar minha execucao.\n",VERMELHO,pai);
			fprintf(arq_log,"Nao consegui inicializar o semaforo para meus filhos.\nIrei  encerrar minha execucao.\n",pai);
			if(!sem_destroi(semid)){
				printf("%sImpossivel destruir semaforo.\n",VERMELHO);
				fprintf(arq_log,"Impossivel destruir semaforo.\n");
				perror("Erro no semctl.");
			}else{
				printf("%sSemaforo destruido.\n",VERMELHO);
				fprintf(arq_log,"Semaforo destruido.\n");
			}
		}
		if(!destruir_mem(memoriaid)){
			printf("%sImpossivel destruir area de memoria compartilhada.\n",VERMELHO);
			fprintf(arq_log,"Impossivel destruir area de memoria compartilhada.\n");
			perror("Erro no shmctl.");
		}else{
			printf("%sMemoria compartilhada destruida.\n",VERMELHO);
			fprintf(arq_log,"Memoria compartilhada destruida.\n");
		}
		printf("%s\n",NORMAL);
		exit(0);
	}//se ocorrer erro na criacao do semaforo, sai do programa
	printf("Memoria compartilhada e semaforo criados com sucesso.\nAgora vou criar os processos filhos.\n\n", pai);
	fprintf(arq_log,"Memoria compartilhada e semaforo criados com sucesso.\nAgora vou criar os processos filhos.\n\n", pai);
	fflush(arq_log);//limpa o buffer de saida
	ftime(&inicio);
	if((filhoid[0] = fork()) == -1){
		printf("%sErro ao tentar criar um processo filho 0.\n",VERMELHO);
		fprintf(arq_log,"Erro ao tentar criar um processo filho 0.\n\n");
		perror("Erro no fork.");
		printf("%s\n",NORMAL);
		exit(0);
	}//criar o processo filho e verifica se ocorreu erro na criacao.
	else if(!filhoid[0]){
		ftime(&inicio);
		printf("%sProcesso filho 0 - PID %d ira comecar a executar.\n\n",AZUL,getpid());
		fprintf(arq_log,"Processo filho 0 - PID %d ira comecar a executar.\n\n",getpid());
		filho(0);
		ftime(&fim);
		tempo = ((double)fim.time + (double)fim.millitm*0.001) - ((double)inicio.time + (double)inicio.millitm*0.001);//calcula o tempo de execucao.
		printf("%sProcesso filho 0 - PID %d terminou em %.3lf segundos.\n\n",AZUL,getpid(),tempo);
		fprintf(arq_log,"Processo filho 0 - PID %d terminou em %.3lf segundos.\n\n",getpid(),tempo);
		exit(0);
	}//filho 0 executa chamando a funcao filho
	else{
		fflush(arq_log);
		printf("%sSou o processo pai %d. Ja criei o processo filho 0 - PID %d.\nAgora ire criar outro processo filho.\n\n",NORMAL, pai,filhoid[0]);
		fprintf(arq_log,"Sou o processo pai %d. Ja criei o processo filho 0 - PID %d.\nAgora ire criar outro processo filho.\n\n",pai,filhoid[0]);
		if((filhoid[1] = fork()) == -1){
			printf("%sErro ao tentar criar um processo filho 1.\n",VERMELHO);
			fprintf(arq_log,"Erro ao tentar criar um processo filho 1.\n\n");
			perror("Erro no fork.");
			printf("%s\n",NORMAL);
			exit(0);
		}//criar o processo filho e verifica se ocorreu erro na criacao.
		else if(!filhoid[1]){
			ftime(&inicio);
			errno=0;
			if(((priori=getpriority(PRIO_PROCESS,0))==-1)&&(errno!=0)){
				printf("%sErro ao tentar obter prioridade do processo filho 1 - PID %d.\nErro: %d |%s\n\n",VERMELHO,getpid(),errno,strerror(errno));
				fprintf(arq_log,"Erro ao tentar obter prioridade do processo filho 1 - PID %d.\nErro: %d |%s\n\n",getpid(),errno,strerror(errno));
				perror("Erro no getpriority.");
				printf("%s\n",NORMAL);
				exit(0);
			}
			if(setpriority(PRIO_PROCESS,0,priorit)==-1){
				printf("%sErro ao tentar modificar prioridade do processo filho 1 - PID %d.\nErro: %d |%s\n\n",VERMELHO,getpid(),errno,strerror(errno));
				fprintf(arq_log,"Erro ao tentar modificar prioridade do processo filho 1 - PID %d.\nErro: %d |%s\n\n",getpid(),errno,strerror(errno));
				perror("Erro no setpriority.");
				printf("%s\n",NORMAL);
				exit(0);
			}
			printf("%sProcesso filho 1 - PID %d ira comecar a executar.\nPrioirdade modificada de %d para %d.\n\n",VERDE,getpid(),priori,priorit);
			fprintf(arq_log,"Processo filho 1 - PID %d ira comecar a executar.\nPrioirdade modificada de %d para %d.\n\n",getpid(),priori,priorit);
			filho(1);
			ftime(&fim);
			tempo = ((double)fim.time + (double)fim.millitm*0.001) - ((double)inicio.time + (double)inicio.millitm*0.001);//calcula o tempo de execucao.
			printf("%sProcesso filho 1 - PID %d terminou em %.3lf segundos.\n\n",VERDE,getpid(),tempo);
			fprintf(arq_log,"Processo filho 1 - PID %d terminou em %.3lf segundos.\n\n",getpid(),tempo);
			exit(0);
		}//filho 1 executa chamando a funcao filho
		else{
			fflush(arq_log);
			printf("%sSou o processo pai - PID %d. Ja criei o processo filho 1 - PID %d.\nAgora ire criar outro processo filho.\n\n",NORMAL,pai,filhoid[1]);
			fprintf(arq_log,"Sou o processo pai - PID %d. Ja criei o processo filho 1 - PID %d.\nAgora ire criar outro processo filho.\n\n",pai,filhoid[1]);
			if((filhoid[2] = fork()) == -1){
				printf("%sErro ao tentar criar um processo filho 2.\n",VERMELHO);
				fprintf(arq_log,"Erro ao tentar criar um processo filho 2.\n\n");
				perror("Erro no fork.");
				printf("%s\n",NORMAL);
				exit(0);
			}//criar o processo filho e verifica se ocorreu erro na criacao.
			else if(!filhoid[2]){
				ftime(&inicio);
				errno=0;
				if(((priori=getpriority(PRIO_PROCESS,0))==-1)&&(errno!=0)){
					printf("%sErro ao tentar obter prioridade do processo filho 2 - PID %d.\nErro: %d |%s\n\n",VERMELHO,getpid(),errno,strerror(errno));
					fprintf(arq_log,"Erro ao tentar obter prioridade do processo filho 2 - PID %d.\nErro: %d |%s\n\n",getpid(),errno,strerror(errno));
					perror("Erro no getpriority.");
					printf("%s\n",NORMAL);
					exit(0);
				}
				if(setpriority(PRIO_PROCESS,0,priorit)==-1){
					printf("%sErro ao tentar modificar prioridade do processo filho 2 - PID %d.\nErro: %d |%s\n\n",VERMELHO,getpid(),errno,strerror(errno));
					fprintf(arq_log,"Erro ao tentar modificar prioridade do processo filho 2 - PID %d.\nErro: %d |%s\n\n",getpid(),errno,strerror(errno));
					perror("Erro no setpriority.");
					printf("%s\n",NORMAL);
					exit(0);
				}
				printf("%sProcesso filho 2 - PID %d ira comecar a executar.\nPrioirdade modificada de %d para %d.\n\n",AMARELO,getpid(),priori,priorit);
				fprintf(arq_log,"Processo filho 2 - PID %d ira comecar a executar.\nPrioirdade modificada de %d para %d.\n\n",getpid(),priori,priorit);
				filho(2);
				ftime(&fim);
				tempo = ((double)fim.time + (double)fim.millitm*0.001) - ((double)inicio.time + (double)inicio.millitm*0.001);//calcula o tempo de execucao.
				printf("%sProcesso filho 2 - PID %d terminou em %.3lf segundos.\n\n",AMARELO,getpid(),tempo);
				fprintf(arq_log,"Processo filho 2 - PID %d terminou em %.3lf segundos.\n\n",getpid(),tempo);
				exit(0);
			}//filho 2 executa chamando a funcao filho
			else{
				fflush(arq_log);
				signal(SIGINT,CapturarCtrlC);
				printf("%sSou o processo pai - PID %d. Ja criei o processo filho 2 - PID %d.\nAgora irei aguardar meus filhos terminarem.\n\n",NORMAL, pai,filhoid[2]);
				fprintf(arq_log,"Sou o processo pai - PID %d. Ja criei o processo filho 2 - PID %d.\nAgora irei aguardar meus filhos terminarem.\n\n",pai,filhoid[2]);
				for(i=0;i<3;i++){
					filterm=wait(0);
					fflush(arq_log);
					if(filterm==filhoid[0]){
						printf("%sSou o processo pai - PID %d. Processo filho 0 - PID %d terminou.\n\n",NORMAL, pai,filhoid[0]);
						fprintf(arq_log,"Sou o processo pai - PID %d. Processo filho 0 - PID %d terminou.\n\n",pai,filhoid[0]);
					}else{
						if(filterm==filhoid[1]){
							printf("%sSou o processo pai - PID %d. Processo filho 1 - PID %d terminou.\n\n",NORMAL, pai,filhoid[1]);
							fprintf(arq_log,"Sou o processo pai - PID %d. Processo filho 1 - PID %d terminou.\n\n",pai,filhoid[1]);
						}else{
							if(filterm==filhoid[2]){
								printf("%sSou o processo pai - PID %d. Processo filho 2 - PID %d terminou.\n\n",NORMAL, pai,filhoid[2]);
								fprintf(arq_log,"Sou o processo pai - PID %d. Processo filho 2 - PID %d terminou.\n\n",pai,filhoid[2]);
							}
						}
					}
				}
				ftime(&fim);
				tempo = ((double)fim.time + (double)fim.millitm*0.001) - ((double)inicio.time + (double)inicio.millitm*0.001);//calcula o tempo de execucao.
				if(!destruir_mem(memoriaid)){
					printf("%sImpossivel destruir area de memoria compartilhada.\n",VERMELHO);
					fprintf(arq_log,"Impossivel destruir area de memoria compartilhada.\n");
					perror("Erro no shmctl.");
					if(!sem_destroi(semid)){
						printf("%sImpossivel destruir semaforo.\n",VERMELHO);
						fprintf(arq_log,"Impossivel destruir semaforo.\n");
						perror("Erro no semctl.");
						printf("%sSou processo pai - PID %d.\n",NORMAL,pai);
						printf("%sTodos os filhos ja terminaram.\n",NORMAL);
						printf("%sProcessamento teve duracao de: %.3lf segundos\n",NORMAL,tempo);
						printf("%sVariavel boton: %d.\nVariavel top: %d.\n",NORMAL,mem_comp->boton,mem_comp->top);
						fprintf(arq_log,"Sou processo pai - PID %d.\nTodos os filhos ja terminaram.\nProcessamento teve duracao de: %.3lf segundos\nVariavel boton: %d.\nVariavel top: %d.\n\n",pai,tempo,mem_comp->boton,mem_comp->top);
					}else{
						printf("%sSou processo pai - PID %d.\n",NORMAL,pai);
						printf("%sTodos os filhos ja terminaram e eu ja destrui o semaforo.\n",NORMAL);
						printf("%sProcessamento teve duracao de: %.3lf segundos\n",NORMAL,tempo);
						printf("%sVariavel boton: %d.\nVariavel top: %d.\n",NORMAL,mem_comp->boton,mem_comp->top);
						fprintf(arq_log,"Sou processo pai - PID %d.\nTodos os filhos ja terminaram e eu ja destrui o semaforo.\nProcessamento teve duracao de: %.3lf segundos\nVariavel boton: %d.\nVariavel top: %d.\n\n",pai,tempo,mem_comp->boton,mem_comp->top);
					}
				}else{
					if(!sem_destroi(semid)){
						printf("%sImpossivel destruir semaforo.\n",VERMELHO);
						fprintf(arq_log,"Impossivel destruir semaforo.\n");
						perror("Erro no semctl.");
						printf("%sSou processo pai - PID %d.\n",NORMAL,pai);
						printf("%sTodos os filhos ja terminaram e eu ja destrui a area de memoria compartilhada.\n",NORMAL);
						printf("%sProcessamento teve duracao de: %.3lf segundos\n",NORMAL,tempo);
						printf("%sVariavel boton: %d.\nVariavel top: %d.\n",NORMAL,mem_comp->boton,mem_comp->top);
						fprintf(arq_log,"Sou processo pai - PID %d.\nTodos os filhos ja terminaram e eu ja destrui a area de memoria compartilhada.\nProcessamento teve duracao de: %.3lf segundos\nVariavel boton: %d.\nVariavel top: %d.\n\n",pai,tempo,mem_comp->boton,mem_comp->top);
					}else{
						printf("%sSou processo pai - PID %d.\n",NORMAL,pai);
						printf("%sTodos os filhos ja terminaram e eu ja destrui a area de memoria compartilhada e o semaforo.\n",NORMAL);
						printf("%sProcessamento teve duracao de: %.3lf segundos\n",NORMAL,tempo);
						printf("%sVariavel boton: %d.\nVariavel top: %d.\n",NORMAL,mem_comp->boton,mem_comp->top);
						fprintf(arq_log,"Sou processo pai - PID %d.\nTodos os filhos ja terminaram e eu ja destrui a area de memoria compartilhada e o semaforo.\nProcessamento teve duracao de: %.3lf segundos\nVariavel boton: %d.\nVariavel top: %d.\n\n",pai,tempo,mem_comp->boton,mem_comp->top);
					}
				}//destroi a memoria compartilhada  e verifica se ocorreu erro na destruicao
				fclose(arq_log);//fecha arquivo
				printf("%s\n",NORMAL);
			}//pai executa apos criar todos os filhos
		}
	}
	exit(0);
}//codigo principal
