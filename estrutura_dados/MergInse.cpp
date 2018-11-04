/* Teste de ordenação pelo Mergesort e por Inserção
Este programa mostra a ordenação pelo Mergesort e por Inserção, exibindo os 40
primeiros elementos em três situações: vetor já ordenado, vetor desordenado e
vetor inversamente ordenado.
O aluno deve rodar o  programa modificando o valor de n para 100, 1000, 10000,
100000, 1000000 e  observando o tempo de execução, para cada situação.*/
#include<stdio.h>
#include<stdlib.h>
#include <sys/time.h>
#include <sys/timeb.h>
#define TAMANHO 10000005//tamanho maximo do vetor

struct timeb inicioInsercao,fimInsercao,inicioMergeSort,fimMergeSort;/*estruturas para ontagem do tempo em segundos, cada estrurua contem dois inteiros
onde cada interi recebe o tempo atual, a parte iteira vai para o inteiro time e a parte decimal para o inteiro millitm*/

void Insercao(void);//funcao insercao
void Merge(int e,int m,int d);//funcao merge
void MergeSort(int e,int d);//funcao mergesort
void executar(void);//funcao para executar os testes

int V[TAMANHO],Va[TAMANHO];
int i,j,n,t;
double tempoMergeSort,tempoInsercao;/*tempo de execução para o MergeSort e para a Insercao respectivamente*/

int main(int argc, char *argv[]){
	n=100;
	printf("Teste para n=%d.\n",n);
	system("pause");
	executar();
	n=1000;
	printf("Teste para n=%d.\n",n);
	system("pause");
	executar();
	n=10000;
	printf("Teste para n=%d.\n",n);
	system("pause");
	executar();
	n=100000;
	printf("Teste para n=%d.\n",n);
	system("pause");
	executar();
	n=100000;
	printf("Teste para n=%d.\n",n);
	system("pause");
	executar();
	printf("Encerrar o programa.\n");
	system("pause");
	exit(0);
}

void Insercao(void){
	int s,r;
	for(s=2;s<=n;s++){
		r=s;
		t=V[s];
		V[0]=t;
		while(V[r-1]>t){
			V[r]=V[r-1];
			r--;
		}
		V[r]=t;
	}
}/*funcao para a execucao da ordenacao por insercao*/

void Merge(int e,int m,int d){
	int s=e,r=m+1,k=0;
	while((s<=m)&&(r<=d)){
		k++;
		if(V[s] < V[r]){
			Va[k]=V[s];
			s++;
		}else{
			Va[k]=V[r];
			r++;
		}
	}
	while(s<=m){
		k++;
		Va[k]=V[s];
		s++;
	}
	while(r<=d){
		k++;
		Va[k]=V[r];
		r++;
	}
	for(k=e;k<=d;k++)V[k]=Va[(k-e)+1];
}/*funcao merge para unir vetores*/

