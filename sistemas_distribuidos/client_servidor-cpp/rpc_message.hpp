#ifndef RPC_MESSAGE_HPP
#define RPC_MESSAGE_HPP

#include <rpc/rpc.h>

#ifdef __cplusplus
extern "C" {
#endif


#define EXECUTARPROG 0x3422635
#define EXECUTARVERSION 1

#if defined(__STDC__) || defined(__cplusplus)
#define ENVIARMSG 1
extern  char ** enviarmsg_1(char **, CLIENT *);
extern  char ** enviarmsg_1_svc(char **, struct svc_req *);
extern int executarprog_1_freeresult (SVCXPRT *, xdrproc_t, caddr_t);

#else /* K&R C */
#define ENVIARMSG 1
extern  char ** enviarmsg_1();
extern  char ** enviarmsg_1_svc();
extern int executarprog_1_freeresult ();
#endif /* K&R C */

#ifdef __cplusplus
}
#endif

#endif /* RPC_MESSAGE_HPP */

