/*Ordenação por Distribuição
1. Observe os algoritmos de tratamento das filas.
2. Observe que o algoritmo executa sempre 10 passos de ordenação, mesmo que
   o maior número seja pequeno.
3. Corrija o programa para só fazer o número de passos necessário.*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define FILAS 11
//definicoes dos tipos fila encadeada e lista encadeada
typedef struct tfila fila;
typedef struct link* no;
/*funcoes*/
void imprime(int situacao);//impressao da fila 10
long int digito(long int d,long int k);//verificacao do digito do algarismo
void enfila(int nf,int k);//enfila k na fila nf
int desenfila(int nf);//desenfila da fila nf
void inicializa(void);//incializacao da fila 10
void ordena(void);//ordenacao uilizando filas
//definicao de lista encadeada
struct link{
	int valor;
	no prox;
};//definicao do no com um inteiro como valor e um ponteiro para o proximo no
//definicao de fila com lista encadeada
struct tfila{
     no f,r; 
};//fila com frente e retarguada ponteiros para no
//variaveis globais
int n;
fila filas[FILAS];//declaracao das 11 filas
//main
int main(int argc, char *argv[]){
     inicializa();//inicaliza
     imprime(1);//imprime situacao inicial
     ordena();//inicializa ordenacao
     imprime(3);//imprime situacao final
     system("pause");//aguarda para sair do programa apenas para windows
     exit(0);//sai do programa
}
void imprime(int situacao){
     no p;
     p=filas[FILAS-1].f;//o ponteiro p recebe o frente da fila 10
     if(situacao==1)printf("Situacao Inicial: ");//se for 1 é a situacao inicial
     else if(situacao==2)printf("Situacao Intermediaria: ");
          //se for 2 e situacao intermediaria
          else printf("Situacao Final: ");//se for 3 e a situacao final
     while(p!=NULL){
          printf("%d ",p->valor);
          p=p->prox;
     }//imprime a fila 10
     printf("\n");  
}//funcao para impressao da fila
long int digito(long int d,long int k){
     long int i,j=k; 
     for(i=1; i<d;i++)j=j/10;//vai gastando o numero até o digito d correspondente
     j=j%10;//pega so o algarismo do digito
    return j;  
}//retorna algarismo j do digito d do numero k.
void enfila(int nf,int k){
     no p;
     p=(no)malloc(sizeof(*p));//cria a area de memoria
     p->valor=k;//guarda em p o valor de k recebido na funcao
     p->prox=NULL;//faz o ponteiro proximo apontar para nulo
    if(filas[nf].r!=NULL)filas[nf].r->prox= p;/*(verifica se a fila esta vazia)
    se o ponteiro retarguada apontar para nulo o ponteiro proximo do retarguada
    aponta para p*/
    else filas[nf].f=p;//se nao o ponteiro frente recebe p
    filas[nf].r=p;//ponteiro retarguada aponta para p
}//enfila k na fila nf
int desenfila(int nf){
     int k;
     no p;
     if(filas[nf].f!=NULL){
        p=filas[nf].f;//o ponteiro p recebe a referencia para a frente da fila nf
        filas[nf].f=filas[nf].f->prox;//faz frente apontar para o proximo
        if(filas[nf].f==NULL)filas[nf].r=NULL;/*se frente apontar para nulo
        retarguada tambem apontea para nulo*/
        k=p->valor;//k recebe o valor de p
        free((void*)p);//libera o ponteiro.
     }else k=-1;//verifica se a fila esta vazia
     return k;
}//desenfila da fila nf e retorna o valor
void inicializa(void){
     int i,k;
     for(i=0;i<FILAS;i++){
          filas[i].f=NULL;
          filas[i].r=NULL;
     }//zera as filas
     printf("Informe o numero de elementos a ordenar: ");
     scanf("%d",&n);
     printf("Informe os elementos a orndenar: ");
     for(i=1;i<=n;i++){
        scanf("%d",&k);
        enfila(10,k);      
     }//preenche a fila 10 com os valores passados.
     printf("\n");
}//iniciliza o programa, zera a fila e coloca os valores recebidos
void ordena(void){
    int d, i, j, k,td=10, m,maior=0,aux=0;
    for(d=1;d<=td;d++){
         for(i=1;i<=n;i++){
             k=desenfila(10);
             //so executa quando d=1, ou seja so faz uma vez
             if(d==1){
                if(maior<k)maior=k;    
               }//modificacao para mior eficiencia na ordenacao
             m=digito(d,k);
             enfila(m,k);
         }/*separa cada numero na sua fila correspondente, de acordo com o
         digito analisado no respectivo passo*/
         
         while(maior!=0){
               aux++;
               maior=maior/10;
          }//loop para verificar qauntos algarismos tem o maior numero
          td=aux;//muda td para o valor de algarismos do maior numero
         for(j=0;j<10;j++){
               while(filas[j].f!=NULL){
                    k=desenfila(j);
                    enfila(10,k);
               }
          }/*reagrupa todos os numeros na ordem do algarismo na ultima fila*/
         imprime(2);//imprime a situcao atual.
     }//controla a passo, num total de dez passos, independente do maior numero
}/*ordena a fila 10 utilizando as filas de 0 a 9
em cada passo ele ordena o algarismo correspondente ao passo.*/
