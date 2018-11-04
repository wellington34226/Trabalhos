//bibliotecas utilizadas no c√digo.
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
#include <sys/wait.h>
#include <math.h>
#include <string.h>
//defini√√es das constantes utilizadas no programa.
#define KEY 2147483647
#define AMARELO "\033[1;33m" 
#define VERMELHO "\033[1;31m" 
#define VERDE "\033[1;32m"
#define AZUL "\033[1;34m"  
#define NORMAL "\033[0m" 

typedef struct pilha* mc;//defini√√o de um apontador para a estrutura pilha.

struct pilha{
	int p[11];
	int topo;
};//estrutura da pilha, com um array de inteiros e um inteiro para indicar o topo.

int push(int n,int* pilha, int* topo,FILE* log);//fun√√o de inlcus√o na pilha
int pop(int* pilha, int* topo,FILE* log);//fun√√£ode remo√√o da pilha
void imprimir_pilha(FILE* log,mc pilha);//fun√√£o para impress√o da pilh
mc acoplar_mem(int *memoriaid,char* pai,int id_tp,FILE* log);//acoplamento na √rea de mem√ria compartilhada.
mc criar_mem(int *memoriaid,char* pai,FILE* log);//cria√√o da √rea de mem√ria compartilhada.
int filho(int argc,FILE* log);//execu√√£o do processo/thread filh.
