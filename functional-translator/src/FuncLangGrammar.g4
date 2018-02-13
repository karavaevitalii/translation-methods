grammar FuncLangGrammar;
import LexerRules;

prog : func* ;

func : ID '::' TYPE ('->' TYPE)* ';' decl+ ;

decl : ID var* '=' impl ';'
    | otherwise
    ;

var : ID | INT | BOOL ;

impl : boolExpr ('->' unaryExpr)*
    | unaryExpr
    ;

otherwise : 'otherwise ->' impl ';' ;

boolExpr : boolExpr op=(AND | OR) boolExpr
    | ID
    | BOOL
    | NOT boolExpr
    | unaryExpr op=(EQ | NE | GT | GE | LT | LE) unaryExpr
    | boolExpr op=(EQ | NE) boolExpr
    | innerFunc
    | '(' boolExpr ')'
    ;

innerFunc : '(' ID expr* ')' ;

unaryExpr:
    '-'? expr
    ;

expr: expr op=(ADD | SUB | MUL | DIV | MOD) expr
    | ID
    | INT
    | innerFunc
    | '(' expr ')'
    ;