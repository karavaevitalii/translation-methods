package ru.ifmo.ctddev.karavaev.translations.generator.impl.utils;

import java.util.*;

public class Rule {
    private final String name;
    private Type retType;
    private final Map<String, Type> localAttrs = new HashMap<>();
    private final List<Production> productions = new ArrayList<>();
    private final List<String> args = new ArrayList<>();

    public Rule(final String name) {
        this.name = name;
    }

    public void addProduction(final Production p) {
        productions.add(p);
    }

    public void addLocalAttr(final String name, final String type) {
        localAttrs.put(name, Type.fromString(type));
    }

    public void setReturnedType(final String type) {
        this.retType = Type.fromString(type);
    }

    public void addArg(final String arg) {
        args.add(arg);
    }

    public List<Production> getProductions() {
        return productions;
    }

    public String getName() {
        return name;
    }

    public boolean isTerminal() {
        return (name.charAt(0) >= 'A' && name.charAt(0) <= 'Z');
    }

    public Type getRetType() {
        return retType;
    }

    public String getLocalAttrsAsString() {
        if (localAttrs.isEmpty())
            return "";

        StringJoiner sj = new StringJoiner(" ");
        for (Map.Entry<String, Type> attr : localAttrs.entrySet()) {
            sj.add(attr.getValue() + " " + attr.getKey());
        }

        return sj.toString();
    }

    public String getArgsAsString() {
        StringJoiner joiner = new StringJoiner(" ");
        args.forEach(joiner::add);
        return joiner.toString();
    }
}
