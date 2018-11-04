/**************************************************
Trabalho final de Computação Gráfica.
---------------------------------------------------
Wellington Rodrigo de Freitas Costa - 29/06/2010
**************************************************/

#include "bibliotecas.h"
#include "definicoes.h"
#include "funcoes.h"

/*funções para controle do programa*/
void DesenharPiso(void){
     pisos=comprimento/tamanho_piso;  
     for(int i=-pisos;i<=pisos;i++){
       if(i%2){
       cor_piso=true;
       }else{
         cor_piso=false;
       }       
       for(int j=-pisos;j<pisos;j++){
        if(cor_piso){
           glColor3f(VERMELHO);
           cor_piso=false;
         }else{
           glColor3f(PRETO);
           cor_piso=true;
         }
         glRecti(tamanho_piso*j,tamanho_piso*i-tamanho_piso,tamanho_piso*j+tamanho_piso,tamanho_piso*i);      
       }
    } 
};

void DesenharObjeto(int animar){
     double movimento;
    bool cresce;
    float x,z;
    if(animar){
      tempo=glutGet(GLUT_ELAPSED_TIME)/500.0;
      movimento = tempo*90.0;
      if(cresce){
         x += 0.1;
         z += 0.1;
         if(x+z > comprimento) cresce = false;
      }else{
         x -= 0.1;
         z -= 0.1; 
         if(x-z < 0) cresce = true;
      }
    }
    glPushMatrix();
      glTranslatef(0,120,0);
      glRotated(movimento,0,0,1);
      glTranslatef(x+100,0,-z+100);
      glColor3f(VERDE);
      glutSolidCone(40,60,100,100);
    glPopMatrix();
};

void temporizador(int tempo){
     glutPostRedisplay();
     glutTimerFunc(30,temporizador,1);     
};

void RotacionarDireita(void){
     angulo_camerazx+=incremento_angulo_camera;
     glwVisualizacao();
     glutPostRedisplay(); 
};

void RotacionarEsquerda(void){
     angulo_camerazx-=incremento_angulo_camera;
     glwVisualizacao();
     glutPostRedisplay(); 
};
