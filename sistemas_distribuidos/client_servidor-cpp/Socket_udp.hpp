#ifndef SOCKET_UDP_HPP
#define SOCKET_UDP_HPP
#include <sys/types.h>
#include <sys/socket.h>
#include <netdb.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <sys/select.h>
#include <unistd.h>
#include <stdexcept>
#include <sstream>
#include <string>
#include <cstring>

#define ERRO "\033[0;31m"
#define NORMAL "\033[0m"

namespace udp_socket{
     class socket_runtime_error : public std::runtime_error{
          public:
               socket_runtime_error(const char *erro):std::runtime_error(erro){}
    };//exceções durante a criação do socket
    
     class Socket_udp{
          public:
               Socket_udp(int porta);//construtor padrão, recebe a porta a ser utilizada, se 0 o sistema irá escolher a porta
               ~Socket_udp();

               int get_socket() const {return socket_id;}//retorna o identificador do socket
               int get_porta() const {return ntohs(my_adress.sin_port);}//retorna a porta que o socket foi criado
               std::string get_addr() const {return std::string(inet_ntoa(my_adress.sin_addr));}//retorna o endereço que o socket foi criado
               void setTimeout(int time){if(time>0){timeout.tv_sec=time;}}//definir timeout para o recebimento de uma mensagem
               
               int receber_msg(struct sockaddr_in * remetente, char * msg, size_t max_size);//receber mensagem
               int enviar_msg(const struct sockaddr_in * destino, const char * msg, size_t size);//enviar mensagem
          private:
               int socket_id;//identificador do socket
               struct timeval timeout;//tempo de espera para o recebimento de uma mensagem
               struct sockaddr_in my_adress;//estrutura padrão para definição de socket
     };
}
#endif /* SOCKET_UDP_HPP */