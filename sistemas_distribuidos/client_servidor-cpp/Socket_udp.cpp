#include <iostream>

#include "Socket_udp.hpp"

namespace udp_socket{
     
     Socket_udp::Socket_udp(int porta){
          memset(&my_adress,0,sizeof(struct sockaddr_in));
          my_adress.sin_family=AF_INET;
          my_adress.sin_addr.s_addr=INADDR_ANY;
          my_adress.sin_port=htons((uint16_t)porta);
          socket_id=socket(my_adress.sin_family,SOCK_DGRAM,IPPROTO_UDP);
          socklen_t len=sizeof(my_adress);
          if(socket_id<0){
               throw socket_runtime_error((std::string(ERRO).append("Problema ao tentar abrir o socket UDP").append(NORMAL)).c_str());
          }
          if(bind(socket_id,(struct sockaddr *) &my_adress,len)<0){
               throw socket_runtime_error((std::string(ERRO).append("Problema ao tentar efetuar o BIND").append(NORMAL)).c_str());
          }
          if(getsockname(socket_id,(struct sockaddr*) &my_adress,&len)<0){
               throw socket_runtime_error((std::string(ERRO).append("Problema ao tentar obter o nome do socket").append(NORMAL)).c_str());
          }
          timeout.tv_sec=1;
     }
     Socket_udp::~Socket_udp() {
          if(close(socket_id)<0){
               throw socket_runtime_error((std::string(ERRO).append("Problema ao tentar fechar o socket").append(NORMAL)).c_str());
          }
     }

     int Socket_udp::receber_msg(struct sockaddr_in * remetente, char* msg, size_t max_size) {
          socklen_t len_c=sizeof(*remetente);
          memset((char *)remetente,0,len_c);
          fd_set s;
          FD_ZERO(&s);
          FD_SET(socket_id, &s);
          //utiliza a função select para aguardar uma mensagem ou o estouro do temporizador
          int dados=select(socket_id+1, &s, NULL, NULL, &timeout);
          //se maior que zero uma mensagem está disponível, se zero nenhuma mensagem chegou e se for menor q zero um erro ocorreu
          if(dados>0){
               if(FD_ISSET(socket_id,&s)>0){
                    dados =(int) recvfrom(socket_id,msg,max_size,0,(struct sockaddr *) remetente, &len_c);
                    //dados mantém a quantidade de bytes recebidos
                    if(dados<0){
                         std::cout << ERRO << "Problema ao tentar receber DATAGRAMA do endereço >> " << std::string(inet_ntoa(remetente->sin_addr)) << ":" << ntohs(remetente->sin_port) << NORMAL << std::endl;
                    }
               }
          }
          return dados;
     }

     int Socket_udp::enviar_msg(const struct sockaddr_in * destino, const char* msg, size_t size) {
          int dados=(int) sendto(socket_id,msg,size,0,(struct sockaddr *)destino, sizeof(*destino));
          //dados mantém a quantidade de bytes enviados
          if(dados<0){
               std::cout << ERRO << "Problema ao tentar enviar DATAGRAMA para o endereço >> " << std::string(inet_ntoa(destino->sin_addr)) << ":" << ntohs(destino->sin_port) << NORMAL << std::endl;
          }
          return dados;
     }
}