#include "parametros.h"//utilizacao de uma biblioteca predefinida pelo programador.

struct timeb inicio_T,inicio_P,fim_T,fim_P;//guarda os tempos da thread e processo
double tempo_T,tempo_P;//--------------------------------------------------------^
FILE* arq_log;//arquivo de saida

void processothread(void);//declaracao da funcao thread

int main(){

	pthread_t threadfilha; 
	int pai;//id da thread pai
	pid_t filhoid;//pid do processo filho
	mc mem_comp;//apontador para memoria compartilhada
	int memoriaid;//id da memoria compartilhada
	int nthreads=1;//quantidade de threads
	int semid;
	
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
	}//se ocorrer erro na criação da memoria compartilhada,sai do programa
	printf("Eu, o pai %d, vou criar um processo filho.\n\n", getpid());
	fprintf(arq_log,"Eu, o pai %d, vou criar um processo filho.\n\n", getpid());
	fflush(arq_log);//limpa o buffer de saida
	ftime(&inicio_P);
	if((filhoid = fork()) == -1){
		printf("%sErro ao tentar criar um processo filho.\n",VERMELHO);
		fprintf(arq_log,"Erro ao tentar criar um processo filho.\n\n", getpid());
		perror("Erro no fork.");
		printf("%s\n",NORMAL);
		return 0;
	}//criar o processo filho e verifica se ocorreu erro na criacao.
	else if(!filhoid){
		printf("%sProcesso filho ira começar a executar.\n\n",AZUL);
		fprintf(arq_log,"Processo filho ira começar a executar.\n\n");
		filho(0,arq_log);
		return 0;
	}//filho executa chamando a funcao filho
	else{
		printf("%sSou o processo pai %d. Ja criei um processo filho %d.\nAgora vou criar uma thread filha.\n\n",VERDE, getpid(),filhoid);
		fprintf(arq_log,"Sou o processo pai %d. Ja criei um processo filho %d.\nAgora vou criar uma thread filha.\n\n",getpid(),filhoid);
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
		if((shmctl(memoriaid,IPC_RMID,0))==-1){
		    printf("%sImpossivel destruir area de memoria compartilhada.\n",VERMELHO);
		    fprintf(arq_log,"Impossivel destruir area de memoria compartilhada.\n");
		    perror("Erro no shmctl");
		}//destroi a memoria compartilhada  e verifica se ocorreu erro na destruicaoão
		else{
		    printf("%sMeus filhos ja terminaram e eu ja destrui a area de memoria compartilhada.\n",VERDE);
		    printf("%sTempo de execuçao da thread filha: %.3lf segundos\nTempo de execuçao do processo filho: %.3lf segundos\n",VERDE,tempo_T,tempo_P);
		    printf("%sAgora eu irei terminar.\n",VERDE);
		    fprintf(arq_log,"Meus filhos ja terminaram e eu ja destrui a area de memoria compartilhada.\nTempo de execuçao da thread filha: %.3lf segundos\n",tempo_T);
		    fprintf(arq_log,"Tempo de execuçao do processo filho: %.3lfsegundos\nAgora eu irei terminar.\n",tempo_P);
		}	
	}//pai executa
	fclose(arq_log);//fecha arquivo
	printf("%s\n",NORMAL);
	return 0;
}//codigo principal

void processothread(void){

	printf("%sA thread filha %d irá começar a executar.\n\n",AMARELO,(int)pthread_self());
	filho(1,arq_log);
	ftime(&fim_T);
	pthread_exit(0);
	
}//thread filha executando

