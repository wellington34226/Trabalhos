/**************************************************
Trabalho final de Computação Gráfica.
---------------------------------------------------
Wellington Rodrigo de Freitas Costa - 29/06/2010
**************************************************/

/*funcões para utilização do OpenGL*/
void glwRedimencionarTela(GLsizei largura, GLsizei altura);
void glwDesenhar(void);
void glwVisualizacao(void);

/*funções para utilização do glut*/
void glutwTecladoEsc(unsigned char tecla, int x, int y);//sai se ESC for precionado.
void glutTecladoSetas(int tecla, int x, int y);//modifica câmera com setas.
void glutwAguardar(void);//aguarda alguma ação.

/*funções para utilização do glui*/
void gluiwBotoes(void);

/*funções de manipulação*/
void DesenharPiso(void);
void DesenharObjeto(int animar);
void temporizador(int tempo);
void RotacionarDireita(void);
void RotacionarEsquerda(void);
void RotacionarCima(void);
void RotacionarBaixo(void);
