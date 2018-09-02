package ru.ifmo.ctddev.karavaev.translations;

import grammar.generated.MathParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathParserTest {
    private MathParser createParser(String expression) {
        return new MathParser(expression);
    }

    @Test
    public void parseDecimal() {
        final MathParser mathParser = createParser("2");
        final Integer parsed = mathParser.parse();
        assertEquals(2, (int) parsed, "Parse decimal");
    }

    @Test
    public void parseHex() {
        final MathParser mathParser = createParser("0xf");
        final Integer parsed = mathParser.parse();
        assertEquals(0xf, ((int) parsed), "Parse hex");
    }

    @Test
    public void parseSum() {
        final MathParser mathParser = createParser("2 + 2 + 2 + 2");
        final Integer parsed = mathParser.parse();
        assertEquals(8, ((int) parsed), "Sum");
    }

    @Test
    public void parseDif() {
        final Integer parsed = createParser("9 - 5 - 3").parse();
        assertEquals(1, ((int) parsed), "Parse difference");
    }

    @Test
    public void parseMul() {
        assertEquals(8, ((int) createParser("2*2*2").parse()), "Parse mul");
    }

    @Test
    public void parsePow() {
        assertEquals(16, ((int) createParser("2^2^2").parse()), "Parse pow");
    }

    @Test
    public void parseNegative() {
        assertEquals(-2, ((int) createParser("4-2*3").parse()), "Parse negative");
    }
}
