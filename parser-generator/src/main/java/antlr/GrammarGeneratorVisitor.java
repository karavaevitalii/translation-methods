// Generated from /home/vitalii/translation-methods/parser-generator/src/main/java/antlr/GrammarGenerator.g4 by ANTLR 4.7
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarGeneratorParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarGeneratorVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarGeneratorParser#gram}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGram(GrammarGeneratorParser.GramContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarGeneratorParser#startRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartRule(GrammarGeneratorParser.StartRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarGeneratorParser#pckg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPckg(GrammarGeneratorParser.PckgContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarGeneratorParser#imports}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImports(GrammarGeneratorParser.ImportsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarGeneratorParser#members}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMembers(GrammarGeneratorParser.MembersContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nonTermRule}
	 * labeled alternative in {@link GrammarGeneratorParser#gramRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonTermRule(GrammarGeneratorParser.NonTermRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code termRule}
	 * labeled alternative in {@link GrammarGeneratorParser#gramRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermRule(GrammarGeneratorParser.TermRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarGeneratorParser#localAttrs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalAttrs(GrammarGeneratorParser.LocalAttrsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarGeneratorParser#returnedAttr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnedAttr(GrammarGeneratorParser.ReturnedAttrContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarGeneratorParser#nonTerminalProduction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonTerminalProduction(GrammarGeneratorParser.NonTerminalProductionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarGeneratorParser#nonTermVariations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonTermVariations(GrammarGeneratorParser.NonTermVariationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarGeneratorParser#terminalProduction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerminalProduction(GrammarGeneratorParser.TerminalProductionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarGeneratorParser#attr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttr(GrammarGeneratorParser.AttrContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarGeneratorParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(GrammarGeneratorParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarGeneratorParser#attrType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrType(GrammarGeneratorParser.AttrTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarGeneratorParser#attrName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrName(GrammarGeneratorParser.AttrNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarGeneratorParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(GrammarGeneratorParser.IdentifierContext ctx);
}