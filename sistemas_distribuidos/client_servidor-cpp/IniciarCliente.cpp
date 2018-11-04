#include <cstdlib>
#include <iostream>
#include <fstream>
#include <iomanip>
#include <sstream>
#include <signal.h>
#include <time.h>
#include <map>
#include <vector>
#include <cmath>
#include "Cliente.hpp"
#include "Calculos.hpp"
//#include "gnuplot-iostream.h"

#define VERMELHO "\033[0;31m"
#define NORMAL "\033[0m"
#define DRESULTADOS "resultados"

using namespace std;
Cliente * cliente;//ponteiro para o cliente
fstream arquivo;
bool send_socket;
volatile sig_atomic_t terminar=0;

void executar(string ip, int porta, int tamanho,int requisicoes);
void tratarSinal(int sinal){
    if(sinal==SIGINT){
         if(cliente!=nullptr)cliente->terminar();
         terminar=1;
    }
}

float calcTemp(timespec start, timespec end) {
    float tempo;
    timespec temp;
    if ((end.tv_nsec-start.tv_nsec)<0) {
        temp.tv_sec = end.tv_sec-start.tv_sec-1;
        temp.tv_nsec = 1000000000+end.tv_nsec-start.tv_nsec;
    } else {
        temp.tv_sec = end.tv_sec-start.tv_sec;
        temp.tv_nsec = end.tv_nsec-start.tv_nsec;
    }
    tempo=temp.tv_sec+(temp.tv_nsec*0.0000000001);
    return tempo;
}//tempo em segundos com precisão até nano

string tempoDecorrido(float tempo){
     stringstream temp;
     long temp_seg=tempo;//segundos
     tempo=(tempo-temp_seg)*1000;
     long temp_milli=tempo;//millisegundos
     tempo=(tempo-temp_milli)*1000;
     long temp_micro=tempo;//microsegundos
     tempo=(tempo-temp_micro)*1000;
     long temp_nano=tempo;//nanosegundos
     temp << temp_seg << "s " << temp_milli << "ms " << temp_micro << "us " << temp_nano << "ns ";
     return temp.str();
}//formata o tempo em segundo millisegundo microsegundo e nanosegundos

int main(int argc, char** argv) {
     int porta=0,tmsg=1,N=0;//tamanho em bytes
     string ips;
     string rs;//chamadas RPC ou SOCKET
     switch(argc){
         case 5:
            N=stoi(string(argv[4]),nullptr,10);
            if(N<1){
               cout << VERMELHO << "Quantidade de requisições " << N << " inválida, informe um inteiro maior q zero!!" << NORMAL << endl;
                return EXIT_FAILURE;
            }
         case 4:
            ips= string(argv[1]);//recebendo o IP do servidor
            //verifica se o IP é válido
            if(gethostbyname(ips.c_str())==NULL){
                cout << VERMELHO << "IP não é válido!!" << NORMAL << endl;
                return EXIT_FAILURE;
            }
            //verifica se a porta é um inteiro maior que 1024 e menor que 65535
            porta=stoi(string(argv[2]),nullptr,10);//recebendo porta do servidor
            if((porta<1024)&&(porta<65535)){
                cout << VERMELHO << "A porta deverá ser maior que 1024 e menor que 65535!!" << NORMAL << endl;
                return EXIT_FAILURE;
            }
            rs=string(argv[3]);
            if(!rs.empty()){
                if((rs.compare("rpc")==0)||(rs.compare("RPC")==0)){
                    send_socket=false;
                }else if((rs.compare("socket")==0)||(rs.compare("SOCKET")==0)){
                    send_socket=true;
                }else{
                    cout << VERMELHO << "Argumento inválido!!" << endl;
                    cout << "Digite rpc ou RPC para efetuar teste usando chamada RPC" << endl;
                    cout << "Digite socket ou SOCKET para efetuar teste usando SOCKET" << NORMAL << endl;
                    return EXIT_FAILURE;
                }
            }else{
                cout << VERMELHO << "Argumento vazio!!" << endl;
                cout << "Digite rpc ou RPC para efetuar teste usando chamada RPC" << endl;
                cout << "Digite socket ou SOCKET para efetuar teste usando SOCKET" << NORMAL << endl;
                return EXIT_FAILURE;
            }
            break;
         default:
             cout << VERMELHO << "Número de argumentos inválido!!" << NORMAL << endl;
             return EXIT_FAILURE;
     }
     signal(SIGINT,&tratarSinal);//identificar ctrl+C
     string arqsaida;
     arqsaida=string(DRESULTADOS)+"/"+ips+"."+rs;
     arquivo.open(arqsaida,ios::out);
     if(arquivo.is_open()){
          arquivo << "bytes \t media \t desvio \t erro \t mensagens" << std::fixed << std::setprecision(9) << endl;
          do{
               cout << "Teste para mensagem de " << tmsg << "Bytes" << endl;
               executar(ips,porta,tmsg,N);
               if(tmsg==32768){
                    tmsg=64000;//quando chegar em 32KBytes coloca 64KByte para mais uma tentativa
               }else{
                    tmsg=tmsg*2;//para cada nova iteração duplica o tamanho da mensagem
               }
          }while((tmsg<65000)&&(terminar==0));
          arquivo.close();
     }else{
          cout << VERMELHO << "Não foi possível criar arquivo de saída: " << arqsaida << NORMAL << endl;
     }
     return EXIT_SUCCESS;
}

