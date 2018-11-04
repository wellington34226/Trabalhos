// Você vai trabalhar   com   o  percurso em  pós-ordem  numa  árvore binária.
// Analise o programa apresentado. Escreva, APENAS, o procedimento PercPos,
// SEM MODIFICAR o restante do programa}
#include<stdio.h>
#include<stdlib.h>

typedef struct no* arv;
struct no{
       int c;
       arv ld,le;
};
struct nop{
       arv p;
       int vez;
};

void EsvaziaFil(void);
void Enfila(arv p);
arv Desenfila(void); 
void CriaArv(void);
void DestroiArv(arv p);
void EsvaziaPil(void);
void PUSH(nop np);
nop POP(void);

arv gT;
int gi, gj, gtc, gn, gf, gr, gtopo;  
int gV[100001];
arv gQ[100001];
nop gS[100001];

void PercPos(void){
	nop np;
    EsvaziaPil();
    np.p=gT;
	while((np.p!=NULL)||(gtopo > 0)){
        while(np.p!=NULL){
              np.vez=1;  
              PUSH(np);
              np.p=np.p->le;               
        }
        while((np.p==NULL)&&(gtopo!=0))
              np=POP();
              if((np.vez==1)&&(np.p->ld!=NULL)){
                     np.vez=2;
                     PUSH(np);
                     np.p=np.p->ld;
              }else{
                    printf("%d ",np.p->c);
                    np.p=NULL;
                    }
      }
      printf("\n");
}

int main(){
	scanf("%d",&gtc);
    for (gi = 1;gi <= gtc;gi++){
        scanf("%d",&gn); for(gj = 1;gj <= gn;gj++) scanf("%d",&gV[gj]);
        CriaArv();
        PercPos();
        DestroiArv(gT);
	}
	return 0;
}

void EsvaziaPil(void){
     gtopo = 0;
}     
void PUSH(nop np){
     if (np.p != NULL){
         gtopo++; gS[gtopo] = np;
     }      
}
nop POP(void){
    nop np;
    np = gS[gtopo]; gtopo--;
    return np;
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

