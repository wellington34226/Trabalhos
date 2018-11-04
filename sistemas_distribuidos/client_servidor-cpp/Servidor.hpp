#ifndef SERVIDOR_HPP
#define SERVIDOR_HPP
#include <stdlib.h>
#include <stdio.h>
#include <cctype>
#include <string.h>
#include <sstream>
#include <iostream>
#include <vector>
#include <stdexcept>
#include <signal.h>
#include <memory.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <rpc/pmap_clnt.h>
#include "Socket_udp.hpp"//classe socket UDP
#include "TratadorThread.hpp"//classe tratadora (threads)
#include "rpc_message.hpp"//biblioteca RPC criada

//Definições dos padrões de saída identificação dos tipos de mensagens mostradas na tela
//#define AMARELO "\033[1;33m"
#define VERMELHO "\033[0;31m"
#define AZUL "\033[1;34m"
#define NORMAL "\033[0m"

using namespace std;
using namespace udp_socket;

class Servidor{
public:
    Servidor(int port);//construtor padrão necessita indicar a porta a ser utilizada para a criação do socket
    virtual ~Servidor(){}
    
    void iniciar();//inicar execução do servidor (pode ser utilizado como uma thread separada)
    int getPorta(){return ssocket.get_porta();}//retorna a porta que o socket foi criado
    void setTimeout(int time){ssocket.setTimeout(time);}//definir timeout para o recebimento de uma mensagem
    static void terminar(){Servidor::exec=0;}//terminar execução
    int getErros(){return erro_r;}//retorna a quantidade de erros ocorridos durante o recebimento de DATAGRAMAS
private:
    static sig_atomic_t exec;//controle de execução
    static int mensagens_recebidas;
    int max_size_msg;//tamanho máximo de mensagem a ser recebida em bytes (64KBytes)
    int erro_r;//contabiliza a quantidade de erro durante o recebimento de DATAGRAMAS
    Socket_udp ssocket;//socket
};
#endif /* SERVIDOR_HPP */