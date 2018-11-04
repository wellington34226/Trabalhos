grammar wellingtonTrabalho3;

options{
output=AST;
ASTLabelType=CommonTree;
}


prog	
	:	BEGIN NEWLINE start {System.out.println($start.tree==null?"null":$start.tree.toStringTree());} NEWLINE END NEWLINE;
	
start
	:	decls NEWLINE coms;

decls
	:	(decl';'! (NEWLINE)*)+;
	
decl	
	:	INTEGER ' ' ID (',' ID)* -> ^(INTEGER ID+);
	
coms	
	:	(com ';'! (NEWLINE)*)+;
	
com	
	:	ID '=' expr -> ^('=' ID expr)
	|	'print(' ePrints ')' -> ^('print(' ePrints ')')
	;
	
ePrints 
	:	expr (','! expr)*;
	
expr	
	:	multexpr
		(('+'^ | '-'^) multexpr)*;
	
multexpr 
	:	atom 
		(('*'^ | '/'^) atom)*;
	
atom
	:	INT
	|	ID
	|	'('!expr')'!
	|	'('com ',' expr')' -> ^(',' com expr)
	;
	
BEGIN	:	('BEGIN');
END	:	('END');
INTEGER	:	('integer');
ID 	:	('a'..'z'|'A'..'Z'|'_')('0'..'9'|'a'..'z'|'A'..'Z'|'_')*; 
INT	:   	'0'..'9'+ ;
NEWLINE	:	'\r'?'\n' ;
WS 	:	(' '|'\t'|'\r'|'\n')+ {skip();};

