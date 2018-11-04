/**************************************************
Trabalho final de Computa��o Gr�fica.
---------------------------------------------------
Wellington Rodrigo de Freitas Costa - 29/06/2010
**************************************************/

/*func�es para utiliza��o do OpenGL*/
void glwRedimencionarTela(GLsizei largura, GLsizei altura);
void glwDesenhar(void);
void glwVisualizacao(void);

/*fun��es para utiliza��o do glut*/
void glutwTecladoEsc(unsigned char tecla, int x, int y);//sai se ESC for precionado.
void glutTecladoSetas(int tecla, int x, int y);//modifica c�mera com setas.
void glutwAguardar(void);//aguarda alguma a��o.

/*fun��es para utiliza��o do glui*/
void gluiwBotoes(void);

/*fun��es de manipula��o*/
void DesenharPiso(void);
void DesenharObjeto(int animar);
void temporizador(int tempo);
void RotacionarDireita(void);
void RotacionarEsquerda(void);
void RotacionarCima(void);
void RotacionarBaixo(void);
