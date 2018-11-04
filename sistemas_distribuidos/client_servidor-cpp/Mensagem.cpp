#include "Mensagem.hpp"

using namespace std;

Mensagem::Mensagem(int tamanho) {
     mensagem="";
     if(tamanho>0){
          for(int i=0;i<tamanho;i++){
               char c;
               if(i%2){
                    c=(char) ((i%(26))+65);
               }else{
                    c=(char) ((i%(26))+97);
               }
               mensagem+= c;
          }
     }
}