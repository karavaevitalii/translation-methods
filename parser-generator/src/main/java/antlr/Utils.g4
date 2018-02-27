lexer grammar Utils;

NON_TERM_NAME
    : [a-z][a-zA-Z_0-9]*
    ;

TERM_NAME
    : [A-Z][a-zA-Z_0-9]*
    ;

PCKG_NAME
    : ([a-z0-9] | '.')+
    ;

IMPORT
    : ([a-z0-9] | '.')+
    ;

STRING
    : '\'' ~'\''+ '\''
    ;

CODE
    : '{' (~[{}]+ CODE?)* '}'
    ;

WS
   : [ \t\r\n]+ -> skip
   ;