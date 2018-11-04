// Você vai trabalhar   com   o  percurso em  ordem simétrica  numa  árvore binária.
// Analise o programa apresentado. Escreva, APENAS, o procedimento PercIno,
// SEM MODIFICAR o restante do programa}
#include<stdio.h>
#include<stdlib.h>

typedef struct no* arv;
struct no{
       int c;
       arv ld,le;
};
arv gT;  int gi, gj, gtc, gn, gf, gr;  
int gV[100001];  arv gQ[100001];

void EsvaziaFil(void); void Enfila(arv p); arv Desenfila(void); 
void CriaArv(void); void DestroiArv(arv p);
void PercIno(arv p);

int main(){
	scanf("%d",&gtc);
    for (gi = 1;gi <= gtc;gi++){
        scanf("%d",&gn); for(gj = 1;gj <= gn;gj++) scanf("%d",&gV[gj]);
        CriaArv();
        PercIno(gT);
        system("pause");
        DestroiArv(gT);
	}
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

void PercIno(arv p){
// Algoritmo recursivo de busca em ordem simétrica:
       if(p!=NULL){
            PercIno(p->le);
	        printf("%d",p->c);
            PercIno(p->ld);
       }
// Exemplo de entrada:
// 2
// 10 1 2 3 4 5 6 7 8 9 10
// 1 1
// Exemplo de Saida
// 7 3 6 1 2 5 10 9 4 8
// 1
}
