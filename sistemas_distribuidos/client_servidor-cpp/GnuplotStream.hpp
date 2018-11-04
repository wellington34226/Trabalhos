#ifndef GNUPLOTSTREAM_HPP
#define GNUPLOTSTREAM_HPP

#include <iostream>
#include <string>
#include <stdexcept> 
#include <cstdio>     
#include <cstdlib>
#include <unistd.h>
#include "pstream.h" //para execução de programas no shell

using namespace std;

class GnuplotStreamException : public std::runtime_error
{
    public:
        GnuplotStreamException(const string &msg) : runtime_error(msg){}
};

class GnuplotStream{

     private:
          string    m_sGNUPlotFileName; 
          
          void    init();                       
     public:
          //Construtores
          GnuplotStream();
         // Destrutor
          ~GnuplotStream(){}
          
          void executarScript(string filein);
};

//------------------------------------------------------------------------------
//
// Construtor: define arquivo de saída como graficos.eps
//
inline GnuplotStream::GnuplotStream():
        m_sGNUPlotFileName("gnuplot"){
     
     init();//Inicializa objeto
}

void GnuplotStream::init(){
     
     string exec(m_sGNUPlotFileName+" --version");
     redi::ipstream exec_gnuplot(exec, redi::pstreams::pstderr);
     string line;
     if(getline(exec_gnuplot.err(),line)){
          throw GnuplotStreamException("Não foi possível executar o comando: "+m_sGNUPlotFileName+"\n"+line);
     }
     return;
}

void GnuplotStream::executarScript(string filein){
      
      string exec(m_sGNUPlotFileName+" "+filein);
      redi::ipstream exec_gnuplot(exec, redi::pstreams::pstderr);
      string line;
      if(getline(exec_gnuplot.err(),line)){
          cout << "Erro\n" << line << endl;
          while(getline(exec_gnuplot.err(),line)){
               cout << line << endl;
          }
      }
      return;
}
#endif /* GNUPLOTSTREAM_HPP */

