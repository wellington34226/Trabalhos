# Environment 
GCC = g++ 
LIBS = -pthread -std=c++11 -lrt -lnsl
OTEST = teste.o Mensagem.o Socket_udp.o TratadorThread.o Servidor.o Cliente.o rpc_clnt.o rpc_svc.o
OSERV = IniciarServidor.o TratadorThread.o Servidor.o Socket_udp.o rpc_svc.o
OCLIE = Calculos.o IniciarCliente.o Mensagem.o Socket_udp.o Cliente.o rpc_clnt.o
OGRAP = GerarGraficos.o
CSERV = IniciarServidor.cpp Servidor.cpp Socket_udp.cpp TratadorThread.cpp rpc_svc.cpp
CCLIE = Mensagem.cpp Socket_udp.cpp  Cliente.cpp  Calculos.cpp IniciarCliente.cpp rpc_clnt.cpp
CTEST = Mensagem.cpp Socket_udp.cpp  Cliente.cpp  Calculos.cpp Servidor.cpp TratadorThread.cpp teste.cpp rpc_clnt.cpp rpc_svc.cpp
CGRAP = GerarGraficos.cpp
HEADS = Mensagem.hpp Socket_udp.hpp TratadorThread.hpp Servidor.hpp Cliente.hpp Calculos.hpp rpc_message.hpp
#build:	$(HEADS) $(FILES) cobjet
#	$(GCC) -c $(FILES) $(LIBS)
buildserv:	$(HEADS) $(CSERV)
	$(GCC) -c $(CSERV) $(LIBS)
buildclie:	$(HEADS) $(CCLIE)
	$(GCC) -c $(CCLIE) $(LIBS)
buildtest:	$(HEADS) $(CTEST)
	$(GCC) -c $(CTEST) $(LIBS)
buildgrap:	$(HEADS) $(CGRAP)
	$(GCC) -c $(CGRAP) $(LIBS)
teste:	buildtest
	$(GCC) $(OBJTS) $(OTEST) -o teste $(LIBS)
cliente:	buildclie
	$(GCC) $(OBJTS) $(OCLIE) -o cliente $(LIBS)
servidor:	buildserv
	$(GCC) $(OBJTS) $(OSERV) -o servidor $(LIBS)
graficos:	buildgrap
	$(GCC) $(OGRAP) -o plotar $(LIBS)
enable:
	scl enable devtoolset-2 bash
