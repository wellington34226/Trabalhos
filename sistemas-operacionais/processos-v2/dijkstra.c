/*implementacao do semaforo de Dijkstra utilizando IPC*/
/*sem_criar(): para criar um semaforo
 *sem_pedido(): operacao de pedido
 *sem_libera(): operacao de liberacao
 sem_destroi(): destruicao do semaforo
*/
/*criacao de um semaforo utilizando a chave key, com valor inicial inicval*/
#include "parametros.h"//inclusao da biblioteca definida pelo programador.
int sem_criar(key_t key,int iniciaval){
	int semid;
	union semun {
		int val;
		struct semid_ds *buf;
		ushort array[1];
	}arg_ctl;
	
	semid=semget(ftok("processopai.c",key),1,IPC_CREAT|IPC_EXCL|0666);
	if(semid==-1){
		semid=semget(ftok("processopai.c",key),1,0666);
		if(semid==-1){
			printf("%s\n",VERMELHO);
			perror("Erro semget().");
			printf("%s\n",NORMAL);
			return (-1);
		}
	}
	arg_ctl.val=iniciaval;
	if(semctl(semid,0,SETVAL,arg_ctl)==-1){
		printf("%s\n",VERMELHO);
		perror("Erro na inicializacao do semaforo.");
		printf("%s\n",NORMAL);
		return 0;
	}
	return(semid);
}//criacao de semaforos, recebe como parametros uma chave para a criacao do semaforo e a inicializacao do mesmo.
void sem_pedido(int semid){

	struct sembuf sempar[1];
	sempar[0].sem_num=0;
	sempar[0].sem_op=-1;
	sempar[0].sem_flg=SEM_UNDO;
	if(semop(semid,sempar,1)==-1){
		printf("%s\n",VERMELHO);
		perror("Erro na operacaco de pedido.");
		printf("%s\n",NORMAL);
		exit(1);
	}
}//pedido para entrada na area controlada pelo semaforo, recebe como parametro o id do semaforo.
void sem_libera(int semid){

	struct sembuf sempar[1];
	sempar[0].sem_num=0;
	sempar[0].sem_op=1;
	sempar[0].sem_flg=SEM_UNDO;
	if(semop(semid,sempar,1)==-1){
		printf("%s\n",VERMELHO);
		perror("Erro na operacao de liberacao.");
		printf("%s\n",NORMAL);
		exit(1);
	}
}//pedido para sair da area controlada pelo semaforo, recebe como parametro o id do semaforo.
int sem_destroi(int semid){

	if(semctl(semid,0,IPC_RMID,0)==-1){
		printf("%s\n",VERMELHO);
		perror("Erro na destruicao do semaforo.");
		printf("%s\n",NORMAL);
		return -1;
	}
	return 0;
}//destruicao do conjunto de semaforos, recebe o id do semaforo corespondente.
