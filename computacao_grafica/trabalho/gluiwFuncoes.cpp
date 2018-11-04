/**************************************************
Trabalho final de Computação Gráfica.
---------------------------------------------------
Wellington Rodrigo de Freitas Costa - 29/06/2010
**************************************************/

#include "bibliotecas.h"
#include "definicoes.h"
#include "funcoes.h"

/*funções utilização do glui*/
void gluiwBotoes(void){
    GLUI *glui = GLUI_Master.create_glui_subwindow(id_janela, GLUI_SUBWINDOW_TOP );
    glui->add_checkbox( "Iluminar Cena", &iluminacao);
    glui->add_column(false);
    glui->add_checkbox( "Animar Cena", &animado);
    glui->add_column(false);
    GLUI_Button *button1 = glui->add_button("DIREITA-->>", 0, (GLUI_Update_CB)RotacionarDireita);
    glui->add_column(false);
    GLUI_Button *button2 = glui->add_button("<<--ESQUERDA", 0, (GLUI_Update_CB)RotacionarEsquerda);
    glui->add_column(false);
    GLUI_Button *button3 = glui->add_button("Fechar Programa", 0, (GLUI_Update_CB)exit);
    glui->set_main_gfx_window(id_janela);
    GLUI_Master.set_glutDisplayFunc(glwDesenhar);
    GLUI_Master.set_glutIdleFunc(glutwAguardar);
    GLUI_Master.set_glutSpecialFunc(glutTecladoSetas);
    GLUI_Master.set_glutSpecialFunc(glutTecladoSetas);
};
