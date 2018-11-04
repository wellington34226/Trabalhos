/*
F(x)=E^-((x-M)²/(2D²))/(D(2Pi)²)

V=SUM(x-M)^2/N =>> V^2=D

e=ZD/RAIZ(N) <=> N=(ZD/e)^2

S=RAIZ(SUM(x-M)^2/N-1)
*/
#ifndef CALCULOS_HPP
#define CALCULOS_HPP
#include <cmath>
#include <stdlib.h>
#include <vector>

using namespace std;

class Calculos {
public:
     Calculos():N(0),soma(0),M(0),V(0),D(0),e(0),z(2.33){}//z fixo em 2.33 para um intervalo de confiança de 98%
     Calculos(float zc):N(0),soma(0),M(0),V(0),D(0),e(0){if(zc>0){z=zc;}else{z=2.33;}}//para diferentes intervalos de confiança
     virtual ~Calculos(){}
     
     void pushValor(float valor);//insere os valores da amostra caso o valor informado seja maior que 0
     float getMedia();//caso a lista de valores não esteja vazia, calcula a média dos valores já inseridos
     float getDesvio();//caso a média seja diferente de zero (nenhuma média foi calculada), calcula o desvio padrão baseado na média e retorna.
     float getErro();//calcula o erro para as amostras informadas
     /*para erro entre 0<erro<1 (0%<erro<100% da média) retorna a quantidade necessária de amostras para se ter a confiança necessária
     para valores fora retorna a quantidade de amostras já inseridas*/
     int getN(float erro);
     void limpar();//limpa as vaiáveis para um novo conjunto de amostras
private:
     int N;//número de amostras
     /*soma,média,variância,desvio padrão,erro,coeficiente para intervalo de confiança*/
     float soma,M,V,D,e,z;
     vector<float> valores;//vetor de valores
};
#endif /* CALCULOS_HPP */