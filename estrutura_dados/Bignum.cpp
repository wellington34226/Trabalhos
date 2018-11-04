/*Métodos para uso de inteiros grandes calcula fatorial de inteiros grandes.*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define TB 700001

void converteBigNum(int numB[],int numP);//cenverte um  inteiro em inteiro grande
void multiplicaPB(int numB[],int numP);//multiplica um inteiro por um inteiro grande
void imprimeBN(int numB[]);//imprime um inteiro grande
void fatorialBN(int numB[],int fac);//calcula o fatorial de um inteirogrande
void somaBNS(int numB1[],int numB2[]);//soma dois bignumbers e coloca o resultado em outro bignumber

int num1[TB],num2[TB],resultado[TB];//representação do inteiro grande com vetor

int main(int argc, char *argv[]){
    int numero=-1,i,j,k,numero2;
    do{
          printf("Informe um numero para calcular o fatorial:");
          scanf("%d",&numero);
     }while(numero<0);//aguarda um inteiro positivo para calcular o fatorial
     if(numero==0){
          printf("\nFatorial de 0 = 1");
          exit(0);
     }//imprime o fatorial de 0.
     printf("\nFatorial de %d = ",numero);
     fatorialBN(resultado,numero);//chama funcao que calcula o fatorial
     imprimeBN(resultado);//imprime um inteiro grande.
     printf("\n");
     printf("Informe dois numeros para somar:");
     scanf("%d%d",&numero,&numero2);
     if((numero==0)||(numero2==0)){
          printf("%d+%d=%d",numero,numero2,numero2);
     }else{
          converteBigNum(num1,numero);
          converteBigNum(num2,numero2);
          somaBNS(num1,num2);
          imprimeBN(resultado);
          printf("\n");    
     }
     system("pause");
     exit(0);
}
void converteBigNum(int numB[],int numP){
     int i,numero=numP;
     if(numP>0) numB[0]=1;
     else {
          numB[0]=(-1);
          numero=-numero;    
     }
     for(i=TB-1;i>0;i--){
        numB[i]=numero%10;
        numero= numero/10;
     }
}//recebe um inteiro grande para receber a conversao e um inteiro que sera convertido
void imprimeBN(int numB[]){
    int i=1,j;
    while((numB[i]==0)&&(i<TB))i++;
    if(i>=TB) printf("0");
    else{
        if(numB[0]<0) printf("-");
        for(j=i;j<TB;j++)printf("%d",numB[j]);
    }
}//recebe um inteiro grande e imprime.
void multiplicaPB(int numB[],int numP){
    int i,v1,x,numero=numP;
    if(numero<0){
          resultado[0]=numB[0]*(-1);
          numero=-numero;    
    }else resultado[0]=numB[0];
    v1= 0;
    for(i=TB-1;i>0;i--){
        x=(numB[i]*numero)+v1;
        resultado[i]=x%10;
        v1=x/10;
    }
}//recebe um inteiro  grande e um inteiro multiplica um pelo outro e coloca o resultado em um inteiro grande
void fatorialBN(int numB[],int fac){
    int i,v1,x,numero=fac;
    if(numero<0){
         exit(0);    
    }
    numB[0]=1;
    numB[TB-1]=1;
    do{
          v1= 0;
          for(i=TB-1;i>0;i--){
               x=(numB[i]*numero)+v1;
               numB[i]=x%10;
               v1=x/10;
          }
          numero--;
     }while(numero>1);   
}/*recebe um inteiro grande para resultado e um inteiro para calcular o  fatorial*/
void somaBNS(int numB1[],int numB2[]){
     int i,x,v1=0,j=1,k=1;
     if(numB1[0]==numB2[0]){
          for(i=TB-1;i>0;i--){
               x=numB1[i]+numB2[i]+v1;
               resultado[i]=x%10;
               v1=x/10;
          }
          resultado[0]=numB1[0];     
     }else {
          while((numB1[j]==0)&&(j<TB))j++;
          while((numB2[k]==0)&&(k<TB))k++;
          if(j>k)resultado[0]=numB2[0];
          else if(k>j) resultado[0]=numB1[0];
               else{
                    resultado[0]=0;
                    while(resultado[0]==0){
                         if(numB1[j]>numB2[j])resultado[0]=numB1[0];
                         else if(numB1[j]<numB2[j])resultado[0]=numB2[0];
                              else j++;
                    }    
               }
          if(resultado[0]==numB1[0]){
               for(i=TB-1;i>0;i--){
                    x=numB1[i]-numB2[i]+v1;
                    if(x<0){
                         x=x+10;
                         resultado[i]=x%10;
                         v1=-1;
                    }else{
                         resultado[i]=x%10;
                         v1=x/10;
                    }    
               }
          }else{
               for(i=TB-1;i>0;i--){
                    x=numB2[i]-numB1[i]+v1;
                    if(x<0){
                         x=x+10;
                         resultado[i]=x%10;
                         v1=-1;
                    }else{
                         resultado[i]=x%10;
                         v1=x/10;
                    }    
               }               
          }
     }
}//recebe dois inteiros grandes e os somam
