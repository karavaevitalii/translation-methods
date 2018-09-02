package grammar.generated;

public class MathLexer {
    private String expression;
    private MathTokens curToken;
    private String curTokenText;
    private int pos;
    public MathLexer(String expression) {
        this.expression = expression;
        this.pos = 0;
    }
    public boolean hasNextToken() {
        while (pos < expression.length() && isBlank(expression.charAt(pos))) {
            ++pos;
        }
        return pos != expression.length();
    }

    public MathTokens getNextToken() {
        if (!hasNextToken()) {
            curToken = MathTokens.EOF;
            curTokenText = "";
            return MathTokens.EOF;
        }
        if ((expression.startsWith("f", pos))) {
            pos += "f".length();
            curToken = MathTokens.NUMBER;
            curTokenText = "f";
            return MathTokens.NUMBER;
        }
        if ((expression.startsWith("e", pos))) {
            pos += "e".length();
            curToken = MathTokens.NUMBER;
            curTokenText = "e";
            return MathTokens.NUMBER;
        }
        if ((expression.startsWith("d", pos))) {
            pos += "d".length();
            curToken = MathTokens.NUMBER;
            curTokenText = "d";
            return MathTokens.NUMBER;
        }
        if ((expression.startsWith("c", pos))) {
            pos += "c".length();
            curToken = MathTokens.NUMBER;
            curTokenText = "c";
            return MathTokens.NUMBER;
        }
        if ((expression.startsWith("b", pos))) {
            pos += "b".length();
            curToken = MathTokens.NUMBER;
            curTokenText = "b";
            return MathTokens.NUMBER;
        }
        if ((expression.startsWith("a", pos))) {
            pos += "a".length();
            curToken = MathTokens.NUMBER;
            curTokenText = "a";
            return MathTokens.NUMBER;
        }
        if ((expression.startsWith("^", pos))) {
            pos += "^".length();
            curToken = MathTokens.POW;
            curTokenText = "^";
            return MathTokens.POW;
        }
        if ((expression.startsWith("9", pos))) {
            pos += "9".length();
            curToken = MathTokens.NUMBER;
            curTokenText = "9";
            return MathTokens.NUMBER;
        }
        if ((expression.startsWith("8", pos))) {
            pos += "8".length();
            curToken = MathTokens.NUMBER;
            curTokenText = "8";
            return MathTokens.NUMBER;
        }
        if ((expression.startsWith("7", pos))) {
            pos += "7".length();
            curToken = MathTokens.NUMBER;
            curTokenText = "7";
            return MathTokens.NUMBER;
        }
        if ((expression.startsWith("6", pos))) {
            pos += "6".length();
            curToken = MathTokens.NUMBER;
            curTokenText = "6";
            return MathTokens.NUMBER;
        }
        if ((expression.startsWith("5", pos))) {
            pos += "5".length();
            curToken = MathTokens.NUMBER;
            curTokenText = "5";
            return MathTokens.NUMBER;
        }
        if ((expression.startsWith("4", pos))) {
            pos += "4".length();
            curToken = MathTokens.NUMBER;
            curTokenText = "4";
            return MathTokens.NUMBER;
        }
        if ((expression.startsWith("3", pos))) {
            pos += "3".length();
            curToken = MathTokens.NUMBER;
            curTokenText = "3";
            return MathTokens.NUMBER;
        }
        if ((expression.startsWith("2", pos))) {
            pos += "2".length();
            curToken = MathTokens.NUMBER;
            curTokenText = "2";
            return MathTokens.NUMBER;
        }
        if ((expression.startsWith("1", pos))) {
            pos += "1".length();
            curToken = MathTokens.NUMBER;
            curTokenText = "1";
            return MathTokens.NUMBER;
        }
        if ((expression.startsWith("0x", pos))) {
            pos += "0x".length();
            curToken = MathTokens.HEX;
            curTokenText = "0x";
            return MathTokens.HEX;
        }
        if ((expression.startsWith("0", pos))) {
            pos += "0".length();
            curToken = MathTokens.NUMBER;
            curTokenText = "0";
            return MathTokens.NUMBER;
        }
        if ((expression.startsWith("-", pos))) {
            pos += "-".length();
            curToken = MathTokens.MINUS;
            curTokenText = "-";
            return MathTokens.MINUS;
        }
        if ((expression.startsWith("+", pos))) {
            pos += "+".length();
            curToken = MathTokens.PLUS;
            curTokenText = "+";
            return MathTokens.PLUS;
        }
        if ((expression.startsWith("*", pos))) {
            pos += "*".length();
            curToken = MathTokens.MUL;
            curTokenText = "*";
            return MathTokens.MUL;
        }
        if ((expression.startsWith(")", pos))) {
            pos += ")".length();
            curToken = MathTokens.R_PAR;
            curTokenText = ")";
            return MathTokens.R_PAR;
        }
        if ((expression.startsWith("(", pos))) {
            pos += "(".length();
            curToken = MathTokens.L_PAR;
            curTokenText = "(";
            return MathTokens.L_PAR;
        }
        throw new IllegalStateException("Unknown token from pos " + pos);
    }

    public String getExpression() {
        return expression;
    }

    public MathTokens getCurToken() {
        return curToken;
    }

    public String getCurTokenText() {
        return curTokenText;
    }

    public int getPos() {
        return pos;
    }

    private boolean isBlank(char c) {
        return c == ' ' || c == '\r' || c == '\n' || c == '\t';
    }

}
