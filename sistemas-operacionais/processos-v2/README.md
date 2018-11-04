## INTEGRANTES DESENVOLVEDORES
- MOYSES SAMPAIO
- WELLINGTON RODRIGO DE FREITAS COSTA

## PROCESSO e THREAD COM SEMÁFORO
- Exemplo de utilização dos conceitos de thread e processos, como se da a interação entre processos pais e seus processos filhos, bem como suas threads filhas, utilizando o conceito de programção concorrente e o uso de semáforos para sincronismo.
- Um processo pai cria uma área de memória compartilhada e um semáforo, para que seus filhos possam utilizar, após a memória compartilhada e o semáforo terem sido criados com sucesso, o processo pai cria um processo filho que irá realizar operações sobre essa área, cria também uma thread que irá operar sobre a área de memoria compartilhada juntamente com o processo criado pelo pai.
- O pai por sua vez aguarda o término da execução de seus filhos, para que possa obter o resultado necessário.
- A thread ao terminar desponibiliza para seu pai em uma variável global do pai o momento do seu término, para que o pai possa calcular o tempo de execução dela. Levando em conta que threads utilizam as variáveis globais do pai.
- Para o processo filho o pai calcula o tempo de execucao de outra forma. O pai aguarda o sinal de que seu filho terminou, quando o sinal e obtido ele recupera tempo de término, e depois calcula o tempo de execução.
- Ao final o processo pai informa o termino de seus filhos processo e thread e imprime seus respectivos tempos de execução.

## DESCRIÇÃO DO CONTEÚDO DOS ARQUIVOS FONTES E DEMAIS ARQUIVOS AUXILIARES

### utilidades.c
- Código das funções utilizadas pelos processos e pela thread:
	- Função push -> manipulação da pilha, operação de inclusão na pilha, verificando se a operação não irá causar um overflow (uma inclusao alem do limite da pilha).
	- Função pop -> manipulação da pilha, operação de retirada da pilha, verificando se a operação não irá causar um underflow (uma retirada menor que o limite da pilha).
	- Função imprimir_pilha -> efetua a impressão do conteúdo atual da pilha no momento da chamada da função.
	- Função acoplar_mem -> efetua o acoplamento a área de memória compartilhada criada pela função criar_mem. Verifica se ocorreu erro no acoplamento. Essa função recupera o id da memória e acopla ao mesmo tempo.
	- Função criar_mem -> efetua a criação de uma área de memória compartilhada, além de identificar a ocorrência de erros na criacao da memória.
	
### dijkstra.c
- Contém as funções para criação, destruição e operações com o semáforo.

### processofilho.c
- Contém todo o código de execução da thread e do processo filho, a manipulação da memória compartilhada.
- Como a thread filha e o processo filho irão efetuar as mesmas operações, o código foi escrito em um arquivo separado, que é executado como uma função, no código do processo filho e da thread a chamada de função filho(), com isso os dois podem executar suas ações na área de memória compartilhada.
	
### processopai.c
- Contém todo o código do pai, criando a área de memória, um processo filho e uma thread filha, após suas criações ele aguarda seus respectivos términos, então calcula o tempo de execução de seus filhos. Ao final imprime na tela e em arquivo o tempo de execução de seus filhos.
	
### parametros.h
- Contém as declarações das bibliotecas utilizadas no programa, definição da estrutura da pilha e do seu respectivo apontador, definição das contantes utilizadas no codigo (KEY, AMARELO,VERMELHO,VERDE,AZUL,NORMAL).
	
### makefile
- Contém as dependencias dos códigos fontes, da compilação e da lincagem dos mesmos. Além de remover os arquivos objetos gerados durante a compilação.
## FUNCIONAMENTO DO PROGRAMA
- Com o uso de semáforo, a pilha tem um comportamento diferente do trabalho anterior, onde tinham valores inconsistentes sendo impressos. Agora com a utilização do semáforo de dijkstra o sincronismo foi garantido, eles estão executando intercaladamente e sem erros nos valores obtidos da memória compartilhada.
- Na tela tudo que é impresso em Verde é o processo pai que está executando, tudo que sai em Vermelho e mensagem de erro, em Amarelo é a thread executando e em Azul o processo filho.
- Decidimos fazer assim para que ficasse mais claro quem está imprimindo na tela.
