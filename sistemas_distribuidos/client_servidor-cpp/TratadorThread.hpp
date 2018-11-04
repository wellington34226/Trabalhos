#ifndef TRATADORTHREAD_HPP
#define TRATADORTHREAD_HPP
#include <thread>
#include <iostream>
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
#include "Socket_udp.hpp"

#define VERDE "\033[1;32m"

using namespace std;
using namespace this_thread;

class TratadorThread : public thread{
    public:
        TratadorThread(udp_socket::Socket_udp * ssocket,struct sockaddr_in destino,const string mensagem);
        virtual ~TratadorThread(){}
};
#endif /* TRATADORTHREAD_HPP */