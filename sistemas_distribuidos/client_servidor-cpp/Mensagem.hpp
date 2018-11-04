#ifndef MENSAGEM_HPP
#define MENSAGEM_HPP
#include <string>
#include <sstream>

using namespace std;

class Mensagem {
public:
     Mensagem(int tamanho);
     virtual ~Mensagem(){}
     
     string getString() const{return mensagem;}
private:
     string mensagem;
};
#endif /* MENSAGEM_HPP */