/* Voc� vai trabalhar   com  uma arvore bin�ria que representa uma express�o aritm�tica.
Essa �rvore � estritamente bin�ria, cont�m operandos nas folhas e operadores nos n�s intermedi�rios.
Para facilitar, os operandos s�o n�meros de um d�gito apenas. Note que a entrada conter� 20 �rvores aleat�rias.
Escreva, APENAS, o procedimento CalcExp, SEM MODIFICAR o restante do programa*/
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

typedef struct no* arv;
struct no{
	char c;
	arv ld,le;
};

void EsvaziaFil(void);
void Enfila(arv p);
arv Desenfila(void); 
void CriaArv(void);
void DestroiArv(arv p);
int CalcExp(arv p);

arv gT;
int gi, gj, gk, gtc, gn, gf, gr;
char gV[100001];
arv gQ[100001];

int main(){
	srand(time(NULL));
	for (gi = 1;gi <= 20;gi++){
        gn = 2* rand()%20+1;
        for(gj = 1;gj <= gn/2;gj++)
        {   gk = rand()%3+1;
            if (gk == 1) gV[gj] = '+';
            else if (gk == 2) gV[gj] = '-';
            else if (gk == 3) gV[gj] = '*';
        }
        for(gj = gn/2+1;gj <= gn;gj++) gV[gj] = '0'+ rand()%10;           
        CriaArv();
        printf(" Resultado = %d",CalcExp(gT));
        printf("\n");
        DestroiArv(gT);
	}
	system ("pause");
	return 0;
}

void EsvaziaFil(void){
	gf = gr = 0;
}

void Enfila(arv p){
    if (p != NULL){
        gr++;  gQ[gr]= p;
        if (gf == 0) gf = 1;
	}
}

arv Desenfila(void){
    arv p;
    p = gQ[gf];
    if (gf == gr) EsvaziaFil();
    else gf++;
    return p;
}

void CriaArv(void){
	arv p,r;  int i;	
    EsvaziaFil();
    gT =(arv)malloc(sizeof(*gT));
    i = 1; gT->c = gV[i]; gT->le = gT->ld = '\0'; Enfila(gT);	 
    while (gf != 0){
        p = gQ[gf];
        if (i < gn){
            i++;  r =(arv)malloc(sizeof(*r));  
			r->c = gV[i]; r->le = r->ld = NULL; p->ld = r; Enfila(r);
        }
        if (i < gn){
			i++;  r =(arv)malloc(sizeof(*r));  
			r->c = gV[i]; r->le = r->ld = NULL; p->le = r; Enfila(r);
        }
        p = Desenfila();
    }
}

void DestroiArv(arv p){	
    if (p != NULL){
        DestroiArv(p->le);
        DestroiArv(p->ld);
        free(p);
	}
}

int CalcExp(arv p){
// Escrever o programa recursivo para calcular a express�o
	int op1, op2,resultado;
	if(p!=NULL){
		if((48-(int)p->c)<10){
			resultado=48-(int)p->c;
			
		}
		else{
			op1=CalcExp(p->le);
			op2=CalcExp(p->ld);
			switch(p->c){
				case '/':
					resultado=op1/op2;
					break;
				case '*':
					resultado=op1*op2;
					break;
				case '+':
					resultado=op1+op2;
					break;
				case '-':
					resultado=op1-op2;
					break;
				default:
					break;
			}
		}
		return resultado;
	}
}
