package ru.ifmo.ctddev.karavaev.translations.generator.impl.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Production {
    private final List<Rule> rules = new ArrayList<>();
    private String code;

    public void addRule(final Rule rule) {
        rules.add(rule);
    }

    public List<Rule> getRules() {
        return rules;
    }

    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(" ");
        for (Rule rule : rules) {
            sj.add(rule.toString());
        }
        return sj.toString();
    }
}
