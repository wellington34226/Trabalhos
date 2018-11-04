tree grammar ExpArv;

options{
tokenVocab=Expressao;
ASTLabelType=CommonTree;
}

@header{
import  java.util.HashMap;
}

@members{
HashMap memory= new HashMap();
}

prog	:	stat+;
stat	:	expr {System.out.println($expr.value);}
	|	^('=' ID expr) {memory.put($ID.text, new Integer($expr.value));};
expr returns [int value]
	: ^('+' a=expr b=expr) {$value = a+b;}
	| ^('-' a=expr b=expr) {$value = a-b;}
	| ^('*' a=expr b=expr) {$value = a*b;}
	| ^('/' a=expr b=expr) {if(b!=0)$value = a/b;
			else System.out.print("Divisao por zero nao permitida!!!" + a + '/');}
	| ID {
		Integer v=(Integer)memory.get($ID.text);
		if(v!=null) $value=v.intValue();
		else System.out.println("undefined variable "+$ID.text);
	}
	| INT {$value = Integer.parseInt($INT.text);}
	;
