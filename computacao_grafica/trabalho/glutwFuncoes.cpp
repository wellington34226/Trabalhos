/**************************************************
Trabalho final de Computação Gráfica.
---------------------------------------------------
Wellington Rodrigo de Freitas Costa - 29/06/2010
**************************************************/

#include "bibliotecas.h"
#include "definicoes.h"
#include "funcoes.h"

/*Funções para utilização do glut*/
void glutwTecladoEsc(unsigned char tecla, int x, int y){
     if(tecla == 27) exit(0);
     glutPostRedisplay();
};

void glutTecladoSetas(int tecla, int x, int y){
     switch(tecla){
        case GLUT_KEY_RIGHT:
            RotacionarDireita();           
            break;
        case GLUT_KEY_LEFT:
            RotacionarEsquerda();
            break;
     }       
};

void glutwAguardar(void){
     if ( glutGetWindow() != id_janela){
        Sleep(100);
        glutSetWindow(id_janela);
        }
     glutPostRedisplay();
};
