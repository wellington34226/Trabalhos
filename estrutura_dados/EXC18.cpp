/*Implementar a função ou exclusivo como função hash que transforma uma string
de 8 letras maiúsculas em um número inteiro de 16 bits.*/
/*A funcao XorString efetua uma transformacao de 8 letras para um numero inteiro
de 16bits pega dois caracteres de 8bits em junta em um inteiro de 16 e para cada
par de inteiro de 16bits ela efetua a operacao Xor entre os inteiros
ao final pega o par resultante e efetua uma nova operacao Xor*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int XorString(char* string);

char string[9];
int resultado,i;

int main(int argc, char *argv[]){
	do{
		for(i=0;i<9;i++)string[i]=' ';
		printf("Informe uma string com 8 caracteres:");
		gets(string);
		for(i=0;i<9;i++)if(string[i]=='\0')break;
		if((i!=8)&&(i!=0))
			printf("String nao tem 8 caracteres!\n");
		if(i==8){
			resultado=XorString(string);
			printf("A string %s equivale ao numero %d em 16bits.\n",string,resultado);
		}
	}while(string[0]!='\0');
	printf("\n");
	system("pause");
}

int XorString(char* string){
	int op1;
	int op2;
	int res1,res2,retorno,i=0;
	op1=string[i];//recebe o primeiro caracter
	op1<<8;//deloca o primeiro caracter para os 8 bits finais
	op1=op1+string[i+4];//coloca o segundo caracter
	i=1;
	op2=string[i];//recebe o primeiro caracter
	op2<<8;//deloca o primeiro caracter para os 8 bits finais
	op2=string[i+4];//coloca o segundo caracter
	res1=op1^op2;//efetua a primeira operacao XOR com 4 caracteres
	i=2;
	op1=string[i];//recebe o primeiro caracter
	op1<<8;//deloca o primeiro caracter para os 8 bits finais
	op1=op1+string[i+4];//coloca o segundo caracter
	i=3;
	op2=string[i];//recebe o primeiro caracter
	op2<<8;//deloca o primeiro caracter para os 8 bits finais
	op2=string[i+4];//coloca o segundo caracter
	res2=op1^op2;//efetua a segunda operacao XOR com 4 caracteres
	retorno=res1^res2;//efetua a operacao XOR final com o par de inteiros resultantes
	return retorno;//retorna o valor da operacao XOR feita
}
