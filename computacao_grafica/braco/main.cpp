/*
 Bra�o mec�nico, muda �ngulo de l1 caso as setas para direita ou esquerda seja pressionad
 e o muda o �ngulo de l2 caso sejam as setas para cima ou para baixo.
 Se a tecla ESC for precionado aborta o programa.
 */

#include <GL/glut.h>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>

static int Q1=0;//algulo de l1
static int Q2=0;//angulo de l2
static int incrementoAngulo = 10;//incremento dos algulos Q1 e Q2
static char angulos[40] = "Angulo Q1 = 0 e Angulo Q2 = 0";
GLfloat janela;
GLint tela_largura, tela_altura;
bool cor_piso=false;
float tamanho_pisox=0.1,tamanho_pisoy=0.1,comprimento=50.0,largura=30.0,altura=20.0;
int pisos_c,pisos_l;
/* Fun��es para manipula��o do OpenGL*/
//{
static void redimencionar(GLsizei largura, GLsizei altura)
{
    if(altura ==0) altura = 1;//evitar divis�o por zero
    glViewport(0, 0, largura, altura);
    tela_largura = largura;
    tela_altura = altura;
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();//limpa a pilha de matrize carregando a matriz identidade
    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();//limpa a pilha de matrize carregando a matriz identidade
    if (largura <= altura) 
       gluOrtho2D(0.0f, 25.0f, 0.0f, 25.0f*altura/largura);
    else 
       gluOrtho2D(0.0f, 25.0f*largura/altura, 0.0f, 25.0f);
    gluOrtho2D (-janela, janela, -janela, janela);//define a janela de visualiza��o
}//fun��o para o redimencionamento da tela

static void textoTela(char *texto){  
         
   glPushMatrix();// Posi��o do texto na tela          
   glRasterPos2f(-janela,janela-(janela*0.08));// Exibe caracter a caracter
   while(*texto) glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18 ,*texto++); //Exibe o texto
   glPopMatrix();
}//fun��o para impress�o de texto na tela

static void desenhar(void)
{
    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
    glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT);
    glClearColor(1,1,1,1);
    glPushMatrix();
    for(int i=-pisos_l+1;i<=pisos_l;i++){
       if(i%2){
       cor_piso=true;
       }else{
         cor_piso=false;
       }
       glPushMatrix();
       for(int j=-pisos_c;j<pisos_c;j++){
         if(cor_piso){
           glColor3f(1.0f, 0.0f, 0.0f);
           cor_piso=false;
         }else{
           glColor3f(0.0f, 0.0f, 0.0f);
           cor_piso=true;
         }
         glRectf(tamanho_pisox*((float)j),tamanho_pisoy*(float)i-tamanho_pisoy,tamanho_pisox*((float)j)+tamanho_pisox,tamanho_pisoy*((float)i));
       }  
    }
    glPopMatrix();    
    glPushMatrix();
    //Desenha primeiro segmento
    glColor3d(0,0,1);
    glTranslated(0,0,0);
    glRotated(Q1,0,0,1);
    glBegin(GL_LINES);
       glVertex2f(0,0);
       glVertex2f(0.2,0);               
    glEnd();
    //Desenha segundo segmento
    glPushMatrix();
    glTranslated(0.2,0,0);
    glRotated(Q2,0,0,1);
    glColor3d(0,1,0);
    glBegin(GL_LINES);
       glVertex2f(0.0,0.0);
       glVertex2f(0.2,0.0);               
    glEnd();
    glPopMatrix();
    //Desenha texto modificado
    glColor3d(1,1,1);
    glTranslated(-0.9,0.8,0);
    textoTela(angulos);
    glPopMatrix();
    glutSwapBuffers();
}//fun��o para cria��o das matrizes do OpenGL

static void tecladoEsc(unsigned char tecla, int x, int y)
{    
    if(tecla == 27) exit(0);

    glutPostRedisplay();
}//fun��o que verifica eventos de teclado, se a tecla ESC foi pressionad.

static void tecladoSetas(int tecla, int x, int y){
  
     switch(tecla){
         case GLUT_KEY_RIGHT: // seta para esquerda
            Q1 = (Q1+incrementoAngulo)%360;
            sprintf(angulos, "Angulo Q1 = %d e Angulo Q2 = %d", Q1,Q2);           
            break;
        case GLUT_KEY_LEFT: // seta para a direita
            if(Q1 <= 0)
               Q1 = (360-Q1);
            Q1 = (Q1-incrementoAngulo)%360;
            sprintf(angulos, "Angulo Q1 = %d e Angulo Q2 = %d", Q1,Q2);
            break;
        case GLUT_KEY_UP: // seta para cima
            Q2 = (Q2+incrementoAngulo)%360;
            sprintf(angulos, "Angulo Q1 = %d e Angulo Q2 = %d", Q1,Q2); 
            break;
        case GLUT_KEY_DOWN: // seta para baixo
            if(Q2 <= 0)
               Q2 = (360-Q2);
            Q2 = (Q2-incrementoAngulo)%360;
            sprintf(angulos, "Angulo Q1 = %d e Angulo Q2 = %d", Q1,Q2); 
            break;       
     }
     glutPostRedisplay();   
}//fun��o que verifica eventos de teclado, se as setas do teclado foram pressionads.

static void aguardar(void)
{
    glutPostRedisplay();
}//fun��o para aguardar algum evento para atualiza��o da tela.

/* Padr�o do Glut*/
const GLfloat light_ambient[]  = { 0.0f, 0.0f, 0.0f, 1.0f };
const GLfloat light_diffuse[]  = { 1.0f, 1.0f, 1.0f, 1.0f };
const GLfloat light_specular[] = { 1.0f, 1.0f, 1.0f, 1.0f };
const GLfloat light_position[] = { 2.0f, 5.0f, 5.0f, 0.0f };

const GLfloat mat_ambient[]    = { 0.7f, 0.7f, 0.7f, 1.0f };
const GLfloat mat_diffuse[]    = { 0.8f, 0.8f, 0.8f, 1.0f };
const GLfloat mat_specular[]   = { 1.0f, 1.0f, 1.0f, 1.0f };
const GLfloat high_shininess[] = { 100.0f };
//}

/* Inicializa��o do Programa Bra�o*/
int main(int argc, char *argv[])
{
    pisos_c=(int)(comprimento/tamanho_pisox);
    pisos_l=(int)(largura/tamanho_pisoy);
    glutInit(&argc, argv);//inicializa glut
    glutInitWindowSize(800,600);//inicializa janela
    glutInitWindowPosition(0,0);//inicializa posi��o da janela
    glutInitDisplayMode(GLUT_RGB | GLUT_DOUBLE | GLUT_DEPTH);//define os modos da janela

    glutCreateWindow("Bra�o Articulado");//define t�tulo da janela
    glutReshapeFunc(redimencionar);//chama fun��o redimencionar
    glutDisplayFunc(desenhar);//chama fun��o desenhar
    glutKeyboardFunc(tecladoEsc);//chama fun��o tecladoEsc
    glutSpecialFunc(tecladoSetas);//chama fun��o tecladoSetas
    glutIdleFunc(aguardar);//chama fun��o de aguardar
    glutMainLoop(); //inicia o loop do main

    return EXIT_SUCCESS; // sai com sucesso
}

