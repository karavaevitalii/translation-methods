grammar GrammarGenerator;
import Utils;

gram
    : pckg? imports? members? (startRule gramRule+)?
    ;

startRule
    : '|>' NON_TERM_NAME ('->' returnedAttr)?
    ;

pckg
    : '+package' PCKG_NAME
    ;

imports
    : ('+import' IMPORT)+
    ;

members
    : '+members' CODE
    ;

gramRule
    : NON_TERM_NAME '('localAttrs?')' ('->' returnedAttr)? ':='
    nonTerminalProduction ('|' nonTerminalProduction)*';'               #nonTermRule
    | TERM_NAME ':=' terminalProduction ('|' terminalProduction)*';'    #termRule
    ;

localAttrs
    : attr (',' attr)*
    ;

returnedAttr
    : attrType
    ;

nonTerminalProduction
    : nonTermVariations* CODE?
    ;

nonTermVariations
    : TERM_NAME
    | NON_TERM_NAME args?
    ;

terminalProduction
    : STRING+
    ;

attr
    : attrType attrName
    ;

args
    : '(' CODE (',' CODE)* ')'
    ;

attrType
    : identifier
    ;

attrName
    : identifier
    ;

identifier
    : NON_TERM_NAME
    | TERM_NAME
    ;