grammar wellingtonTrabalho12;

@header{
package wellingtonTrabalho12;
import java.util.HashMap;
}

@lexer::header {package wellingtonTrabalho12;}

@members{
HashMap memory = new HashMap();
}

prog	
	:	BEGIN NEWLINE start NEWLINE END NEWLINE;
	
start
	:	decls NEWLINE coms;
	
decls
	:	(decl';' (NEWLINE)*)+ ;
	
decl	
	:	INTEGER ' ' e=ID {memory.put($e.text,new Integer(0));}(','e=ID {memory.put($e.text,new Integer(0));})*;
	
coms	
	:	(com ';' (NEWLINE)*)+ ;
	
com	
	:	ID '=' expr {Integer v = (Integer)memory.get($ID.text);
      			if(v!=null) memory.put($ID.text,new Integer($expr.value));
      			else System.err.println("Variavel nao definida: " + $ID.text);}
	|	'print('ePrints')'{System.out.println($ePrints.value);}
	;

ePrints returns [String value]
	:	e=expr {$value=new String((new Integer($e.value)).toString());}
		(',' e=expr {$value=value.concat("\n").concat(new String((new Integer($e.value)).toString()));})*;

expr	returns [int value]
	:	e=multexpr {$value = $e.value;}
		('+' e=multexpr {$value += $e.value;}
	|	'-' e=multexpr {$value -=$e.value;})*
	;
	
multexpr returns [int value]
	:	e=atom {$value = $e.value;}
		('*' e=atom {$value *= $e.value;}
	|	'/' e=atom {if ($e.value!=0)$value = $value/$e.value;
		else System.err.println("Operacao ilegal. Divisao por zero! " + $value + "/" +$e.value);})*
	;
	
atom	returns [int value]
	:	INT {$value = Integer.parseInt($INT.text);}
	|	ID {Integer v = (Integer)memory.get($ID.text);
      			if(v!=null) $value=v.intValue();
      			else System.err.println("Variavel nao definida: " + $ID.text);}
	|	'('expr')' {$value = $expr.value;}
	|	'('com','expr {$value = $expr.value;}')'
	;
	
BEGIN	:	('BEGIN');
END	:	('END');
INTEGER	:	('integer');
ID 	:	('a'..'z'|'A'..'Z'|'_')('0'..'9'|'a'..'z'|'A'..'Z'|'_')*; 
INT	:   	'0'..'9'+ ;
NEWLINE	:	'\r'?'\n' ;
WS 	:	(' '|'\t'|'\r'|'\n')+ {skip();};

