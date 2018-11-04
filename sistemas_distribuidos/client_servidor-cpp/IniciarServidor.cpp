#include <iostream>
#include <signal.h>
#include <string>
#include <time.h>
#include "Servidor.hpp"

#define VERMELHO "\033[0;31m"
#define NORMAL "\033[0m"

using namespace std;
Servidor * servidor;

void tratarSinal(int sinal){
    if(sinal==SIGINT){
         servidor->terminar();
    }
}

int main(int argc, char** argv) {
     int porta,time=0;
     if(argc==3){
          string t(argv[2]);//recebendo timeout
          time=stoi(t,nullptr,10);
          string p(argv[1]);//recebendo porta do servidor
          porta=stoi(p,nullptr,10);
          if((porta<1024)||(porta>65535)){
               cout << "A porta deverá ser maior que 1024 e menor que 65535!!" << endl;
               return EXIT_FAILURE;
          }
     }else if(argc==2){
          string p(argv[1]);//recebendo porta do servidor
          porta=stoi(p,nullptr,10);
          if((porta<1024)||(porta>65535)){
               cout << "A porta deverá ser maior que 1024 e menor que 65535!!" << endl;
               return EXIT_FAILURE;
          }
     }else{
          cout << VERMELHO << "Número de argumentos inválido!!" << NORMAL << endl;
          return EXIT_FAILURE;
     }
     Servidor serv(porta);
     servidor=&serv;
     if(time>0){servidor->setTimeout(time);}
     signal(SIGINT,&tratarSinal);//identificar ctrl+C
     servidor->iniciar();
     cout << "Erros durante a execuação do servidor:" << servidor->getErros() << endl;
     return EXIT_SUCCESS;
}


              