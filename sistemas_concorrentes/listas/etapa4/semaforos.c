/*implementacao do semaforo de Dijkstra utilizando IPC*/
/*sem_criar(): para criar um semaforo
 *sem_pedido(): operacao de pedido
 *sem_libera(): operacao de liberacao
 *sem_destroi(): destruicao do semaforo
 *par manipulacao da area de memoria compartilhada.
*/
/*criacao de um semaforo utilizando a chave key, com valor inicial inicval*/
#include "parametros.h"//inclusao da biblioteca definida pelo programador.
int sem_criar(int iniciaval){
	int semid;
	union semun {
		int val;
		struct semid_ds *buf;
		ushort array[2];
	}arg_ctl;//prepara estrutura do semaforo.
	//cria semaforo e verifica se ja existe semaforo com a chave KEY.
	if((semid=semget((ftok(PAI, (key_t)KEY )),2,IPC_CREAT|IPC_EXCL|0666))==-1){
		if(semid=semget((ftok(PAI,(key_t)KEY )),2,0666)==-1){
			printf("%s\n",VERMELHO);
			perror("Erro na criacao do semaforo.");
			printf("%s\n",NORMAL);
			return (-1);
		}//se der erro ao se aclopar sai.
	}else{//se deu erro semaforo ja existente, entao tenta so se acoplar ao mesmo.
		printf("Semaforos criado pelo processo pai - PID %d com id: %d\n",pai,semid);
		fprintf(arq_log,"Semaforos criado pelo processo pai - PID %d com id: %d.\n",pai,semid);
	}
	arg_ctl.val=iniciaval;
	if(semctl(semid,0,SETVAL,arg_ctl)==-1){
		printf("%s\n",VERMELHO);
		perror("Erro na inicializacao do semaforo 0.");
		printf("%s\n",NORMAL);
		return 0;
	}//inicializa o semaforo 0.
	if(semctl(semid,1,SETVAL,arg_ctl)==-1){
		printf("%s\n",VERMELHO);
		perror("Erro na inicializacao do semaforo 1.");
		printf("%s\n",NORMAL);
		return 0;
	}//inicializa o semaforo 1.
	return(semid);
}//criacao de semaforos, recebe como parametros uma chave para a criacao do semaforo e a inicializacao do mesmo.
void sem_pedido(int sem,int semf){
	struct sembuf sempar[1];
	sempar[0].sem_num=semf;
	sempar[0].sem_op=-1;
	sempar[0].sem_flg=SEM_UNDO;
	if(semop(sem,sempar,1)==-1){
		printf("%s\n",VERMELHO);
		perror("Erro na operacaco de pedido.");
		printf("%s\n",NORMAL);
		exit(1);
	}
}//pedido para entrada na area controlada pelo semaforo, recebe como parametro o id do semaforo.
void sem_libera(int sem,int semf){
	struct sembuf sempar[1];
	sempar[0].sem_num=semf;
	sempar[0].sem_op=1;
	sempar[0].sem_flg=SEM_UNDO;
	if(semop(sem,sempar,1)==-1){
		printf("%s\n",VERMELHO);
		perror("Erro na operacao de liberacao.");
		printf("%s\n",NORMAL);
		exit(1);
	}
}//pedido para sair da area controlada pelo semaforo, recebe como parametro o id do semaforo.
int sem_destroi(int sem){
	if(semctl(sem,0,IPC_RMID,0)==-1){
		return 0;
	}//destroi o semaforo e verifica se ocorreu erro na destruicao
	return 1;
}//destruicao do conjunto de semaforos, recebe o id do semaforo correspondente.
