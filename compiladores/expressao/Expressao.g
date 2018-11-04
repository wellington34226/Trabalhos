grammar Expressao;

@header{
package expressao;
import java.util.HashMap;
}

@lexer::header {package expressao;} 

@members{
HashMap memory = new HashMap();
}

prog
	: stat+;
stat
	:	expr NEWLINE {System.out.println($expr.value);}
      	|	ID '=' expr NEWLINE {memory.put($ID.text,new Integer($expr.value));}
      	|	NEWLINE;
expr	returns [int value]
	:	e=mult {$value = $e.value;}
		( '+' e=mult {$value += $e.value;}
	| 	'-' e=mult {$value -=$e.value;})*;
mult	returns [int value]
	:	e=atom {$value = $e.value;} 
		( '*' e=atom {$value *= $e.value;}
	|	'/' e=atom {if ($e.value!=0)$value = $value/$e.value;
		else System.err.println("Operacao ilegal.\nDivisao por zero! "+$e.value);})*;
atom	returns [int value]
	:	INT {$value = Integer.parseInt($INT.text);}
      	|	ID {Integer v = (Integer)memory.get($ID.text);
      			if(v!=null) $value=v.intValue();
      			else System.err.println("undefined varible "+$ID.text);}
      	|	'('expr')' {$value = $expr.value;};
ID 	:	('a'..'z'|'A'..'Z')+ ; 
INT	:   	'0'..'9'+ ; 
NEWLINE	:	'\r'? '\n' ; 
WS 	:	(' '|'\t'|'\r'|'\n')+ {skip();} ;
