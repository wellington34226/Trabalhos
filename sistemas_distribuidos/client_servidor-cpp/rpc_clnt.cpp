#include "rpc_message.hpp"
#include <memory.h>
#include <sys/types.h>

static struct timeval TIMEOUT = { 25, 0 };

char ** enviarmsg_1(char **argp, CLIENT *clnt){
     static char *clnt_res;

     memset((char *)&clnt_res, 0, sizeof(clnt_res));
     if (clnt_call (clnt, ENVIARMSG,(xdrproc_t) xdr_wrapstring, (caddr_t) argp,(xdrproc_t) xdr_wrapstring, (caddr_t) &clnt_res,TIMEOUT) != RPC_SUCCESS){
          return (NULL);
     }
     return (&clnt_res);
}