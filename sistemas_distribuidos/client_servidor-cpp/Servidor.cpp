#include "Servidor.hpp"
#include <thread>

#ifndef SIG_PF
     #define SIG_PF void(*)(int)
#endif
static void executarprog_1(struct svc_req *rqstp, register SVCXPRT *transp);
void servidor_rpc();

sig_atomic_t Servidor::exec=1;
int Servidor::mensagens_recebidas=0;

Servidor::Servidor(int port):ssocket(port),max_size_msg(sizeof(char)*65000),erro_r(0){}

void Servidor::iniciar(){
    struct sockaddr_in remetente;
    //thread thread_rpc(servidor_rpc);
    cout << AZUL << "Servidor executando!!!" << NORMAL << endl;
    while(Servidor::exec>0){
         char * msg=new char[max_size_msg];
         memset(msg,0,max_size_msg);
         int resultado=ssocket.receber_msg(&remetente,msg,(size_t) max_size_msg);
         if(resultado>0){
              Servidor::mensagens_recebidas++;
              //std::cout << AZUL << "Mensgem recebida:" << string(msg).length() << NORMAL << std::endl;
              if((Servidor::mensagens_recebidas % 1000)==1)cout << AZUL << "Mensagens recebidas: " << string(msg).length() << NORMAL << endl;
              TratadorThread(&ssocket,remetente,string(msg));
              //ssocket.enviar_msg(&remetente,msg,(size_t) sizeof(*msg));
         }else if((resultado<0)&&(exec==1)){
              erro_r++;
              cout << VERMELHO << erro_r << " erros ocorridos!!" << NORMAL << endl;
         }
         if(Servidor::mensagens_recebidas<0)Servidor::mensagens_recebidas=0;
         delete[] msg;
    }
    //thread_rpc.detach();
    cout << endl << "Servidor terminando!!" << endl;
}

static void executarprog_1(struct svc_req *rqstp, register SVCXPRT *transp){
     union {
          char *enviarmsg_1_arg;
     } argument;
     char *result;
     xdrproc_t _xdr_argument, _xdr_result;
     char *(*local)(char *, struct svc_req *);

     switch (rqstp->rq_proc) {
          case NULLPROC:
               (void) svc_sendreply (transp, (xdrproc_t) xdr_void, (char *)NULL);
               return;
          case ENVIARMSG:
               _xdr_argument = (xdrproc_t) xdr_wrapstring;
               _xdr_result = (xdrproc_t) xdr_wrapstring;
               local = (char *(*)(char *, struct svc_req *)) enviarmsg_1_svc;
               break;
          default:
               svcerr_noproc (transp);
               return;
     }
     memset ((char *)&argument, 0, sizeof (argument));
     if (!svc_getargs (transp, (xdrproc_t) _xdr_argument, (caddr_t) &argument)) {
          svcerr_decode (transp);
          return;
     }
     result = (*local)((char *)&argument, rqstp);
     if (result != NULL && !svc_sendreply(transp, (xdrproc_t) _xdr_result, result)) {
          svcerr_systemerr (transp);
     }
     if (!svc_freeargs (transp, (xdrproc_t) _xdr_argument, (caddr_t) &argument)) {
          fprintf (stderr, "%s", "unable to free arguments");
          exit (1);
     }
     return;
}

void servidor_rpc(){
     register SVCXPRT *transp;
     pmap_unset(EXECUTARPROG, EXECUTARVERSION);
     transp = svcudp_create(RPC_ANYSOCK);
     if (transp == NULL) {
          fprintf (stderr, "%s", "cannot create udp service.");
          exit(1);
     }
     if (!svc_register(transp, EXECUTARPROG, EXECUTARVERSION, executarprog_1, IPPROTO_UDP)) {
          fprintf (stderr, "%s", "unable to register (EXECUTARPROG, EXECUTARVERSION, udp).");
          exit(1);
     }

     transp = svctcp_create(RPC_ANYSOCK, 0, 0);
     if (transp == NULL) {
          fprintf (stderr, "%s", "cannot create tcp service.");
          exit(1);
     }
     if (!svc_register(transp, EXECUTARPROG, EXECUTARVERSION, executarprog_1, IPPROTO_TCP)) {
          fprintf (stderr, "%s", "unable to register (EXECUTARPROG, EXECUTARVERSION, tcp).");
          exit(1);
     }
     svc_run();
}
