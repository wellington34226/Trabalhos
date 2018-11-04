#include "rpc_message.hpp"

char ** enviarmsg_1_svc(char **argp, struct svc_req *rqstp){
     static char * result;
     result=*argp;
     return &result;
}