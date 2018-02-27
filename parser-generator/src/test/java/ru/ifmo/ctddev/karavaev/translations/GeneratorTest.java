package ru.ifmo.ctddev.karavaev.translations;

import ru.ifmo.ctddev.karavaev.translations.generator.Generator;
import ru.ifmo.ctddev.karavaev.translations.generator.impl.LexerGenerator;
import ru.ifmo.ctddev.karavaev.translations.generator.impl.ParserGenerator;
import ru.ifmo.ctddev.karavaev.translations.generator.impl.TokensGenerator;

import java.io.File;
import java.io.IOException;

public class GeneratorTest {
    private static final File GRAMMAR_FILE = new File("src/test/java/grammar/Math.gram");

    public static void main(String[] args) throws IOException {
        Generator[] generators = {
                new TokensGenerator(GRAMMAR_FILE),
                new LexerGenerator(GRAMMAR_FILE),
                new ParserGenerator(GRAMMAR_FILE)
        };

        for (Generator generator : generators) {
            generator.generate();
        }
    }
}
