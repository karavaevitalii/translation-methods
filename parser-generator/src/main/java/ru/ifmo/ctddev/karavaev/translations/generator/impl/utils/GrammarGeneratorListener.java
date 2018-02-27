package ru.ifmo.ctddev.karavaev.translations.generator.impl.utils;

import antlr.GrammarGeneratorBaseListener;
import antlr.GrammarGeneratorParser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GrammarGeneratorListener extends GrammarGeneratorBaseListener {
    private final static String EPS = "EPS";

    private String pckg         = "";
    private String imports      = "";
    private String members      = "";
    private String startRule    = "";
    private String returnedType = "";

    private final Map<String, Rule> terminals       = new HashMap<>();
    private final Map<String, Rule> nonTerminals    = new HashMap<>();

    public String getPckg() {
        return pckg;
    }

    public String getImports() {
        return imports;
    }

    public String getMembers() {
        return members;
    }

    public String getStartRule() {
        return startRule;
    }

    public String getReturnedType() {
        return returnedType;
    }

    public Map<String, Rule> getTerminals() {
        return terminals;
    }

    public Map<String, Rule> getNonTerminals() {
        return nonTerminals;
    }

    @Override
    public void enterStartRule(GrammarGeneratorParser.StartRuleContext ctx) {
        startRule = ctx.NON_TERM_NAME().getText();
        returnedType = ctx.returnedAttr().getText();
    }

    @Override
    public void enterPckg(GrammarGeneratorParser.PckgContext ctx) {
        TerminalNode n = ctx.PCKG_NAME();
        if (n != null)
            pckg = convertToJavaCode(n);

    }

    @Override
    public void enterImports(GrammarGeneratorParser.ImportsContext ctx) {
        int i = 0;
        TerminalNode n;
        StringBuilder sb = new StringBuilder();
        while (!Objects.isNull(n = ctx.IMPORT(i)))
            sb.append(convertToJavaCode(n));
        imports = sb.toString();
    }

    @Override
    public void enterMembers(GrammarGeneratorParser.MembersContext ctx) {
        TerminalNode n = ctx.CODE();
        if (n != null)
            members = convertToJavaCode(n);
    }

    @Override
    public void enterTermRule(GrammarGeneratorParser.TermRuleContext ctx) {
        Rule r = addTerminalRule(ctx.TERM_NAME().getText());

        for (GrammarGeneratorParser.TerminalProductionContext c : ctx.terminalProduction()) {
            Production p = new Production();
            StringBuilder sb = new StringBuilder();
            for (TerminalNode n : c.STRING()) {
                final String text = n.getText();
                sb.append(text.substring(1, text.length() -1 ));
            }
            p.addRule(new Rule(sb.toString()));
            r.addProduction(p);
        }
    }

    @Override
    public void enterNonTermRule(GrammarGeneratorParser.NonTermRuleContext ctx) {
        final Rule rule = addNonTerminalRule(ctx.NON_TERM_NAME().getText());
        if (ctx.localAttrs() != null) {
            for (GrammarGeneratorParser.AttrContext localAttr : ctx.localAttrs().attr()) {
                rule.addLocalAttr(localAttr.attrName().getText(), localAttr.attrType().getText());
            }
        }
        if (ctx.returnedAttr() != null) {
            rule.setReturnedType(ctx.returnedAttr().attrType().getText());
        }
        for (GrammarGeneratorParser.NonTerminalProductionContext productionContext : ctx
                .nonTerminalProduction()) {
            Production production = new Production();
            if (productionContext.nonTermVariations().isEmpty()) {
                production.addRule(addTerminalRule(EPS));
            }
            for (GrammarGeneratorParser.NonTermVariationsContext variationsContext : productionContext.nonTermVariations()) {
                Rule productionRule;
                if (variationsContext.TERM_NAME() != null) {
                    productionRule = new Rule(variationsContext.TERM_NAME().getText());
                } else if (variationsContext.NON_TERM_NAME() != null) {
                    productionRule = new Rule(variationsContext.NON_TERM_NAME().getText());
                    if (variationsContext.args() != null) {
                        for (TerminalNode attr: variationsContext.args().CODE()) {
                            productionRule.addArg(convertToJavaCode(attr));
                        }
                    }
                } else {
                    throw new RuntimeException("Unexpected variationsContext");
                }
                production.addRule(productionRule);
            }
            if (productionContext.CODE() != null) {
                production.setCode(convertToJavaCode(productionContext.CODE()));
            }
            rule.addProduction(production);
        }
    }

    public void addEndRule(final String ruleName) {
        addTerminalRule(ruleName);
    }

    public boolean inTerminals(final String rule) {
        return terminals.containsKey(rule);
    }

    public boolean inNonTerminals(final String rule) {
        return nonTerminals.containsKey(rule);
    }

    private String convertToJavaCode(final TerminalNode n) {
        String javaCode = n.getText().trim();
        if (javaCode.startsWith("{") && javaCode.endsWith("}"))
            return javaCode.substring(1, javaCode.length() - 1).trim();
        return javaCode;
    }

    private Rule addTerminalRule(final String ruleName) {
        if (!terminals.containsKey(ruleName))
            terminals.put(ruleName, new Rule(ruleName));
        return terminals.get(ruleName);
    }

    private Rule addNonTerminalRule(final String ruleName) {
        if (!nonTerminals.containsKey(ruleName))
            nonTerminals.put(ruleName, new Rule(ruleName));
        return nonTerminals.get(ruleName);
    }
}
