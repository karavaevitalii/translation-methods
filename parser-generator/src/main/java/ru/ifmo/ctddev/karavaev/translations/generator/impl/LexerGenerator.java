package ru.ifmo.ctddev.karavaev.translations.generator.impl;

import edu.emory.mathcs.backport.java.util.Collections;
import ru.ifmo.ctddev.karavaev.translations.generator.Generator;
import ru.ifmo.ctddev.karavaev.translations.generator.impl.utils.GeneratorContext;
import ru.ifmo.ctddev.karavaev.translations.generator.impl.utils.Production;
import ru.ifmo.ctddev.karavaev.translations.generator.impl.utils.Rule;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

public class LexerGenerator extends GeneratorBase implements Generator {
    private static final String LEXER = "Lexer";

    public LexerGenerator(File grammarFile) throws IOException {
        super(grammarFile);
    }

    @Override
    public File generate() throws IOException {
        final String className = grammarName + LEXER;
        final String fileName = className + EXTENSION;
        final String tokens = grammarName + TOKENS;

        final File file = new File(outputDirName + File.separator + fileName);
        try (PrintWriter pw = new PrintWriter(file)) {
            GeneratorContext context = new GeneratorContext(pw);

            if (!listener.getPckg().isEmpty())
                context.printPackage(listener.getPckg());
            if (!listener.getImports().isEmpty())
                context.printImport(listener.getImports());

            context.printClassBegin(GeneratorContext.Modifier.PUBLIC,
                    GeneratorContext.ClassType.CLASS, className);

            generateFields(tokens, context);
            context.printLexerConstructor();
            generateHasNextToken(context);
            generateGetNextToken(tokens, context);
            context.printSimpleGetters();
            generateIsBlank(context);

            context.printClassEnd();

            return file;
        }
    }

    private void generateGetNextToken(String tokens, GeneratorContext context) throws IOException {
        context.printMethodBegin(GeneratorContext.Modifier.PUBLIC, tokens,
                "getNextToken", "");

        context.printIfBegin("!hasNextToken()");
        context.printExpression("curToken", tokens + ".EOF");
        context.printExpression("curTokenText", "\"\"");
        context.printReturnStatement(tokens + ".EOF");
        context.printIfEnd();

        final Map<String, String> sortedTerms =
                new TreeMap<String, String>(Collections.reverseOrder());
        for (Map.Entry<String, Rule> term : listener.getTerminals().entrySet()) {
            if (!(EPS.equals(term.getKey())) && !(EOF.equals(term.getKey()))) {
                for (Production production : term.getValue().getProductions()) {
                    sortedTerms.put(production.getRules().get(0).getName(), term.getKey());
                    final String token = production.getRules().get(0).getName();
                    final String tokName = term.getKey();

                }
            }
        }
        for (Map.Entry<String, String> term : sortedTerms.entrySet()) {
            final String token = term.getKey();
            final String tokName = term.getValue();
            context.printIfBegin("(expression.startsWith(\"" + token + "\", pos))");
            context.printStatement("pos += \"" + token + "\".length()");
            context.printExpression("curToken", tokens + "." + tokName);
            context.printStatement("curTokenText = \"" + token + "\"");
            context.printReturnStatement(tokens + "." + tokName);
            context.printIfEnd();
        }
        context.printStatement("throw new IllegalStateException(\"Unknown token from pos \" + pos)");
        context.printMethodEnd();
    }

    private void generateHasNextToken(GeneratorContext context) throws IOException {
        context.printMethodBegin(GeneratorContext.Modifier.PUBLIC, "boolean",
                "hasNextToken", "");
        context.printWhileBegin("pos < expression.length() && " +
                "isBlank(expression.charAt(pos))");
        context.printStatement("++pos");
        context.printWhileEnd();
        context.printReturnStatement("pos != expression.length()");
        context.printMethodEnd();
    }

    private void generateIsBlank(GeneratorContext context) throws IOException {
        context.printMethodBegin(GeneratorContext.Modifier.PRIVATE, "boolean", "isBlank",
                "char c");
        context.printReturnStatement("c == ' ' || c == '\\r' || c == '\\n' || c == '\\t'");
        context.printMethodEnd();
    }

    private void generateFields(String tokenName, GeneratorContext context) throws IOException {
        context.printField(GeneratorContext.Modifier.PRIVATE, "String", "expression");
        context.printField(GeneratorContext.Modifier.PRIVATE, tokenName, "curToken");
        context.printField(GeneratorContext.Modifier.PRIVATE, "String", "curTokenText");
        context.printField(GeneratorContext.Modifier.PRIVATE, "int", "pos");
        if (!listener.getMembers().isEmpty())
            context.printFields(GeneratorContext.Modifier.PRIVATE, listener.getMembers());
    }
}
