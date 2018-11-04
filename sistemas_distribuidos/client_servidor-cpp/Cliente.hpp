#ifndef CLIENTE_HPP
#define CLIENTE_HPP
#include <stdlib.h>
#include <stdio.h>
#include <cctype>
#include <string.h>
#include <sstream>
#include <iostream>
#include <stdexcept>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>
#include <signal.h>
#include "Mensagem.hpp"//classe mensagem padrão, utilizada apenas para criar uma mensagem com tamanho em Bytes correto a ser enviado
#include "Socket_udp.hpp"//classe socket UDP
#include "rpc_message.hpp"//biblioteca RPC criada

//Definições dos padrões de saída identificação dos tipos de mensagens mostradas na tela
//#define AMARELO "\033[1;33m"
#define VERMELHO "\033[0;31m"
#define AZUL "\033[1;34m"
#define NORMAL "\033[0m"

using namespace std;
using namespace udp_socket;

class Cliente{
public:
    Cliente(string sip,int sport, int tmsg);//construtor padrão, precisa do nome e porta do servidor e o tamanho da mensagem a ser enviada
    virtual ~Cliente(){}
    
    bool executar(bool scoket);//envia e recebe uma mensagem, retorna true caso a mensagem enviada e recebida sejam do mesmo tamanho
    static void terminar(){Cliente::exec=0;}//finaliza a execução caso esteja bloqueado esperando uma resposta
    void setTimeout(int time){csocket.setTimeout(time);}//definir timeout para o recebimento de uma mensagem
    string getServidor(){return string(inet_ntoa(servidor.sin_addr)).append(":").append(to_string(ntohs(servidor.sin_port)));}//recuperar informações do servidor
    string getMensagem(){return msgrecebida;}//recuperar mensagem recebida
private:
   static sig_atomic_t exec;//para abortar a execução caso de algum problema para receber uma mensagem
   char *srv;
   Socket_udp csocket;//socket local
   struct sockaddr_in servidor;//endereço do servidor e posteriormente do remetente
   string msgenviada;//mensagem a ser enviada
   string msgrecebida;//mensagem recebida
};
#endif /* CLIENTE_HPP */