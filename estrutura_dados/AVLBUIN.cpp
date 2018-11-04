/* Este programa faz busca e insercao numa AVL
  1. Leia e entenda o programa
  2. Rode o programa
  3. Melhore a visualização das mensagens, inclusive permitindo observar cada
     operação de insercao
  4. Crie uma entrada com 20 letras tal que seja obtida a AVL de altura 6.
*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define LINHAS 21
#define COLUNAS 121

typedef struct No* Arv;
struct No{
	char chave;
	int bal;
	Arv le, ld;
};

int Power(int i,int j);
void Limpa_AVL(void);
void PreparaVisualizacao(Arv P,int pos,int nivel);
void Imprime_AVL(void);
void Balanceamento_Esquerda(Arv &P);
void Balanceamento_Direita(Arv &P);
void Insere_AVL (char x,Arv &P);
void Busca_AVL (char x,Arv P);

Arv T;
char ArvTela[LINHAS][COLUNAS];
int i,f,gnivel;
char nome[1000];
bool h;

int main(int argc, char *argv[]){
	T=NULL;
	printf("Nome:");
	gets(nome);
	for(i=0;i<strlen(nome);i++){
		Busca_AVL(nome[i],T);
		if(f==1)printf("%c - chave inserida.\n",nome[i]);
		else{
			printf("%c - chave sera inserida.\n",nome[i]);
			Insere_AVL(nome[i],T);
		}
	}
	printf("\n");
	system("pause");
}

int Power(int i,int j){
	int k,pot;
	pot=i;
	for(k=1;k<j;k++)pot=pot*i;
	return pot;
}

void Limpa_AVL(void){
	int i,j;
	for(i=1;i<LINHAS;i++)
		for(j=1;j<COLUNAS;j++)ArvTela[i][j]=' ';
}

void PreparaVisualizacao(Arv P,int pos,int nivel){
	int i,pose,posd;
	if(P!=NULL){
		pose=pos-Power(2,5-nivel);
		posd=pos+Power(2,5-nivel);
		PreparaVisualizacao(P->ld,posd,nivel+1);
		PreparaVisualizacao(P->le,pose,nivel+1);
		ArvTela[nivel][pos]=P->chave;
		if(P->le!=NULL)for(i=pose;i<pos;i++)ArvTela[nivel][i]='-';
		if(P->ld!=NULL)for(i=pos+1;i<=posd;i++)ArvTela[nivel][i]='-';
		if(nivel>gnivel)gnivel=nivel;
	}
}

void Imprime_AVL(void){
	int i,j;
	Limpa_AVL();
	PreparaVisualizacao(T, 35, 1);
	for(i=1;i<=gnivel;i++){
		printf("\n");
		for(j=1;j<=70;j++)printf("%c",ArvTela[i][j]);
	}
	printf("\n");
}

void Balanceamento_Esquerda(Arv &P){
	Arv PF,PN;
	PF=P->le;
	if(PF->bal==(-1)){
		printf("\nRotacao Simples a Esquerda:\n");
		P->le =PF->ld;
		PF->ld=P;
		P->bal=0;
		P=PF;
	}else{
		printf("\nRotacao Dupla a Esquerda:\n");
		PN=PF->ld;
		PF->ld=PN->le;
		PN->le=PF;
		P->le=PN->ld;
		PN->ld=P;
		if (PN->bal==-1)P->bal=1;
		else P->bal=0;
		if(PN->bal==1)PF->bal=-1;
		else PF->bal=0;
		P=PN;
	}
	P->bal=0;
	h=false;
	Imprime_AVL();
}

void Balanceamento_Direita(Arv &P){
	Arv PF,PN;
	PF=P->ld;
	if(PF->bal==1){
		printf("\nRotacao Simples a direita:\n");
		P->ld=PF->le;
		PF->le=P;
		P->bal=0;
		P=PF;
	}else{
		printf("\nRotacao Dupla a Direita:\n");
		PN=PF->le;
		PF->le=PN->ld;
		PN->ld=PF;
		P->ld=PN->le;
		PN->le=P;
		if(PN->bal==1)P->bal=-1;
		else P->bal=0;
		if(PN->bal==-1)PF->bal=1;
		else PF->bal=0;
		P=PN;
	}
	P->bal=0;
	h=false;
	Imprime_AVL();
}

void Insere_AVL (char x,Arv &P){
	if(P==NULL){
		P=(Arv)malloc(sizeof(*P));
		P->chave=x;
		P->bal=0;
		P->le=NULL;
		P->ld=NULL;
		if(T==NULL)T=P;
		h=true;
		Imprime_AVL();
	}else
		if(x<P->chave){
			Insere_AVL(x,P->le);
			printf("inseriu esquerdo.\n");
			if(h){
				switch (P->bal){
					case 1:
						P->bal= 0;
						h= false;
						break;
					case 0:
						P->bal= -1;
						break;
					case -1:
						Balanceamento_Esquerda(P);
						break;
					default:
						break;
				}
			}
		}else{
			Insere_AVL(x, P->ld);
			printf("inseriu direito.\n");
			if(h){
				switch(P->bal){
					case 1:
						Balanceamento_Direita(P);
						break;
					case 0:
						P->bal= 1;
						break;
					case -1:
						P->bal= 0;
						h= false;
						break;
					default:
						break;
				}
			}
		}
}

void Busca_AVL (char x,Arv P){
	if(P==NULL)f=0;
	else if(P->chave==x)f=1;
		else if(x < P->chave){
				if(P->le==NULL)f=2;
				else{
					P=P->le;
					Busca_AVL(x, P);
				}
			}else{
				if(P->ld==NULL)f=3;
				else{
					P=P->ld;
					Busca_AVL (x, P);
				}
			}
}
