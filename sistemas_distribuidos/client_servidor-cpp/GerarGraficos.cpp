#include <cstdlib>
#include <iostream>
#include <fstream>
#include <sstream>
#include <string.h>
#include <signal.h>
#include <time.h>
#include <dirent.h>
#include <list>
#include "GnuplotStream.hpp"

#define VERMELHO "\033[0;31m"
#define NORMAL "\033[0m"
#define DGRAFICO "graficos"
#define DRESULTADOS "resultados"

using namespace std;
fstream arquivo("script",ios::out);
volatile sig_atomic_t terminar=0;

void tratarSinal(int sinal){
    if(sinal==SIGINT){
         terminar=1;
    }
}

bool searchFiles(string name);
string getTitulo(const string filename);
void initScript();

int main(int argc, char** argv) {
     string dir;
     string output;
     switch(argc){
          case 3:
               output=string(argv[2]);
          case 2:
               dir=string(argv[1]);
               if(output==null)output="graficos";
               break;
          default:
               cout << VERMELHO << "Nehum diretório informado, usando diretório padrão: " << DRESULTADOS << NORMAL << endl;
               dir=string(DRESULTADOS);
     }
     try{
          GnuplotStream g;
          initScript(output);
          searchFiles(dir);
          arquivo << "unset output" << endl;
          arquivo.close();
          g.executarScript(string("script"));
     }catch(GnuplotStreamException eg){
          cout << VERMELHO << eg.what() << NORMAL << endl;
          cout << VERMELHO << "Somente um arquivo de script será criado!!" << NORMAL << endl;
          initScript(output);
          searchFiles(dir);
          arquivo << "unset output\n" << endl;
          arquivo.close();
     }
     return EXIT_SUCCESS;
}

void initScript(string name){
          arquivo << "reset" << endl;
          arquivo << "clear" << endl;
          arquivo << "set terminal postscript eps enhanced color solid linewidth 1.0 font 'Times-Roma,15'" << endl;
          arquivo << "set output '"<< name << ".eps'" << endl;
          arquivo << "set key below center" << endl;
          arquivo << "unset logscale" << endl;
          arquivo << "set style data histogram" << endl;
          arquivo << "set style histogram errorbars gap 2 lw 2" << endl;
          arquivo << "set bars fullwidth" << endl;
          arquivo << "set boxwidth 1 relative" << endl;
          arquivo << "set style fill solid 1 border lt -1" << endl;
          arquivo << "set title '"<< "Comparacao de Desenpenho" << "'" << endl;
          arquivo << "set xlabel '"<< "Tamanho da mensagem (Bytes)" << "'" << endl;
          arquivo << "set ylabel '"<< "Tempo de execucao (millisegundos)" << "'" << endl;
}

bool searchFiles(string name){
     DIR * diretorio;
     struct dirent *dp;
     diretorio= opendir(name.c_str());
     arquivo << "plot ";
     int files=0;
     if(diretorio!=NULL){
        while ((dp = readdir(diretorio)) != NULL){
             if((string(dp->d_name).compare(".")!=0)&&(string(dp->d_name).compare("..")!=0)){
                  if(files>0)arquivo << ",\\\n " ;
                  files++;
                  arquivo <<"'" << name << "/" << dp->d_name << "' u (column('media')):(column('erro')):xtic(1) t '" << getTitulo(string(dp->d_name)) << "'";
             }
        }
        arquivo << ";" << endl;
        (void)closedir(diretorio);
        if(files==0){
             cout << "Nenhum arquivo encontrado no diretório: " << name << endl;
             return false;
        }
        return true;
      }
     return false;
}

string getTitulo(const string filename){
     stringstream ret;
     string aux;
     stringstream ss(filename);
     int count=0;
     while(std::getline(ss,aux,'.')){
          count++;
          if(count==3){
               if((aux.compare("10")==0)||(aux.compare("100")==0))ret << aux << "Mbps ";
               else ret << "1Gbps ";
          }
     }
     ret << aux;
     return ret.str();
}