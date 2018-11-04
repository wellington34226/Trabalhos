#include "Cliente.hpp"

sig_atomic_t Cliente::exec=1;

Cliente::Cliente(string sip, int sport, int tmsg):csocket(0),msgenviada(Mensagem(tmsg).getString()),msgrecebida(){
    struct hostent * ipserver=gethostbyname(sip.c_str());
    srv=(char *)sip.c_str();
    if(ipserver==NULL){
        throw udp_socket::socket_runtime_error((std::string(ERRO).append("Servidor desconhecido: ").append(sip).append(NORMAL)).c_str());
    }
    memset((char *)&servidor,0,sizeof(servidor));
    memcpy(&servidor.sin_addr, ipserver->h_addr_list[0], ipserver->h_length);
    servidor.sin_family=AF_INET;
    servidor.sin_port=htons((uint16_t)sport);
}

bool Cliente::executar(bool send_socket) {
    char * msg;
    int size=msgenviada.length();
    msgrecebida="";
    if(send_socket){
         msg=(char*)msgenviada.c_str();
         if(csocket.enviar_msg(&servidor,msg,(size_t) size)>0){
              //aguarda receber uma mensagem do mesmo tamanho da enviada ou a execução ser cancelada
               do{
                    if(csocket.receber_msg(&servidor,msg,(size_t) size)>0){msgrecebida=string(msg);}
               }while(Cliente::exec>0&&msgrecebida.length()<msgenviada.length());
          }
    }else{
          CLIENT *clnt;
          char * *result_1;
          #ifndef	DEBUG
               clnt = clnt_create(srv, EXECUTARPROG, EXECUTARVERSION, "udp");
               if (clnt == NULL) {
                    clnt_pcreateerror(srv);
                    exit (1);
               }
          #endif	/* DEBUG */
          //aguarda receber uma mensagem do mesmo tamanho da enviada ou a execução ser cancelada
          int index=0;
          do{
               if(msgenviada.length()>8000){
                    msg=(char *)msgenviada.substr(index,(size % 8000)+1).c_str();
                    result_1 = enviarmsg_1(&msg, clnt);
                    if(result_1!=(char **)NULL){
                         index=string(*result_1).length();
                         msgrecebida+=string(*result_1);
                         size-=index;
                    }
               }else{
                    msg=(char *)msgenviada.c_str();
                    result_1 = enviarmsg_1(&msg, clnt);
                    if(result_1!=(char **)NULL){
                         msgrecebida=string(*result_1);
                    }
               }
          }while(Cliente::exec>0&&msgrecebida.length()<msgenviada.length());
          
          #ifndef	DEBUG
               clnt_destroy(clnt);
          #endif	 /* DEBUG */
    }  
    return (msgrecebida.length()==msgenviada.length());
}