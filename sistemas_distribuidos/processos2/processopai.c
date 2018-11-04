#include "parametros.h"//utilizacao de uma biblioteca predefinida pelo programador.
//#include "dijkstra.h"

struct timeb inicio_T,inicio_P,fim_T,fim_P;//guarda os tempos da thread e processo
double tempo_T,tempo_P;//--------------------------------------------------------^
FILE* arq_log;//arquivo de saida
int semid;//identificador do semaforo.

void processothread(void);

int main(){

	pthread_t threadfilha; 
	int pai;//id da thread pai
	pid_t filhoid;//pid do processo filho
	mc mem_comp;//apontador para memoria compartilhada
	int memoriaid;//id da memoria compartilhada
	int nthreads=1;//quantidade de threads
	
	pai = (int)pthread_self();
	arq_log = fopen ("log.txt","w");//cria arquivo para escrita
	if (arq_log==NULL){
		printf("%sERRO ao criar arquivo de arq_log.\n",VERMELHO);
		printf("%s\n",NORMAL);
		return 0;
  	}
	printf("%sEu sou a thread pai %d com pid %d.\n",VERDE, pai, getpid());	
	printf("Vou criar uma area de memoria para meus filhos.\n");
	fprintf(arq_log,"Eu sou a thread pai %d com pid %d.\nVou criar uma area de memoria para meus filhos.\n", pai, getpid());
	mem_comp = criar_mem(&memoriaid,"processopai.c",arq_log);//cria memoria compartilhada e retorna o apontador para a mesma
	if(mem_comp == '\0'){
		printf("%s\n",NORMAL);
		return 0;
	}//se ocorrer erro na criacao da memoria compartilhada, sai do programa
	semid = sem_criar(KEY,1);
	if(semid<=0){
		if(semid<0){
			printf("%sO pai %d nao conseguiu criar o semaforo para seus filhos.\nIra  encerrar sua execucao.\n",VERMELHO,getpid());
			fprintf(arq_log,"O pai %d nao conseguiu criar o semaforo para seus filhos.\nIra  encerrar sua execucao.\n",getpid());
		}
		else{
			printf("%sO pai %d nao conseguiu inicializar o semaforo para seus filhos.\nIra  encerrar sua execucao.\n",VERMELHO,getpid());
			fprintf(arq_log,"O pai %d nao conseguiu inicializar o semaforo para seus filhos.\nIra  encerrar sua execucao.\n",getpid());
		}
		printf("%s\n",NORMAL);
		return 0;
	}//se ocorrer erro na criacao do semaforo, sai do programa
	
	printf("O semaforo ja foi criado. O pai %d agora ira criar um processo filho.\n\n", getpid());
	fprintf(arq_log,"O semaforo ja foi criado. O pai %d agora ira criar um processo filho.\n\n", getpid());
	fflush(arq_log);//limpa o buffer de saida para o processo filho.
	ftime(&inicio_P);
	if((filhoid = fork()) == -1){
		printf("%sErro ao tentar criar um processo filho.\n",VERMELHO);
		fprintf(arq_log,"Erro ao tentar criar um processo filho.\n\n", getpid());
		perror("Erro no fork.");
		printf("%s\n",NORMAL);
		return 0;
	}//criar o processo filho e verifica se ocorreu erro na criacao.
	else if(!filhoid){
		printf("%sProcesso filho ira comecar a executar.\n\n",AZUL);
		fprintf(arq_log,"Processo filho ira comecar a executar.\n\n");
		filho(0,arq_log,semid);
		return 0;
	}//filho executa chamando a funcao filho
	else{
		printf("%sSou o processo pai %d. Ja criei um processo filho %d.\nAgora vou criar uma thread filha.\n\n",VERDE, getpid(),filhoid);
		fprintf(arq_log,"Sou o processo pai %d. Ja criei um processo filho %d.\nAgora vou criar uma thread filha.\n\n",getpid(),filhoid);
		fflush(arq_log);//limpa o buffer de saida para a thread.
		ftime(&inicio_T);
		if((pthread_create(&threadfilha,NULL,(void*(*)(void*))processothread,NULL)) == -1){
			printf("%sErro ao tentar criar uma thread.\n",VERMELHO);
			fprintf(arq_log,"Erro ao tentar criar uma thread.\n");
			perror("Erro na pthread.");
			printf("%s\n",NORMAL);
			return 0;
		}//cria thread filha e verifica se ocorreu erro
		wait(0);//aguarda o termino do processo filho
		ftime(&fim_P);
		pthread_join(threadfilha, NULL);//aguarda o termino da thread filha
		tempo_P = ((double)fim_P.time + (double)fim_P.millitm*0.001) - ((double)inicio_P.time + (double)inicio_P.millitm*0.001);//calcula o tempo do processo filho.
		tempo_T = ((double)fim_T.time + (double)fim_T.millitm*0.001) - ((double)inicio_T.time + (double)inicio_T.millitm*0.001);//calcula o tempo da thread filha.
		if(sem_destroi(semid)<0){
			printf("%sO pai %d não conseguiu destruir o semáforo.\n\n",VERMELHO,getpid());
			fprintf(arq_log,"O pai %d não conseguiu destruir o semáforo\n\n",getpid());
			printf("%s\n",NORMAL);
		}//destroi o semaforo  e verifica se ocorreu erro na destruicaoão
		else if((shmctl(memoriaid,IPC_RMID,0))==-1){
		    	printf("%sImpossivel destruir area de memoria compartilhada.\n",VERMELHO);
		    	fprintf(arq_log,"Impossivel destruir area de memoria compartilhada.\n");
		    	perror("Erro no shmctl");
		}//destroi a memoria compartilhada  e verifica se ocorreu erro na destruicaoão
		else{
		    	printf("%sMeus filhos ja terminaram e eu ja destrui a area de memoria compartilhada.\n",VERDE);
		    	printf("Tempo de execucao da thread filha %d: %.3lf segundos.\n",(int)threadfilha,tempo_T);
		    	printf("Tempo de execucao do processo filho %d: %.3lf segundos\n",(int)filhoid,tempo_P);
		    	printf("Agora eu irei terminar.\n");
		    	fprintf(arq_log,"Meus filhos ja terminaram e eu ja destrui a area de memoria compartilhada e o semaforo.\n");
		    	fprintf(arq_log,"Tempo de execucao da thread filha %d: %.3lf segundos\n",(int)threadfilha,tempo_T);
		    	fprintf(arq_log,"Tempo de execucao do processo filho %d: %.3lfsegundos\nAgora eu irei terminar.\n",(int)filhoid,	tempo_P);
		}	

	}//pai executa
	fclose(arq_log);//fecha arquivo de log
	printf("%s\n",NORMAL);
	return 0;
}

void processothread(void){

	printf("%sA thread filha %d ira comecar a executar.\n\n",AMARELO,(int)pthread_self());
	filho(1,arq_log,semid);
	ftime(&fim_T);
	pthread_exit(0);
	
}//thread filha executando

