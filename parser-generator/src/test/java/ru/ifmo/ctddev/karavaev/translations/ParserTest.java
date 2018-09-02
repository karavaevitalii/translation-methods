package ru.ifmo.ctddev.karavaev.translations;

import grammar.generated.MathParser;

public class ParserTest {
    public static void main(String[] args) {
        MathParser parser = new MathParser("-0xa^2");
        System.out.println(parser.parse());
    }
}
