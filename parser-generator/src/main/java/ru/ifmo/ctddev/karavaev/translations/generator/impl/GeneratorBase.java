package ru.ifmo.ctddev.karavaev.translations.generator.impl;

import antlr.GrammarGeneratorLexer;
import antlr.GrammarGeneratorParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import ru.ifmo.ctddev.karavaev.translations.generator.impl.utils.GrammarGeneratorListener;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GeneratorBase {
    protected static final String EOF = "EOF";
    protected static final String EPS = "EPS";
    protected final static String EXTENSION = ".java";
    protected final static String TOKENS    = "Tokens";
    protected final static String LEXER     = "Lexer";

    protected final String outputDirName;

    protected final GrammarGeneratorListener listener;
    protected final GrammarGeneratorParser parser;
    protected final File grammarFile;
    protected final String grammarName;

    public GeneratorBase(final File grammarFile)
            throws IOException {

        this.grammarFile = grammarFile;
        grammarName = grammarFile.getName().split("[.]")[0];
        outputDirName = grammarFile.getParent().split("[.]")[0] + File.separator + "generated";
        Files.createDirectories(Paths.get(outputDirName));

        listener = new GrammarGeneratorListener();
        parser = new GrammarGeneratorParser(
                new CommonTokenStream(
                        new GrammarGeneratorLexer(
                                CharStreams.fromFileName(grammarFile.getPath())
                        )
                )
        );

        new ParseTreeWalker().walk(listener, parser.gram());
        listener.addEndRule(EOF);
    }
}