void MergeSort(int e,int d){
	int m;
	if(d>e){
		m=(e+d)/2;
		MergeSort(e,m);
		MergeSort(m+1,d);
		Merge(e,m,d);
	}
}/*funcao para ordenacao por mergesort*/
void executar(void){
	/*teste 1 - Vetor ordenado MergeSort*/
	for(i=1;i<=n;i++)V[i]=i;
	printf("Teste 1 - Situacao inicial(vetor ordenado) primeiros 40 elementos - MergeSort:\n");
	for(i=1;i<=40;i++)printf("%d ",V[i]);
	printf("\n");
	system("pause");
	ftime(&inicioMergeSort);
	MergeSort(1,n);
	ftime(&fimMergeSort);
	tempoMergeSort=(((double) fimMergeSort.time + ((double) fimMergeSort.millitm * 0.001))-((double) inicioMergeSort.time + ((double) inicioMergeSort.millitm * 0.001)));
	printf("Situacao final(primeiros 40 elementos):\n");
	for(i=1;i<=40;i++)printf("%d ",V[i]);
	printf("\nTempo de execucao MergeSort: %lfsegundos.\n",tempoMergeSort);
	system("pause");

	/*Teste 1 - Vetor ordenado - Inserção*/
	for(i=1;i<=n;i++)V[i]=i;
	printf("\n\nTeste 1 - Situacao inicial(vetor ordenado) primeiros 40 elementos - Insercao):\n");
	for(i=1;i<=40;i++)printf("%d ",V[i]);
	printf("\n");
	system("pause");
	ftime(&inicioInsercao);
	Insercao();
	ftime(&fimInsercao);
	tempoInsercao=(((double) fimInsercao.time + ((double) fimInsercao.millitm * 0.001))-((double) inicioInsercao.time + ((double) inicioInsercao.millitm * 0.001)));
	printf("Situacao final(primeiros 40 elementos):\n");
	for(i=1;i<=40;i++)printf("%d ",V[i]);
	printf("\nTempo de execucao Insercao: %lfsegundos.\n",tempoInsercao);
	system("pause");

	/*Teste 2 - Vetor desordenado MergeSort*/
	for(i=1;i<=n/2;i++)V[i]=2*i;
	for(i=1;i<=n/2;i++)V[(n/2)+i]=(2*i)-1;
	printf("\n\nTeste 2 - Situacao inicial(vetor desordenado) primeiros 40 elementos) - Mergesort:\n");
	for(i=1;i<=40;i++)printf("%d ",V[i]);
	printf("\n");
	system("pause");
	ftime(&inicioMergeSort);
	MergeSort(1,n);
	ftime(&fimMergeSort);
	tempoMergeSort=(((double) fimMergeSort.time + ((double) fimMergeSort.millitm * 0.001))-((double) inicioMergeSort.time + ((double) inicioMergeSort.millitm * 0.001)));
	printf("Situacao final(primeiros 40 elementos):\n");
	for(i=1;i<=40;i++)printf("%d ",V[i]);
	printf("\nTempo de execucao MergeSort: %lfsegundos.\n",tempoMergeSort);
	system("pause");

	/*Teste 2 - Vetor desordenado Inserção*/
	for(i=1;i<=n/2;i++)V[i]=2*i;
	for(i=1;i<=n/2;i++)V[(n/2)+i]=(2*i)-1;
	printf("\n\nTeste 2 - Situacao inicial(vetor desordenado) primeiros 40 elementos) - Insercao:\n");
	for(i=1;i<=40;i++)printf("%d ",V[i]);
	printf("\n");
	system("pause");
	ftime(&inicioInsercao);
	Insercao();
	ftime(&fimInsercao);
	tempoInsercao=(((double) fimInsercao.time + ((double) fimInsercao.millitm * 0.001))-((double) inicioInsercao.time + ((double) inicioInsercao.millitm * 0.001)));
	printf("Situacao final(primeiros 40 elementos):\n");
	for(i=1;i<=40;i++)printf("%d ",V[i]);
	printf("\nTempo de execucao Insercao: %lfsegundos.\n",tempoInsercao);
	system("pause");

	/*Teste 3 - Vetor inversamente ordenado MergeSor*/
	for(i=n;i>=1;i--)V[i]=(n-i)+1;
	printf("\n\nTeste 3 - Situacao inicial(vetor inv. ordenado) primeiros 40 elementos) - MergeSort:\n");
	for(i=1;i<=40;i++)printf("%d ",V[i]);
	printf("\n");
	system("pause");
	ftime(&inicioMergeSort);
	MergeSort(1,n);
	ftime(&fimMergeSort);
	tempoMergeSort=(((double) fimMergeSort.time + ((double) fimMergeSort.millitm * 0.001))-((double) inicioMergeSort.time + ((double) inicioMergeSort.millitm * 0.001)));
	printf("Situacao final(primeiros 40 elementos):\n");
	for(i=1;i<=40;i++)printf("%d ",V[i]);
	printf("\nTempo de execucao MergeSort: %lfsegundos.\n",tempoMergeSort);
	system("pause");

	/*Teste 3 - Vetor inversamente ordenado Inserção*/
	for(i=n;i>=1;i--)V[i]=(n-i)+1;
	printf("\n\nTeste 3 - Situacao inicial(vetor inv. ordenado) primeiros 40 elementos) - Insercao:\n");
	for(i=1;i<=40;i++)printf("%d ",V[i]);
	printf("\n");
	system("pause");
	ftime(&inicioInsercao);
	Insercao();
	ftime(&fimInsercao);
	tempoInsercao=(((double) fimInsercao.time + ((double) fimInsercao.millitm * 0.001))-((double) inicioInsercao.time + ((double) inicioInsercao.millitm * 0.001)));
	printf("Situacao final(primeiros 40 elementos):\n");
	for(i=1;i<=40;i++)printf("%d ",V[i]);
	printf("\nTempo de execucao Insercao: %lfsegundos.\n\n",tempoInsercao);
	system("pause");
}/*funcao para a execucao dos tres teste (Vetor ordenado, Vetor desordenado e Vetor inversamente ordenado)
com os dois métodos de ordenacao (MergeSort e Insercao)*/
