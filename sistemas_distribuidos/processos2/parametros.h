//bibliotecas utilizadas para a execucao do programa
#include <stdio.h>
#include <sys/types.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <sys/ipc.h>
#include <pthread.h>
#include <sys/timeb.h>
#include <errno.h>
#include <sys/shm.h>
#include <unistd.h>
#include <sys/sem.h>
#include <sys/wait.h>
#include <math.h>
#include <string.h>
//definicoes das constantes utilizadas
#define KEY 2147483647
#define AMARELO "\033[1;33m" 
#define VERMELHO "\033[0;31m" 
#define VERDE "\033[1;32m"
#define AZUL "\033[1;34m"  
#define NORMAL "\033[0m" 

typedef struct pilha* mc;//definicao de apontador da estrutura pilha

struct pilha{
	int p[11];
	int topo;
};//definicao da estrutura pilha

//funcoes de manipulacao da pilha
int push(int n,int* pilha, int* topo,FILE* log);//declaracao da funcao de empilhamento
int pop(int* pilha, int* topo,FILE* log);//declaracao da funcao de desempilhamento
void imprimir_pilha(FILE* log,mc pilha);//declaracao da funcao de impressao da pilha

//funcoes de manipulacao da memoria compartilhada
mc acoplar_mem(int *memoriaid,char* pai,int id_tp,FILE* log);//declaracao da funcao de acoplamento a area de memoria compartilhada
mc criar_mem(int *memoriaid,char* pai,FILE* log);//declaracao da funcao de criacao da area de memoria compartilhada

int filho(int argc,FILE* log,int semid);//declaracao da funcao que tem o codigo que devera ser executado pela thread e pelo proceosso filho.

//funcoes de manipilacao de semaforo
int sem_criar(key_t key,int iniciaval);//funca ode criacao de semaforo
void sem_pedido(int semid);//funcao de pedido de entrada na area de memoria compartilhada, bloqueia o semaforo 
void sem_libera(int semid);//funcao de pedido de saida da area de memoria compartilhada, liberando o semaforo
int sem_destroi(int semid);//funcao que destroi o semaforo
