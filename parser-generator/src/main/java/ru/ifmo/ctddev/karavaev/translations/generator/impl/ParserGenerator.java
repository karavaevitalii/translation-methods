package ru.ifmo.ctddev.karavaev.translations.generator.impl;

import ru.ifmo.ctddev.karavaev.translations.generator.Generator;
import ru.ifmo.ctddev.karavaev.translations.generator.impl.utils.GeneratorContext;
import ru.ifmo.ctddev.karavaev.translations.generator.impl.utils.Production;
import ru.ifmo.ctddev.karavaev.translations.generator.impl.utils.Rule;
import ru.ifmo.ctddev.karavaev.translations.generator.impl.utils.Type;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class ParserGenerator extends GeneratorBase implements Generator {
    private static final String PARSER = "Parser";
    private static final String LEX = "lex";

    private final Map<String, HashSet<String>> first;
    private final Map<String, HashSet<String>> follow;

    public ParserGenerator(File grammarFile) throws IOException {
        super(grammarFile);

        first = calculateFirst();
        follow = calculateFollow();
    }

    @Override
    public File generate() throws IOException {
        final String className = grammarName + PARSER;
        final String fileName = className + EXTENSION;
        final String tokens = grammarName + TOKENS;
        final String lexer = grammarName + LEXER;

        final File file = new File(outputDirName + File.separator + fileName);
        try (PrintWriter pw = new PrintWriter(file)) {
            GeneratorContext context = new GeneratorContext(pw);

            if (!listener.getPckg().isEmpty())
                context.printPackage(listener.getPckg());
            if (!listener.getImports().isEmpty())
                context.printImport(listener.getImports());

            context.printClassBegin(GeneratorContext.Modifier.PUBLIC,
                    GeneratorContext.ClassType.CLASS, className);

            context.printField(GeneratorContext.Modifier.PRIVATE, lexer, LEX);
            if (!listener.getMembers().isEmpty())
                context.printFields(GeneratorContext.Modifier.PRIVATE, listener.getMembers());
            final String[] args = {"String", "expression"};
            final String[] types = {lexer};
            context.printParserConstructor();

            generateParseMethod(context);

            generateRestMethods(tokens, context);

            context.printClassEnd();

            return file;
        }
    }

    private void generateRestMethods(String tokens, GeneratorContext context) throws IOException {
        for (Map.Entry<String, Rule> entry : listener.getNonTerminals().entrySet()) {
            final String name = entry.getKey();
            final Rule rule = entry.getValue();
            final List<Production> productions = rule.getProductions();
            final Set<String> terms = new HashSet<>(first.get(name));
            if (terms.contains(EPS)) {
                terms.addAll(follow.get(name));
                terms.remove(EPS);
            }

            context.printMethodBegin(GeneratorContext.Modifier.PRIVATE,
                    rule.getRetType().toString(), name, rule.getLocalAttrsAsString());
            context.printExpression(tokens + " token", LEX + ".getCurToken()");

            for (String term : terms) {
                context.printIfBegin(tokens + "." + term + " == token");

                Production suitableProduction = null;
                for (Production production : productions) {
                    if (first.get(production.getRules().get(0).getName()).contains(term)) {
                        suitableProduction = production;
                    }
                }
                if (Objects.isNull(suitableProduction)) {
                    for (Production production : productions) {
                        if (EPS.equals(production.getRules().get(0).getName())) {
                            if (production.getCode() != null) {
                                context.printStatement(production.getCode());
                                break;
                            }
                        }
                    }
                } else {
                    final List<Rule> productionRules = suitableProduction.getRules();
                    final Map<String, Integer> sameRulesCount = new HashMap<>();

                    for (Rule r : productionRules) {
                        if (!sameRulesCount.containsKey(r.getName()))
                            sameRulesCount.put(r.getName(), 1);
                        else
                            sameRulesCount.put(r.getName(), sameRulesCount.get(r.getName()) + 1);

                        final String varName = generateVarName(r, sameRulesCount.get(r.getName()));
                        if (r.isTerminal()) {
                            context.printExpression("String " + varName, LEX +
                                    ".getCurTokenText()");
                            context.printStatement(LEX + ".getNextToken()");
                        } else {
                            final Rule ruleWithInfo = listener.getNonTerminals().get(r.getName());
                            final Type ruleReturnType = ruleWithInfo.getRetType();
                            final String args = r.getArgsAsString();
                            if (ruleReturnType == Type.VOID)
                                context.printStatement(r.getName() + "(" + args + ")");
                            else
                                context.printExpression(ruleReturnType.toString() + " "
                                        + varName, r.getName() + "(" + args +
                                        ")");
                        }
                    }
                    if (suitableProduction.getCode() != null)
                        context.printStatement(suitableProduction.getCode());
                }

                context.printIfEnd();
            }

            context.printStatement("throw new AssertionError()");
            context.printMethodEnd();
        }
    }

    private String generateVarName(final Rule rule, final int i) {
        return "_" + rule.getName() + String.valueOf(i);
    }

    private void generateParseMethod(GeneratorContext context) throws IOException {
        Type returnedType = Type.fromString(listener.getReturnedType());
        context.printMethodBegin(GeneratorContext.Modifier.PUBLIC, returnedType.toString(),
                "parse", "");
        context.printStatement(LEX + ".getNextToken()");
        final String statement = listener.getStartRule() + "()";
        if (returnedType == Type.VOID)
            context.printStatement(statement);
        else
            context.printReturnStatement(statement);
        context.printMethodEnd();
    }

    private Map<String, HashSet<String>> calculateFirst() {
        Map<String, HashSet<String>> ret = new HashMap<>();

        for (String term : listener.getTerminals().keySet()) {
            ret.put(term, new HashSet<>(Collections.singletonList(term)));
        }

        boolean changed;
        for (Map.Entry<String, Rule> ignored : listener.getNonTerminals().entrySet()) {
            do {
                changed = false;
                for (Map.Entry<String, Rule> entry : listener.getNonTerminals().entrySet()) {
                    final String name = entry.getKey();
                    final Rule rule = entry.getValue();
                    final List<Production> productions = rule.getProductions();

                    HashSet<String> values = new HashSet<>();
                    for (Production production : productions) {
                        final List<Rule> productionRules = production.getRules();
                        int i = 0;
                        while (i < productionRules.size() && isEpsRule(productionRules.get(i))) {
                            if (ret.get(productionRules.get(i).getName()) != null)
                                values.addAll(ret.get(productionRules.get(i).getName()));
                            i++;
                        }
                        if (i < productionRules.size()) {
                            if (ret.get(productionRules.get(i).getName()) != null)
                                values.addAll(ret.get(productionRules.get(i).getName()));
                        } else
                            values.add(EPS);
                    }

                    if (!ret.containsKey(name)) {
                        ret.put(name, values);
                        changed = true;
                    } else
                        changed = ret.get(name).addAll(values);
                }
            } while (changed);
        }

        return ret;
    }


    private Map<String, HashSet<String>> calculateFollow() {
        Map<String, HashSet<String>> ret = new HashMap<>();

        ret.put(listener.getStartRule(), new HashSet<>(Collections.singletonList(EOF)));

        boolean changed;
        do {
            changed = false;
            for (Map.Entry<String, Rule> entry : listener.getNonTerminals().entrySet()) {
                final String name = entry.getKey();
                final Rule rule = entry.getValue();
                final List<Production> productions = rule.getProductions();

                for (Production production : productions) {
                    final List<Rule> productionRules = production.getRules();
                    if (productionRules.size() > 1) {
                        for (int i = productionRules.size() - 2; i >= 0; i--) {
                            if (productionRules.get(i).isTerminal()) {
                                continue;
                            }
                            if (first.get(productionRules.get(i + 1).getName()) != null) {
                                HashSet<String> values = new HashSet<>(first.get(
                                        productionRules.get(i + 1).getName()));
                                values.remove(EPS);
                                changed = addTerms(ret, productionRules.get(i).getName(),
                                        values) || changed;
                            }
                        }
                    }

                    int i = productionRules.size() - 1;
                    while (i > 0 && !productionRules.get(i).isTerminal()) {
                        if (ret.get(name) != null)
                            changed = addTerms(ret, productionRules.get(i).getName(), ret.get
                                    (name)) || changed;
                        if (first.get(productionRules.get(i).getName()) == null ||
                                !first.get(productionRules.get(i).getName()).contains(EPS))
                            break;
                        i--;
                    }
                }
            }
        } while (changed);

        return ret;
    }

    private boolean addTerms(final Map<String, HashSet<String>> m, final String name, final
    HashSet<String> values) {
        if (!m.containsKey(name)) {
            m.put(name, values);
            return true;
        }
        return m.get(name).addAll(values);
    }

    private boolean isEpsRule(final Rule rule) {
        if (EPS.endsWith(rule.getName()))
            return true;

        final List<Production> productions = rule.getProductions();
        for (Production production : productions) {
            boolean isEps = true;
            final List<Rule> productionRules = production.getRules();
            for (Rule productRule : productionRules) {
                if (!isEpsRule(productRule)) {
                    isEps = false;
                    break;
                }
            }
            if (isEps)
                return true;
        }

        return false;
    }
}
