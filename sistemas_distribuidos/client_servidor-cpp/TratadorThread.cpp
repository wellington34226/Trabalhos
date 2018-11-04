#include "TratadorThread.hpp"

TratadorThread::TratadorThread(udp_socket::Socket_udp * ssocket,struct sockaddr_in destino,const string mensagem){
    ssocket->enviar_msg(&destino,mensagem.c_str(),(size_t)mensagem.length());
}
