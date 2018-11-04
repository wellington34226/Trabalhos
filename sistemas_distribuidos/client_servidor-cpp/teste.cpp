#ifndef TESTE
#define TESTE
#include <stdlib.h>
#include <iostream>
#include <sstream>
#include <stdio.h>
#include <time.h>
#include <unistd.h>
#include <thread>
#include <signal.h>
#include "Servidor.hpp"
#include "Cliente.hpp"

using namespace std;
using namespace udp_socket;
Servidor * servidor;
Cliente * cliente;
int porta=3000;
timespec inicio,fim;//struct timespec {time_t	tv_sec;	seconds	long	tv_nsec; in nanoseconds */};

void tratarSinal(int sinal){
    if(sinal==SIGINT){
         servidor->terminar();
    }
}
timespec calcTemp(timespec start, timespec end) {
    timespec temp;
    if ((end.tv_nsec-start.tv_nsec)<0) {
        temp.tv_sec = end.tv_sec-start.tv_sec-1;
        temp.tv_nsec = 1000000000+end.tv_nsec-start.tv_nsec;
    } else {
        temp.tv_sec = end.tv_sec-start.tv_sec;
        temp.tv_nsec = end.tv_nsec-start.tv_nsec;
    }
    return temp;
}
string tempoDecorrido(timespec tempo){
     stringstream temp;
     int temp_micro,temp_milli;
     //tempo em segundos
     if(tempo.tv_sec>0){
          temp << tempo.tv_sec << "s ";
     }
     //tempo em millisegundos nano*1000000
     temp_milli=tempo.tv_nsec/1000000;
     if(temp_milli>0){
          temp << temp_milli << "ms ";
          tempo.tv_nsec=tempo.tv_nsec-(temp_milli*1000000);
     }
     //tempo em microsegundos nano*1000
     temp_micro=tempo.tv_nsec/1000;
     if(temp_micro>0){
          temp << temp_micro << "us ";
          tempo.tv_nsec=tempo.tv_nsec-(temp_micro*1000);
     }
     //tempo em nanosegundos
     temp << tempo.tv_nsec << "ns ";
     return temp.str();
}
void iniciar(string nometeste){
    cout << "Iniciado: " << nometeste << endl;
    if(clock_gettime(CLOCK_REALTIME/*PROCESS_CPUTIME_ID*/, &inicio)!=0)exit(EXIT_FAILURE);
}
void finalizar(string nometeste){
    if(clock_gettime(CLOCK_REALTIME/*PROCESS_CPUTIME_ID*/, &fim)!=0)exit(EXIT_FAILURE);
    timespec tempo=calcTemp(inicio,fim);
    cout << "tempo de execucao: " << tempoDecorrido(tempo) << "testname=" << nometeste <<endl;
    cout << "Finalizado: " << nometeste << endl;
}
void testeMensagem(string nometeste) {
    Mensagem msg(10);
    if (msg.getString().length()!=10) {
        cout << "testname=" << nometeste << " (testeSimples) message=Erro na mensagem: " << msg.getString() << " - " << msg.getString().length() << endl;
    }else{
         cout << "testname=" << nometeste << " (testeSimples) message=OK" << endl;
    }
}
void testeSocket(string nometeste){
    Socket_udp socket(porta);
    if(socket.get_porta()!=porta){
        cout << "testname=" << nometeste << " (testeSimples) message=Erro na mensagem: " << porta << " <-> " << socket.get_porta() << endl;
    }else{
          cout << "testname=" << nometeste << " (testeSimples) message=OK "<<endl;
     }
}
void testeServidor(string nometeste){
    Servidor serv(porta);
    servidor=&serv;
    servidor->iniciar();
    if(servidor->getPorta()!=porta){
        cout << "testname=" << nometeste << " (testeSimples) message=Erro na mensagem: " << porta << " <-> " << servidor->getPorta() << endl;
    }else{
          cout << "testname=" << nometeste << " (testeSimples) message=OK " <<endl;
     }
    finalizar(nometeste);
}
void testeClienteSocket(string nometeste){
    int tamanho=10;
    Cliente cli("localhost",porta,tamanho);
    cliente=&cli;
     if(!cliente->executar(true)){
        cout << "testname=" << nometeste << " (testeSimples) message=Erro na mensagem>> servidor:" << cliente->getServidor() << " mensagem:" << cliente->getMensagem() << endl;
    }else{
          cout << "testname=" << nometeste << " (testeSimples) message=OK " <<endl;
     }
}
void testeClienteRPC(string nometeste){
    int tamanho=10;
    Cliente cli("localhost",porta,tamanho);
    cliente=&cli;
     if(!cliente->executar(false)){
        cout << "testname=" << nometeste << " (testeSimples) message=Erro na mensagem>> servidor:" << cliente->getServidor() << " mensagem:" << cliente->getMensagem() << endl;
    }else{
          cout << "testname=" << nometeste << " (testeSimples) message=OK " <<endl;
     }
}
#endif

int main(/*int argc, char** argv*/) {
     string nome;
     
     cout << "Iniciando TesteSimples" << endl;
     cout << endl;
     
     nome="testeMensagem";
     iniciar(nome);
     testeMensagem(nome);
     finalizar(nome);
     cout << endl;
     
     nome="testeSocketUDP";
     iniciar(nome);
     testeSocket(nome);
     finalizar(nome);
     cout << endl;
     
     nome="testeServidor";
     iniciar(nome);
     thread th(&testeServidor,nome);
     signal(SIGINT,&tratarSinal);//identificar ctrl+C
     sleep(2);//para dar tempo do servidor ser iniciado
     
     nome="testeClienteSocket";
     iniciar(nome);
     testeClienteSocket(nome);
     finalizar(nome);
     cout << endl;
     
     nome="testeClienteRPC";
     iniciar(nome);
     testeClienteSocket(nome);
     finalizar(nome);
     cout << endl;
     
     sleep(5);//para dar tempo do servidor responder
     servidor->terminar();
     th.join();
     cout << endl;
     cout << "Finalizando TesteSimples" << endl;
     return (EXIT_SUCCESS);
}