grammar FuncLangGrammar;

@header {
    import java.util.*;
}

@members {
    StringBuilder program = new StringBuilder();
}

prog
    @after {
        System.out.println(program.toString());
    }
    : fun*
    ;

fun
    @init {
        program.append("def ");
    }
    : ID '::' type ('->' type)* '{' impl stat '}' {
        program.append($ID.text)
            .append("(");

        if (!$impl.vars.isEmpty()) {
            program.append(String.join(", ", $impl.vars));
        }
        program.append("):\n");

        program.append($stat.statement);
        program.append("\n\n");
    }
    ;

impl returns [List<String> vars = new ArrayList<>()]
    : ID args '=' {
        $vars.addAll($args.names);
    }
    ;

stat returns [String statement]
    : ifstat { $statement = "    " + $ifstat.ifStat; }
    | expr { $statement = "    return " + $expr.expression; }
    ;

ifstat returns [String ifStat]
    : 'if' expr 'then' stat elseclause* {
        StringBuilder sb = new StringBuilder("if ");
        sb.append($expr.expression)
            .append(":\n    ")
            .append($stat.statement)
            .append("\n    ")
            .append($elseclause.elseClause);

        $ifStat = sb.toString();
    }
    ;

elseclause returns [String elseClause]
    : 'else' stat {
        String statement = $stat.statement;
        StringBuilder sb = new StringBuilder("else:\n    ");
        sb.append(statement);

        $elseClause = sb.toString();
    }
    | 'elif' expr 'then' stat elseclause* {
              StringBuilder sb = new StringBuilder("elif ");
              sb.append($expr.expression)
                  .append(":\n    ")
                  .append($stat.statement)
                  .append("\n    ")
                  .append($elseclause.elseClause);

              $elseClause = sb.toString();
    }
    ;

expr returns [String expression]
    : e1 = expr binop e2 = expr {
        StringBuilder sb = new StringBuilder($e1.expression);
        sb.append(" ")
            .append($binop.text)
            .append(" ")
            .append($e2.expression);

        $expression =  sb.toString();
    }
    | unop expr {
        $expression = $unop.text + $expr.expression;
    }
    | innerfunc     { $expression = $innerfunc.innerFunc;           }
    | '(' expr ')'  { $expression = "(" + $expr.expression + ")";   }
    | ID            { $expression = $ID.text;                       }
    | BOOL          { $expression = $BOOL.text;                     }
    | INT           { $expression = $INT.text;                      }
    | FLOAT         { $expression = $FLOAT.text;                    }
    | STRING        { $expression = $STRING.text;                   }
    ;

binop
    : '*'
    | '/'
    | '-'
    | '+'
    | '&&'
    | '||'
    | '=='
    | '!='
    | '<'
    | '<='
    | '>'
    | '>='
    ;

unop
    : '!'
    ;

innerfunc returns [String innerFunc]
    : '(' ID innerargs ')' {
        StringBuilder sb = new StringBuilder($ID.text);
        sb.append("(")
            .append(String.join(", ", $innerargs.innerArgs))
            .append(")");

        $innerFunc = sb.toString();
    }
    ;

innerargs returns [List<String> innerArgs = new ArrayList<>()]
    : expr ',' innerargs {
        $innerArgs.add($expr.expression);
        $innerArgs.addAll($innerargs.innerArgs);
    }
    | expr { $innerArgs.add($expr.expression); }
    ;

type
    : 'int' | 'float' | 'bool' | 'string'
    ;

args returns [List<String> names = new ArrayList<>()]
    :
    ( ID        { $names.add($ID.text);     }
    | INT       { $names.add($INT.text);    }
    | FLOAT     { $names.add($FLOAT.text);  }
    | BOOL      { $names.add($BOOL.text);   }
    | STRING    { $names.add($STRING.text); }
    )*
    ;

BOOL
    : 'true' | 'false'
    ;

ID
    : LETTER (LETTER|DIGIT)*
    ;
fragment LETTER
    : [a-zA-Z\u0080-\u00FF_]
    ;

INT
    : '-'? DIGIT+
    ;

FLOAT
    : '-'? '.' DIGIT+ | DIGIT+ ('.' DIGIT*)
    ;
fragment DIGIT
    : [0-9]
    ;

STRING
    : '"' ( '\\"' | . )*? '"'
    ;

WS  : [ \t\r\n]+ -> skip ;