void executar(string ip, int porta, int tamanho,int requisicoes){
     Cliente cli(ip,porta,tamanho);
     Calculos calc;//iniciar o calculador com o valor Z=2.33 para intervalo de confiança igual a 98%
     cliente=&cli;
     timespec inicio,fim;//struct timespec {time_t	tv_sec;	seconds	long	tv_nsec; in nanoseconds */};
     int cont=1,N;
     bool convergir;
     if(requisicoes>0){
         N=requisicoes;//faz N requisições
         convergir=false;
     }else{
         N=1000;//inicia com 1000 requisições
         convergir=true;
     }
     do{
          if(clock_gettime(CLOCK_REALTIME/*PROCESS_CPUTIME_ID*/, &inicio)!=0){exit(EXIT_FAILURE);}
          //envia e recebe uma mensagem, send_socket=true utiliza socket UDP send_socket=false utiliza chamada RPC
          cliente->executar(send_socket);
          if(clock_gettime(CLOCK_REALTIME/*PROCESS_CPUTIME_ID*/, &fim)!=0){exit(EXIT_FAILURE);}
          calc.pushValor(calcTemp(inicio,fim));//descarta se o tempo for nulo
          //se a quantidade de amostras não for suficiente para um erro de 2% dobra a quantidade de amostras a serem coletadas
          if((cont==N)&&convergir){if(calc.getErro()>0.02){N*=2;}}//tenta convergir para um número de amostras que garanta um erro menor que 2%
          if(calc.getN(0)==cont){cont++;}//verifica se foi inserido com sucesso
     }while((cont<N+1)&&(terminar==0));//termina quando chegar a N amostras ou a execução for concelada
     if(terminar==0){
         if(tamanho>1000)arquivo << (tamanho/1000) << "k\t"<<  calc.getMedia() << " \t " << calc.getDesvio() << " \t " << calc.getErro()*calc.getMedia() << " \t " << N <<  endl;
         else arquivo << tamanho << " \t " <<  calc.getMedia() << " \t " << calc.getDesvio() << " \t " << calc.getErro()*calc.getMedia() << " \t " << N <<  endl;
     }//só insere no arquivo se o loop foi até o final
     else{
          cout << endl << VERMELHO <<  "Execução abortada!!!" << NORMAL << endl;
     }
}