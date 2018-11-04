tree grammar wellingtonTrabalho3Arv;

options{
tokenVocab=wellingtonTrabalho3;
ASTLabelType=CommonTree;
}

@header{
import java.util.HashMap;
}

@members{
HashMap memory=new HashMap();
}

prog	
	:	BEGIN NEWLINE start NEWLINE END NEWLINE;
	
start
	:	decls NEWLINE coms;

decls
	:	(decl';' (NEWLINE)*)+;
	
decl	
	:	^(INTEGER ( e=ID {memory.put($e.text,new Integer(0));})+);
	
coms	
	:	(com (NEWLINE)*)+ ;
	
com	
	:	^('=' ID expr) {memory.put($ID.text,new Integer($expr.value));}
	|	^('print('ePrints')') {System.out.println($ePrints.value);}
	;
	
ePrints returns [String value]
	:	e=expr {$value=new String((new Integer($e.value)).toString());}
		(e=expr {$value=value.concat("\n").concat(new String((new Integer($e.value)).toString()));})*;
	
expr	returns [int value]
	:	^('+' a=expr b=expr) {$value = a+b;}
	|	^('-' a=expr b=expr) {$value = a-b;}
	|	^('*' a=expr b=expr) {$value = a*b;}
	|	^('/' a=expr b=expr) {if(b!=0)$value = a/b;
			else System.out.println("Operacao ilegal. Divisao por zero! " + a + "/" + b);}
	|	^(',' com a=expr) {$value = a;}
	|	ID {
			Integer v=(Integer)memory.get($ID.text);
			if(v!=null) $value=v.intValue();
			else System.out.println("Variavel nao definida: " + $ID.text);
		}
	|	INT {$value= Integer.parseInt($INT.text);} 
	;


