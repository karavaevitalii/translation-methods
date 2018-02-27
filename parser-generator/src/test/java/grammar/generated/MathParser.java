package grammar.generated;

public class MathParser {
    private MathLexer lex;
    public MathParser(String expression) {
        this.lex = new MathLexer(expression);
    }
    public Integer parse() {
        lex.getNextToken();
        return expr();
    }

    private Integer fact() {
        MathTokens token = lex.getCurToken();
        if (MathTokens.NUMBER == token) {
            String _NUMBER1 = lex.getCurTokenText();
            lex.getNextToken();
            return Integer.parseInt(_NUMBER1);
        }
        if (MathTokens.L_PAR == token) {
            String _L_PAR1 = lex.getCurTokenText();
            lex.getNextToken();
            Integer _expr1 = expr();
            String _R_PAR1 = lex.getCurTokenText();
            lex.getNextToken();
            return _expr1;
        }
        throw new AssertionError();
    }

    private Integer mul(Integer i) {
        MathTokens token = lex.getCurToken();
        if (MathTokens.MUL == token) {
            String _MUL1 = lex.getCurTokenText();
            lex.getNextToken();
            Integer _pterm1 = pterm();
            Integer _mul1 = mul(i * _pterm1);
            return _mul1;
        }
        if (MathTokens.R_PAR == token) {
            return i;
        }
        if (MathTokens.EOF == token) {
            return i;
        }
        if (MathTokens.PLUS == token) {
            return i;
        }
        if (MathTokens.MINUS == token) {
            return i;
        }
        throw new AssertionError();
    }

    private Integer pow(Integer i) {
        MathTokens token = lex.getCurToken();
        if (MathTokens.MUL == token) {
            return i;
        }
        if (MathTokens.POW == token) {
            String _POW1 = lex.getCurTokenText();
            lex.getNextToken();
            Integer _pterm1 = pterm();
            Integer _pow1 = pow((int) Math.pow(i, _pterm1));
            return _pow1;
        }
        if (MathTokens.R_PAR == token) {
            return i;
        }
        if (MathTokens.EOF == token) {
            return i;
        }
        if (MathTokens.PLUS == token) {
            return i;
        }
        if (MathTokens.MINUS == token) {
            return i;
        }
        throw new AssertionError();
    }

    private Integer expr() {
        MathTokens token = lex.getCurToken();
        if (MathTokens.NUMBER == token) {
            Integer _term1 = term();
            Integer _sum1 = sum(_term1);
            return _sum1;
        }
        if (MathTokens.L_PAR == token) {
            Integer _term1 = term();
            Integer _sum1 = sum(_term1);
            return _sum1;
        }
        throw new AssertionError();
    }

    private Integer sum(Integer i) {
        MathTokens token = lex.getCurToken();
        if (MathTokens.R_PAR == token) {
            return i;
        }
        if (MathTokens.EOF == token) {
            return i;
        }
        if (MathTokens.PLUS == token) {
            String _PLUS1 = lex.getCurTokenText();
            lex.getNextToken();
            Integer _term1 = term();
            Integer _sum1 = sum(i + _term1);
            return _sum1;
        }
        if (MathTokens.MINUS == token) {
            String _MINUS1 = lex.getCurTokenText();
            lex.getNextToken();
            Integer _term1 = term();
            Integer _sum1 = sum(i - _term1);
            return _sum1;
        }
        throw new AssertionError();
    }

    private Integer term() {
        MathTokens token = lex.getCurToken();
        if (MathTokens.NUMBER == token) {
            Integer _pterm1 = pterm();
            Integer _mul1 = mul(_pterm1);
            return _mul1;
        }
        if (MathTokens.L_PAR == token) {
            Integer _pterm1 = pterm();
            Integer _mul1 = mul(_pterm1);
            return _mul1;
        }
        throw new AssertionError();
    }

    private Integer pterm() {
        MathTokens token = lex.getCurToken();
        if (MathTokens.NUMBER == token) {
            Integer _fact1 = fact();
            Integer _pow1 = pow(_fact1);
            return _pow1;
        }
        if (MathTokens.L_PAR == token) {
            Integer _fact1 = fact();
            Integer _pow1 = pow(_fact1);
            return _pow1;
        }
        throw new AssertionError();
    }

}
