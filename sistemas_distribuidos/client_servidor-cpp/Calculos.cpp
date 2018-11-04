#include <algorithm>

#include "Calculos.hpp"

float Calculos::getMedia(){
     if(!valores.empty()){
          M=soma/valores.size();
     }
     return M;
}
float Calculos::getDesvio(){
     if(getMedia()>0){
          for(auto it = valores.begin(); it!=valores.end(); ++it){V=V+pow(*it-M,2);}
          V=V/valores.size();
          D=sqrt(V);
     }
     return D;
}
float Calculos::getErro(){
      if(getDesvio()>0){
          e=(z*D/sqrt(valores.size()))/M;//erro porcentagem da Média
     }
     return e;
}
int Calculos::getN(float erro){
     if((erro>0)&&(erro<1)){
          if(getDesvio()>0){
               N=pow(((z*D)/(erro*M)),2);//erro porcentagem da Média
               return N;
          }
     }
     return valores.size();
}
void Calculos::pushValor(float valor){
     if(valor>0){
          valores.push_back(valor);
          soma+=valor;
     }
}
void Calculos::limpar(){
    N=0;
    soma=0;
    M=0;
    V=0;
    D=0;
    e=0;
    valores.clear();
}