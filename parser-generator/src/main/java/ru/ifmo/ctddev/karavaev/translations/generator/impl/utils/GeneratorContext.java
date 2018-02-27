package ru.ifmo.ctddev.karavaev.translations.generator.impl.utils;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class GeneratorContext {
    private static final String INDENT = "    ";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String SEMICOLON = ";";

    private String generatingClassName = "";
    private List<Field> fields = new ArrayList<>();

    private int indent = 0;

    private final Writer w;

    public GeneratorContext(final Writer w) {
        this.w = w;
    }

    public void printPackage(final String packageName) throws IOException {
        w.write("package " + packageName + SEMICOLON + LINE_SEPARATOR + LINE_SEPARATOR);
    }

    public void printImport(final String importText) throws IOException {
        w.write("import " + importText + SEMICOLON + LINE_SEPARATOR + LINE_SEPARATOR);
    }

    public void printClassBegin(final Modifier modifier, final ClassType classType,
                                final String className) throws IOException {
        w.write(modifier.toString() + " " + classType.toString() + " " + className);
        openBrace();
        generatingClassName = className;
    }

    public void printClassEnd() throws IOException {
        closeBrace();
    }

    public void printEnumFields(List<String> fields) throws IOException {
        StringJoiner sj = new StringJoiner("," + LINE_SEPARATOR + "    ", "    ",
                ";" + LINE_SEPARATOR);
        fields.forEach(sj::add);
        w.write(sj.toString());
    }

    public void printFields(final Modifier modifier, final String members) throws IOException {
        String[] fields = members.split(" ");
        for (int i = 0; i < fields.length; i += 2) {
            printField(modifier, fields[i], fields[i + 1]);
        }
    }

    public void printField(final Modifier modifier, final String type, final String name)
            throws IOException {
        printIndent();
        this.fields.add(new Field(modifier, type, name));
        w.write(modifier.toString() + " " + type + " " + name + SEMICOLON + LINE_SEPARATOR);
    }

    public void printLexerConstructor() throws IOException {
        printIndent();
        w.write(Modifier.PUBLIC.toString() + " " + generatingClassName);
        final String[] args = {"String", "expression"};
        printArgs(args);
        openBrace();
        printExpression("this." + args[1], args[1]);
        printExpression("this.pos", "0");
        closeBrace();
    }

    public void printParserConstructor() throws IOException {
        printIndent();
        w.write(Modifier.PUBLIC.toString() + " " + generatingClassName);
        final String[] args = {"String", "expression"};
        printArgs(args);
        openBrace();
        printExpression("this.lex", "new " + generatingClassName.substring(0,
                generatingClassName.length() - 6) + "Lexer" + "(" + args[1] + ")");
        closeBrace();
    }


    public void printSimpleGetters() throws IOException {
        for (Field field : fields) {
            printMethodBegin(Modifier.PUBLIC, field.type, "get" +
                    field.name.substring(0, 1).toUpperCase() + field.name.substring(1), "");
            printReturnStatement(field.name);
            printMethodEnd();
        }
    }

    public void printMethodBegin(final Modifier modifier, final String retType, final String name,
                            final String args) throws IOException {
        printIndent();
        w.write(modifier.toString() + " " + retType + " " + name);
        printArgs(args.split(" "));
        openBrace();
    }

    public void printMethodEnd() throws IOException {
        closeBrace();
        w.write(LINE_SEPARATOR);
    }

    public void printIfBegin(final String expression) throws IOException {
        printIndent();
        w.write("if (" + expression + ")");
        openBrace();
    }

    public void printIfEnd() throws IOException {
        closeBrace();
    }

    public void printExpression(final String lhs, final String rhs) throws IOException {
        printIndent();
        w.write(lhs + " = " + rhs + SEMICOLON + LINE_SEPARATOR);
    }

    public void printStatement(final String statement) throws IOException {
        printIndent();
        w.write(statement + SEMICOLON + LINE_SEPARATOR);
    }

    public void printReturnStatement(final String statement) throws IOException {
        printIndent();
        w.write("return " + statement + SEMICOLON + LINE_SEPARATOR);
    }

    public void printWhileBegin(final String expression) throws IOException {
        printIndent();
        w.write("while (" + expression + ")");
        openBrace();
    }

    public void printWhileEnd() throws IOException {
        closeBrace();
    }

    private void printArgs(final String[] args) throws IOException {
        w.write("(");
        if (args.length > 1) {
            for (int i = 0; i < args.length; i += 2) {
                w.write(args[i] + " " + args[i + 1]);
                if (args.length - i > 2)
                    w.write(", ");
            }
        }
        w.write(")");
    }

    private void openBrace() throws IOException {
        w.write(" {" + LINE_SEPARATOR);
        ++indent;
    }

    private void closeBrace() throws IOException {
        --indent;
        printIndent();
        w.write("}" + LINE_SEPARATOR);
    }

    private void printIndent() throws IOException {
        for (int i = 0; i < indent; i++)
            w.write(INDENT);
    }

    private static class Field {
        final Modifier modifier;
        final String type;
        final String name;

        Field(Modifier modifier, String type, String name) {
            this.modifier = modifier;
            this.type = type;
            this.name = name;
        }
    }

    public enum Modifier {
        PRIVATE("private"),
        PROTECTED("protected"),
        PUBLIC("public");

        private final String modifier;

        Modifier(final String modifier) {
            this.modifier = modifier;
        }

        static Modifier fromString(final String modifier) {
            switch (modifier) {
                case "private":
                    return Modifier.PRIVATE;
                case "protected":
                    return Modifier.PROTECTED;
                case "public":
                    return Modifier.PUBLIC;
                    default:
                        throw new IllegalArgumentException("Unknown modifier: " + modifier);
            }
        }


        @Override
        public String toString() {
            return modifier;
        }
    }

    public enum ClassType {
        CLASS("class"),
        ENUM("enum");

        private final String classType;

        ClassType(final String classType) {
            this.classType = classType;
        }

        static ClassType fromString(final String classType) {
            switch (classType) {
                case "class":
                    return ClassType.CLASS;
                case "enum":
                    return ClassType.ENUM;
                    default:
                        throw new IllegalArgumentException("Unknown class type: " + classType);
            }
        }


        @Override
        public String toString() {
            return classType;
        }
    }
}
