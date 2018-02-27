// Generated from /home/vitalii/translation-methods/parser-generator/src/main/java/antlr/GrammarGenerator.g4 by ANTLR 4.7
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarGeneratorParser}.
 */
public interface GrammarGeneratorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarGeneratorParser#gram}.
	 * @param ctx the parse tree
	 */
	void enterGram(GrammarGeneratorParser.GramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGeneratorParser#gram}.
	 * @param ctx the parse tree
	 */
	void exitGram(GrammarGeneratorParser.GramContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGeneratorParser#startRule}.
	 * @param ctx the parse tree
	 */
	void enterStartRule(GrammarGeneratorParser.StartRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGeneratorParser#startRule}.
	 * @param ctx the parse tree
	 */
	void exitStartRule(GrammarGeneratorParser.StartRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGeneratorParser#pckg}.
	 * @param ctx the parse tree
	 */
	void enterPckg(GrammarGeneratorParser.PckgContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGeneratorParser#pckg}.
	 * @param ctx the parse tree
	 */
	void exitPckg(GrammarGeneratorParser.PckgContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGeneratorParser#imports}.
	 * @param ctx the parse tree
	 */
	void enterImports(GrammarGeneratorParser.ImportsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGeneratorParser#imports}.
	 * @param ctx the parse tree
	 */
	void exitImports(GrammarGeneratorParser.ImportsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGeneratorParser#members}.
	 * @param ctx the parse tree
	 */
	void enterMembers(GrammarGeneratorParser.MembersContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGeneratorParser#members}.
	 * @param ctx the parse tree
	 */
	void exitMembers(GrammarGeneratorParser.MembersContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nonTermRule}
	 * labeled alternative in {@link GrammarGeneratorParser#gramRule}.
	 * @param ctx the parse tree
	 */
	void enterNonTermRule(GrammarGeneratorParser.NonTermRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nonTermRule}
	 * labeled alternative in {@link GrammarGeneratorParser#gramRule}.
	 * @param ctx the parse tree
	 */
	void exitNonTermRule(GrammarGeneratorParser.NonTermRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code termRule}
	 * labeled alternative in {@link GrammarGeneratorParser#gramRule}.
	 * @param ctx the parse tree
	 */
	void enterTermRule(GrammarGeneratorParser.TermRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code termRule}
	 * labeled alternative in {@link GrammarGeneratorParser#gramRule}.
	 * @param ctx the parse tree
	 */
	void exitTermRule(GrammarGeneratorParser.TermRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGeneratorParser#localAttrs}.
	 * @param ctx the parse tree
	 */
	void enterLocalAttrs(GrammarGeneratorParser.LocalAttrsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGeneratorParser#localAttrs}.
	 * @param ctx the parse tree
	 */
	void exitLocalAttrs(GrammarGeneratorParser.LocalAttrsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGeneratorParser#returnedAttr}.
	 * @param ctx the parse tree
	 */
	void enterReturnedAttr(GrammarGeneratorParser.ReturnedAttrContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGeneratorParser#returnedAttr}.
	 * @param ctx the parse tree
	 */
	void exitReturnedAttr(GrammarGeneratorParser.ReturnedAttrContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGeneratorParser#nonTerminalProduction}.
	 * @param ctx the parse tree
	 */
	void enterNonTerminalProduction(GrammarGeneratorParser.NonTerminalProductionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGeneratorParser#nonTerminalProduction}.
	 * @param ctx the parse tree
	 */
	void exitNonTerminalProduction(GrammarGeneratorParser.NonTerminalProductionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGeneratorParser#nonTermVariations}.
	 * @param ctx the parse tree
	 */
	void enterNonTermVariations(GrammarGeneratorParser.NonTermVariationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGeneratorParser#nonTermVariations}.
	 * @param ctx the parse tree
	 */
	void exitNonTermVariations(GrammarGeneratorParser.NonTermVariationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGeneratorParser#terminalProduction}.
	 * @param ctx the parse tree
	 */
	void enterTerminalProduction(GrammarGeneratorParser.TerminalProductionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGeneratorParser#terminalProduction}.
	 * @param ctx the parse tree
	 */
	void exitTerminalProduction(GrammarGeneratorParser.TerminalProductionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGeneratorParser#attr}.
	 * @param ctx the parse tree
	 */
	void enterAttr(GrammarGeneratorParser.AttrContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGeneratorParser#attr}.
	 * @param ctx the parse tree
	 */
	void exitAttr(GrammarGeneratorParser.AttrContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGeneratorParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(GrammarGeneratorParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGeneratorParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(GrammarGeneratorParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGeneratorParser#attrType}.
	 * @param ctx the parse tree
	 */
	void enterAttrType(GrammarGeneratorParser.AttrTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGeneratorParser#attrType}.
	 * @param ctx the parse tree
	 */
	void exitAttrType(GrammarGeneratorParser.AttrTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGeneratorParser#attrName}.
	 * @param ctx the parse tree
	 */
	void enterAttrName(GrammarGeneratorParser.AttrNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGeneratorParser#attrName}.
	 * @param ctx the parse tree
	 */
	void exitAttrName(GrammarGeneratorParser.AttrNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarGeneratorParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(GrammarGeneratorParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarGeneratorParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(GrammarGeneratorParser.IdentifierContext ctx);
}