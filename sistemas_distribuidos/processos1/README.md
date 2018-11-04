Ü TRABALHO 1 Ü
Exemplo de utilizacao dos conceitos de thread e processos, como se da a interacao entre processos pais e
seus processos filhos, bem como suas threads filhas. Utilizando o conceito de programcao concorrente.
Um processo pai cria uma area de memoria compartilhada, para que seus filhos possam utilizar,
apos a area ter sido criada com sucesso, o processo pai cria um processo filho que ira realizar operaoıes
sobre essa area, cria tambem uma thread que ira operar sobre a area de memoria compartilhada juntamente com o processo
criado pelo pai.
O pai por sua vez aguarda o termino da execucao de seus filhos, para que possa obter o resultado necessario.
A thread ao terminar desponibiliza para seu pai em uma variavel global do pai o momento do seu tarmino, para que
o pai possa calcular o tempo de execucao dela. Levando em conta que threads utilizam as variaveis globais do pai.
Com o processo nao e  possevel fazer isso, mas o pai calcula o tempo de execucao de seu filho assim mesmo, so que de outra forma.
O pai aguarda o sinal de seu filho terminou, quando o sinal e obtido ele recupera tempo de termino, e deposi calcula o tempo
de execucao.
Ao final o processo pai informa o termino de seus filhos processo e thread e imprime seus respectivos tempos de
execucao.
DESCRICAO DO CONTEUDO DOS ARQUIVOS FONTES E DEMAIS ARQUIVOS AUXILIARES
ARQUIVO: utilidades.c
	Codigo das funcoes utilizadas pelos processos e pela thread:
		Funcao push -> manipulacao da pilha, operacao de inclusao na pilha, verificando se a operacao n„o
		ira causar um overflow (uma inclusao alem do limite da pilha).
		Funcao pop -> manipulacao da pilha, operacao de retirada da pilha, verificando se a operacao n„o
		ira causar um underflow (uma retirada menor que o limite da pilha).
		FUncao imprimir_pilha -> efetua a impresao do conteudo atual da pilha no momento da chamada da funcao.
		Funcao acoplar_mem -> efetua o acoplamento a area de memoria compartilhada criada pela funcao criar_mem.
		Verifica se ocorreu erro no acoplamento. Essa funcao recupera o id da memoria e acopla ao mesmo tempo.
		Funcao criar_mem -> efetua a criacao de uma area de memoria compartilhada, alem de identificar a ocorrencia
		de erros na criacao da memoria.
ARQUIVO: processofilho.c
	Contem todo o codigo de execucao da thread e do processo filho, a manipulacao da memoria compartilhada.
	Como a thread filha e o processo filho irao efetuar as mesmas operacoes, o codigo foi escrito em um arquivo separado,
	que e executado como uma funcao, no codigo do processo filho e da thread h√° a chama de fucao filho(),com isso os dois podem
	executar suas acoes na area de memoria compartilhada.
ARQUIVO: processopai.c
	Contem todo o codigo do pai, criando a area de memoria, um processo filho e uma thread filha, apos suas criacoes ele aguarda
	seus respectivos terminos, entao calcula o tempo de execucao de seus filhos. Ao final imprime na tela e em arquivo o tempo de
	execucao de seus filhos.
ARQUIVO: parametros.h
	Contem as declaracoes das bibliotecas utilizadas no programa, definicao da estrutura da pilha e do seu respectivo apontador,
	definicao das contantes utilizadas no codigo (KEY, AMARELO,VERMELHO,VERDE,AZUL,NORMAL).
ARQUIVO: makefile
	Contem as dependencias dos codigos fontes, a compilacao e a lincagem dos mesmos.
	Alem de remover os arquivos objetos gerados durante a compilacao.
FUNCIONAMENTO DO PROGRAMA
Devido a falta de sincronismo no acesso a area de memoria compartilhada, os valores obtidos na execuao do programa sao em alguns momentos
totalmente diferentes do esperado.
Na tela as tudo que e impresso em Verde e o processo pai que esta executando, tudo que sai em Vermelho e mensagem de erro, tudo que sai
em Amarelo e a thread executando e em Azul o processo filho.
Decidimos fazer assim para que ficasse mais claro quem esta mandando a informacao para a tela.







INTEGRANTES DESENVOLVEDORES
MOYSES SAMPAIO
WELLINGTON RODRIGO DE FREITAS COSTA
