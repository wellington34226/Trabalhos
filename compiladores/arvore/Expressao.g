grammar Expressao;

options{
output=AST;
ASTLabelType=CommonTree;
}

prog
	: (stat{System.out.println($stat.tree==null?"null":$stat.tree.toStringTree());})+;
stat
	:	expr NEWLINE -> expr
      	|	ID '=' expr NEWLINE -> ^('=' ID expr)
      	|	NEWLINE -> ;
expr
	:	mult
		(('+'^ | '-'^) mult)*;
mult
	:	atom
		( ('*'^ | '/'^) atom)*;
atom
	:	INT
    |	ID
    |	'('!expr')'!;
ID 	:	('a'..'z'|'A'..'Z')+ ; 
INT	:   	'0'..'9'+ ; 
NEWLINE	:	'\r'? '\n' ; 
WS 	:	(' '|'\t'|'\r'|'\n')+ {skip();} ;
