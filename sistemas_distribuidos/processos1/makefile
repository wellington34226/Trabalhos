#zera o arquivo de log, compila, linca, limpa e executa os arquivos necessários para a execução do programa
#ao final ele apaga todos os arquivos objetos criados durante a execução.
#compilador gcc
	COMPILADOR = gcc
#nome dos arquivos fonte que deverão ser compilados
	ARQUIVOS =  utilidades.c processofilho.c processopai.c
#nome dos arquivos objetos que deverão ser lincados
	OBJETOS = utilidades.o processofilho.o processopai.o
#flag para lincar os arquivos objetos
	FLINCAR = -lpthread -o
#comando para limpar: apaga todos os arquivos objetos gerados na compilação
	LIMPAR = /bin/rm -f *.o
#dependências principais
all: compilar lincar limpar
#compilaçãodos arquivos fontes
compilar: $(ARQUIVOS)
	$(COMPILADOR) -c $(ARQUIVOS)
#linca os arquivos compilados e gera um arquivo executável
lincar: $(OBJETOS)
	$(COMPILADOR) $(OBJETOS) $(FLINCAR) programa
#limpeza dos arquivos objetos gerados
limpar:
	$(LIMPAR)
