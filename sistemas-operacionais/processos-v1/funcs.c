#include "parametros.h"/*utilização de uma bliblioteca definida manualmente, para que não haja a necessidade de se declarar a mesma biblioteca em todos os códigos.*/

int push(int n,int* pilha,int* topo){

	if(*topo == 10){
			return 0;
	}
	else
		pilha[(*topo)]= n;
	(*topo)++;
}

int pop(int* pilha, int* topo){

	if(!(*topo)){
			return 0;
	}
	else
		return pilha[(*topo)--];
}
