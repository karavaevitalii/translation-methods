package ru.ifmo.ctddev.karavaev.translations.generator.impl.utils;

public enum Type {
    VOID("void"),
    STRING("String"),
    INTEGER("Integer"),
    DOUBLE("Double");

    private final String typeName;

    Type(final String typeName) {
        this.typeName = typeName;
    }

    public static Type fromString(final String type) {
        switch (type) {
            case "void":
                return Type.VOID;
            case "String":
                return Type.STRING;
            case "Integer":
                return Type.INTEGER;
            case "Double":
                return Type.DOUBLE;
                default:
                    throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

    @Override
    public String toString() {
        return typeName;
    }
}
