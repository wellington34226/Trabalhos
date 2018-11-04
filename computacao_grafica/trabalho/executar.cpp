/**************************************************
Trabalho final de Computação Gráfica.
---------------------------------------------------
Wellington Rodrigo de Freitas Costa - 29/06/2010
**************************************************/

#include "bibliotecas.h"
#include "definicoes.h"
#include "funcoes.h"

/*variáveis globais do ambiente*/
int id_janela,iluminacao=1,animado=1;
int comprimento=300,tamanho_piso=10,pisos;
float incremento_angulo_camera=1;
float angulo_camerazy=0,angulo_camerazx=0;
double tempo=0.0;
bool cor_piso=false;
GLfloat fator_escala, angulo=100;
GLdouble olhoX=0.0, olhoY=0.0, olhoZ=0.0;

/*função main*/
int main(int argc, char* argv[]){
  glutInitDisplayMode( GLUT_RGB | GLUT_DOUBLE);
  glutInitWindowPosition(0,0);
  glutInitWindowSize(GetSystemMetrics(SM_CXSCREEN)-20,GetSystemMetrics(SM_CYSCREEN)-70);
  id_janela = glutCreateWindow( "Wellington Tranbalho Final" );
  glClearColor( 1.0f, 1.0f, 1.0f, 1.0f );
  glutDisplayFunc(glwDesenhar);
  glutReshapeFunc(glwRedimencionarTela);
  glutKeyboardFunc(glutwTecladoEsc);
  glutSpecialFunc(glutTecladoSetas);
  glutTimerFunc(30,temporizador,1);  
  gluiwBotoes();
  glutMainLoop();
}



