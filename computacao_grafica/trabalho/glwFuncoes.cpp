/**************************************************
Trabalho final de Computação Gráfica.
---------------------------------------------------
Wellington Rodrigo de Freitas Costa - 29/06/2010
**************************************************/

#include "bibliotecas.h"
#include "definicoes.h"
#include "funcoes.h"

/*Funções para tratamento do ambiente OpenGL*/
void glwRedimencionarTela(GLsizei largura, GLsizei altura){
    int x,y,largurax=(int)largura,alturay=(int)altura;
    if(alturay ==0) alturay = 1;//evitar divisão por zero
    GLUI_Master.get_viewport_area(&x,&y,&largurax,&alturay);
    glViewport(x,y,largurax,alturay);
    fator_escala=(GLfloat)largurax/(GLfloat)alturay;
    glwVisualizacao();
};

void glwDesenhar(void){
     glClear(GL_COLOR_BUFFER_BIT);
     glPushMatrix();
       glRotatef(90,1,0,0);
       glTranslatef(0,0,(float)pisos+100);
       DesenharPiso();
     glPopMatrix();
     glPushMatrix();
       glRotatef(90,1,0,0);
       DesenharObjeto(animado);
     glPopMatrix();
     glutSwapBuffers();
};


void glwVisualizacao(void){
  if(iluminacao){
     glEnable(GL_LIGHTING);
     glEnable(GL_LIGHT0);
     glEnable(GL_COLOR_MATERIAL);
     glShadeModel(GL_SMOOTH);
  }else{
     glDisable(GL_LIGHTING);      
     glDisable(GL_LIGHT0);
     glDisable(GL_COLOR_MATERIAL);
     glShadeModel(GL_SMOOTH);
  }
  glMatrixMode( GL_PROJECTION );
  glLoadIdentity();
  gluPerspective(angulo,fator_escala,0.1,50000);
  glMatrixMode( GL_MODELVIEW );
  glLoadIdentity();
  gluLookAt(olhoX+comprimento*sin(angulo_camerazx),olhoY,olhoZ+-1+comprimento*cos(angulo_camerazx),
    olhoX,olhoY,-olhoZ,
    0,1.0,0);
  glutPostRedisplay(); 
};
