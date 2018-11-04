// Você vai trabalhar   com   o  percurso em  pré-ordem  numa  árvore binária.
// Analise o programa apresentado. Escreva, APENAS, o procedimento PercNiv,
// SEM MODIFICAR o restante do programa}
#include<stdio.h>
#include<stdlib.h>

typedef struct no* arv;
struct no{
       int c;
       arv ld,le;
};
arv gT;

void EsvaziaFil(void);
void Enfila(arv p);
arv Desenfila(void); 
void CriaArv(void);
void DestroiArv(arv p);
void EsvaziaPil(void);
void PUSH(arv p);
arv POP(void);

int gi, gj, gtc, gn, gf, gr, gtopo;  
int gV[100001];
arv gQ[100001];
arv gS[100001];

void PercPre(void){
	arv p;
    EsvaziaPil();
    PUSH(gT);
	while(gtopo > 0){
        p=POP();
        printf("%d ",p->c);
        PUSH(p->ld);
        PUSH(p->le);
      }
      printf("\n");
}

int main(){
	scanf("%d",&gtc);
    for (gi = 1;gi <= gtc;gi++){
        scanf("%d",&gn); for(gj = 1;gj <= gn;gj++) scanf("%d",&gV[gj]);
        CriaArv();
        PercPre();
        DestroiArv(gT);
	}
	return 0;
}

void EsvaziaPil(void){
     gtopo = 0;
}     
void PUSH(arv p){
     if (p != NULL){
         gtopo++; gS[gtopo] = p;
     }      
}
arv POP(void){
    arv p;
    p = gS[gtopo]; gtopo--;
    return p;
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

