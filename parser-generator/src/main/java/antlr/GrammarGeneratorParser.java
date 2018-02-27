// Generated from /home/vitalii/translation-methods/parser-generator/src/main/java/antlr/GrammarGenerator.g4 by ANTLR 4.7
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarGeneratorParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, NON_TERM_NAME=12, TERM_NAME=13, PCKG_NAME=14, IMPORT=15, 
		STRING=16, CODE=17, WS=18;
	public static final int
		RULE_gram = 0, RULE_startRule = 1, RULE_pckg = 2, RULE_imports = 3, RULE_members = 4, 
		RULE_gramRule = 5, RULE_localAttrs = 6, RULE_returnedAttr = 7, RULE_nonTerminalProduction = 8, 
		RULE_nonTermVariations = 9, RULE_terminalProduction = 10, RULE_attr = 11, 
		RULE_args = 12, RULE_attrType = 13, RULE_attrName = 14, RULE_identifier = 15;
	public static final String[] ruleNames = {
		"gram", "startRule", "pckg", "imports", "members", "gramRule", "localAttrs", 
		"returnedAttr", "nonTerminalProduction", "nonTermVariations", "terminalProduction", 
		"attr", "args", "attrType", "attrName", "identifier"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'|>'", "'->'", "'+package'", "'+import'", "'+members'", "'('", 
		"')'", "':='", "'|'", "';'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"NON_TERM_NAME", "TERM_NAME", "PCKG_NAME", "IMPORT", "STRING", "CODE", 
		"WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "GrammarGenerator.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarGeneratorParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class GramContext extends ParserRuleContext {
		public PckgContext pckg() {
			return getRuleContext(PckgContext.class,0);
		}
		public ImportsContext imports() {
			return getRuleContext(ImportsContext.class,0);
		}
		public MembersContext members() {
			return getRuleContext(MembersContext.class,0);
		}
		public StartRuleContext startRule() {
			return getRuleContext(StartRuleContext.class,0);
		}
		public List<GramRuleContext> gramRule() {
			return getRuleContexts(GramRuleContext.class);
		}
		public GramRuleContext gramRule(int i) {
			return getRuleContext(GramRuleContext.class,i);
		}
		public GramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gram; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).enterGram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).exitGram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarGeneratorVisitor ) return ((GrammarGeneratorVisitor<? extends T>)visitor).visitGram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GramContext gram() throws RecognitionException {
		GramContext _localctx = new GramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_gram);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(32);
				pckg();
				}
			}

			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(35);
				imports();
				}
			}

			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(38);
				members();
				}
			}

			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(41);
				startRule();
				setState(43); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(42);
					gramRule();
					}
					}
					setState(45); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NON_TERM_NAME || _la==TERM_NAME );
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StartRuleContext extends ParserRuleContext {
		public TerminalNode NON_TERM_NAME() { return getToken(GrammarGeneratorParser.NON_TERM_NAME, 0); }
		public ReturnedAttrContext returnedAttr() {
			return getRuleContext(ReturnedAttrContext.class,0);
		}
		public StartRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).enterStartRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).exitStartRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarGeneratorVisitor ) return ((GrammarGeneratorVisitor<? extends T>)visitor).visitStartRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartRuleContext startRule() throws RecognitionException {
		StartRuleContext _localctx = new StartRuleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_startRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(T__0);
			setState(50);
			match(NON_TERM_NAME);
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(51);
				match(T__1);
				setState(52);
				returnedAttr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PckgContext extends ParserRuleContext {
		public TerminalNode PCKG_NAME() { return getToken(GrammarGeneratorParser.PCKG_NAME, 0); }
		public PckgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pckg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).enterPckg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).exitPckg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarGeneratorVisitor ) return ((GrammarGeneratorVisitor<? extends T>)visitor).visitPckg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PckgContext pckg() throws RecognitionException {
		PckgContext _localctx = new PckgContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_pckg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(T__2);
			setState(56);
			match(PCKG_NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportsContext extends ParserRuleContext {
		public List<TerminalNode> IMPORT() { return getTokens(GrammarGeneratorParser.IMPORT); }
		public TerminalNode IMPORT(int i) {
			return getToken(GrammarGeneratorParser.IMPORT, i);
		}
		public ImportsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imports; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).enterImports(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).exitImports(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarGeneratorVisitor ) return ((GrammarGeneratorVisitor<? extends T>)visitor).visitImports(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportsContext imports() throws RecognitionException {
		ImportsContext _localctx = new ImportsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_imports);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(58);
				match(T__3);
				setState(59);
				match(IMPORT);
				}
				}
				setState(62); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__3 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MembersContext extends ParserRuleContext {
		public TerminalNode CODE() { return getToken(GrammarGeneratorParser.CODE, 0); }
		public MembersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_members; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).enterMembers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).exitMembers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarGeneratorVisitor ) return ((GrammarGeneratorVisitor<? extends T>)visitor).visitMembers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MembersContext members() throws RecognitionException {
		MembersContext _localctx = new MembersContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_members);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(T__4);
			setState(65);
			match(CODE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GramRuleContext extends ParserRuleContext {
		public GramRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gramRule; }
	 
		public GramRuleContext() { }
		public void copyFrom(GramRuleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TermRuleContext extends GramRuleContext {
		public TerminalNode TERM_NAME() { return getToken(GrammarGeneratorParser.TERM_NAME, 0); }
		public List<TerminalProductionContext> terminalProduction() {
			return getRuleContexts(TerminalProductionContext.class);
		}
		public TerminalProductionContext terminalProduction(int i) {
			return getRuleContext(TerminalProductionContext.class,i);
		}
		public TermRuleContext(GramRuleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).enterTermRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).exitTermRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarGeneratorVisitor ) return ((GrammarGeneratorVisitor<? extends T>)visitor).visitTermRule(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NonTermRuleContext extends GramRuleContext {
		public TerminalNode NON_TERM_NAME() { return getToken(GrammarGeneratorParser.NON_TERM_NAME, 0); }
		public List<NonTerminalProductionContext> nonTerminalProduction() {
			return getRuleContexts(NonTerminalProductionContext.class);
		}
		public NonTerminalProductionContext nonTerminalProduction(int i) {
			return getRuleContext(NonTerminalProductionContext.class,i);
		}
		public LocalAttrsContext localAttrs() {
			return getRuleContext(LocalAttrsContext.class,0);
		}
		public ReturnedAttrContext returnedAttr() {
			return getRuleContext(ReturnedAttrContext.class,0);
		}
		public NonTermRuleContext(GramRuleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).enterNonTermRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).exitNonTermRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarGeneratorVisitor ) return ((GrammarGeneratorVisitor<? extends T>)visitor).visitNonTermRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GramRuleContext gramRule() throws RecognitionException {
		GramRuleContext _localctx = new GramRuleContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_gramRule);
		int _la;
		try {
			setState(100);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NON_TERM_NAME:
				_localctx = new NonTermRuleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				match(NON_TERM_NAME);
				setState(68);
				match(T__5);
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NON_TERM_NAME || _la==TERM_NAME) {
					{
					setState(69);
					localAttrs();
					}
				}

				setState(72);
				match(T__6);
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(73);
					match(T__1);
					setState(74);
					returnedAttr();
					}
				}

				setState(77);
				match(T__7);
				setState(78);
				nonTerminalProduction();
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(79);
					match(T__8);
					setState(80);
					nonTerminalProduction();
					}
					}
					setState(85);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(86);
				match(T__9);
				}
				break;
			case TERM_NAME:
				_localctx = new TermRuleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				match(TERM_NAME);
				setState(89);
				match(T__7);
				setState(90);
				terminalProduction();
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(91);
					match(T__8);
					setState(92);
					terminalProduction();
					}
					}
					setState(97);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(98);
				match(T__9);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalAttrsContext extends ParserRuleContext {
		public List<AttrContext> attr() {
			return getRuleContexts(AttrContext.class);
		}
		public AttrContext attr(int i) {
			return getRuleContext(AttrContext.class,i);
		}
		public LocalAttrsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localAttrs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).enterLocalAttrs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).exitLocalAttrs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarGeneratorVisitor ) return ((GrammarGeneratorVisitor<? extends T>)visitor).visitLocalAttrs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalAttrsContext localAttrs() throws RecognitionException {
		LocalAttrsContext _localctx = new LocalAttrsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_localAttrs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			attr();
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(103);
				match(T__10);
				setState(104);
				attr();
				}
				}
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnedAttrContext extends ParserRuleContext {
		public AttrTypeContext attrType() {
			return getRuleContext(AttrTypeContext.class,0);
		}
		public ReturnedAttrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnedAttr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).enterReturnedAttr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).exitReturnedAttr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarGeneratorVisitor ) return ((GrammarGeneratorVisitor<? extends T>)visitor).visitReturnedAttr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnedAttrContext returnedAttr() throws RecognitionException {
		ReturnedAttrContext _localctx = new ReturnedAttrContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_returnedAttr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			attrType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NonTerminalProductionContext extends ParserRuleContext {
		public List<NonTermVariationsContext> nonTermVariations() {
			return getRuleContexts(NonTermVariationsContext.class);
		}
		public NonTermVariationsContext nonTermVariations(int i) {
			return getRuleContext(NonTermVariationsContext.class,i);
		}
		public TerminalNode CODE() { return getToken(GrammarGeneratorParser.CODE, 0); }
		public NonTerminalProductionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonTerminalProduction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).enterNonTerminalProduction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).exitNonTerminalProduction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarGeneratorVisitor ) return ((GrammarGeneratorVisitor<? extends T>)visitor).visitNonTerminalProduction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonTerminalProductionContext nonTerminalProduction() throws RecognitionException {
		NonTerminalProductionContext _localctx = new NonTerminalProductionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_nonTerminalProduction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NON_TERM_NAME || _la==TERM_NAME) {
				{
				{
				setState(112);
				nonTermVariations();
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CODE) {
				{
				setState(118);
				match(CODE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NonTermVariationsContext extends ParserRuleContext {
		public TerminalNode TERM_NAME() { return getToken(GrammarGeneratorParser.TERM_NAME, 0); }
		public TerminalNode NON_TERM_NAME() { return getToken(GrammarGeneratorParser.NON_TERM_NAME, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public NonTermVariationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonTermVariations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).enterNonTermVariations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).exitNonTermVariations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarGeneratorVisitor ) return ((GrammarGeneratorVisitor<? extends T>)visitor).visitNonTermVariations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonTermVariationsContext nonTermVariations() throws RecognitionException {
		NonTermVariationsContext _localctx = new NonTermVariationsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_nonTermVariations);
		int _la;
		try {
			setState(126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TERM_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				match(TERM_NAME);
				}
				break;
			case NON_TERM_NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				match(NON_TERM_NAME);
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(123);
					args();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TerminalProductionContext extends ParserRuleContext {
		public List<TerminalNode> STRING() { return getTokens(GrammarGeneratorParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(GrammarGeneratorParser.STRING, i);
		}
		public TerminalProductionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terminalProduction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).enterTerminalProduction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).exitTerminalProduction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarGeneratorVisitor ) return ((GrammarGeneratorVisitor<? extends T>)visitor).visitTerminalProduction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TerminalProductionContext terminalProduction() throws RecognitionException {
		TerminalProductionContext _localctx = new TerminalProductionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_terminalProduction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(128);
				match(STRING);
				}
				}
				setState(131); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==STRING );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttrContext extends ParserRuleContext {
		public AttrTypeContext attrType() {
			return getRuleContext(AttrTypeContext.class,0);
		}
		public AttrNameContext attrName() {
			return getRuleContext(AttrNameContext.class,0);
		}
		public AttrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).enterAttr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).exitAttr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarGeneratorVisitor ) return ((GrammarGeneratorVisitor<? extends T>)visitor).visitAttr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrContext attr() throws RecognitionException {
		AttrContext _localctx = new AttrContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_attr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			attrType();
			setState(134);
			attrName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public List<TerminalNode> CODE() { return getTokens(GrammarGeneratorParser.CODE); }
		public TerminalNode CODE(int i) {
			return getToken(GrammarGeneratorParser.CODE, i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).exitArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarGeneratorVisitor ) return ((GrammarGeneratorVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(T__5);
			setState(137);
			match(CODE);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(138);
				match(T__10);
				setState(139);
				match(CODE);
				}
				}
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(145);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttrTypeContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AttrTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).enterAttrType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).exitAttrType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarGeneratorVisitor ) return ((GrammarGeneratorVisitor<? extends T>)visitor).visitAttrType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrTypeContext attrType() throws RecognitionException {
		AttrTypeContext _localctx = new AttrTypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_attrType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttrNameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AttrNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).enterAttrName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).exitAttrName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarGeneratorVisitor ) return ((GrammarGeneratorVisitor<? extends T>)visitor).visitAttrName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrNameContext attrName() throws RecognitionException {
		AttrNameContext _localctx = new AttrNameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_attrName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode NON_TERM_NAME() { return getToken(GrammarGeneratorParser.NON_TERM_NAME, 0); }
		public TerminalNode TERM_NAME() { return getToken(GrammarGeneratorParser.TERM_NAME, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarGeneratorListener ) ((GrammarGeneratorListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarGeneratorVisitor ) return ((GrammarGeneratorVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			_la = _input.LA(1);
			if ( !(_la==NON_TERM_NAME || _la==TERM_NAME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\24\u009c\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\5\2"+
		"$\n\2\3\2\5\2\'\n\2\3\2\5\2*\n\2\3\2\3\2\6\2.\n\2\r\2\16\2/\5\2\62\n\2"+
		"\3\3\3\3\3\3\3\3\5\38\n\3\3\4\3\4\3\4\3\5\3\5\6\5?\n\5\r\5\16\5@\3\6\3"+
		"\6\3\6\3\7\3\7\3\7\5\7I\n\7\3\7\3\7\3\7\5\7N\n\7\3\7\3\7\3\7\3\7\7\7T"+
		"\n\7\f\7\16\7W\13\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7`\n\7\f\7\16\7c\13"+
		"\7\3\7\3\7\5\7g\n\7\3\b\3\b\3\b\7\bl\n\b\f\b\16\bo\13\b\3\t\3\t\3\n\7"+
		"\nt\n\n\f\n\16\nw\13\n\3\n\5\nz\n\n\3\13\3\13\3\13\5\13\177\n\13\5\13"+
		"\u0081\n\13\3\f\6\f\u0084\n\f\r\f\16\f\u0085\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\7\16\u008f\n\16\f\16\16\16\u0092\13\16\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\3\21\3\21\3\21\2\2\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2"+
		"\3\3\2\16\17\2\u009e\2#\3\2\2\2\4\63\3\2\2\2\69\3\2\2\2\b>\3\2\2\2\nB"+
		"\3\2\2\2\ff\3\2\2\2\16h\3\2\2\2\20p\3\2\2\2\22u\3\2\2\2\24\u0080\3\2\2"+
		"\2\26\u0083\3\2\2\2\30\u0087\3\2\2\2\32\u008a\3\2\2\2\34\u0095\3\2\2\2"+
		"\36\u0097\3\2\2\2 \u0099\3\2\2\2\"$\5\6\4\2#\"\3\2\2\2#$\3\2\2\2$&\3\2"+
		"\2\2%\'\5\b\5\2&%\3\2\2\2&\'\3\2\2\2\')\3\2\2\2(*\5\n\6\2)(\3\2\2\2)*"+
		"\3\2\2\2*\61\3\2\2\2+-\5\4\3\2,.\5\f\7\2-,\3\2\2\2./\3\2\2\2/-\3\2\2\2"+
		"/\60\3\2\2\2\60\62\3\2\2\2\61+\3\2\2\2\61\62\3\2\2\2\62\3\3\2\2\2\63\64"+
		"\7\3\2\2\64\67\7\16\2\2\65\66\7\4\2\2\668\5\20\t\2\67\65\3\2\2\2\678\3"+
		"\2\2\28\5\3\2\2\29:\7\5\2\2:;\7\20\2\2;\7\3\2\2\2<=\7\6\2\2=?\7\21\2\2"+
		"><\3\2\2\2?@\3\2\2\2@>\3\2\2\2@A\3\2\2\2A\t\3\2\2\2BC\7\7\2\2CD\7\23\2"+
		"\2D\13\3\2\2\2EF\7\16\2\2FH\7\b\2\2GI\5\16\b\2HG\3\2\2\2HI\3\2\2\2IJ\3"+
		"\2\2\2JM\7\t\2\2KL\7\4\2\2LN\5\20\t\2MK\3\2\2\2MN\3\2\2\2NO\3\2\2\2OP"+
		"\7\n\2\2PU\5\22\n\2QR\7\13\2\2RT\5\22\n\2SQ\3\2\2\2TW\3\2\2\2US\3\2\2"+
		"\2UV\3\2\2\2VX\3\2\2\2WU\3\2\2\2XY\7\f\2\2Yg\3\2\2\2Z[\7\17\2\2[\\\7\n"+
		"\2\2\\a\5\26\f\2]^\7\13\2\2^`\5\26\f\2_]\3\2\2\2`c\3\2\2\2a_\3\2\2\2a"+
		"b\3\2\2\2bd\3\2\2\2ca\3\2\2\2de\7\f\2\2eg\3\2\2\2fE\3\2\2\2fZ\3\2\2\2"+
		"g\r\3\2\2\2hm\5\30\r\2ij\7\r\2\2jl\5\30\r\2ki\3\2\2\2lo\3\2\2\2mk\3\2"+
		"\2\2mn\3\2\2\2n\17\3\2\2\2om\3\2\2\2pq\5\34\17\2q\21\3\2\2\2rt\5\24\13"+
		"\2sr\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2vy\3\2\2\2wu\3\2\2\2xz\7\23"+
		"\2\2yx\3\2\2\2yz\3\2\2\2z\23\3\2\2\2{\u0081\7\17\2\2|~\7\16\2\2}\177\5"+
		"\32\16\2~}\3\2\2\2~\177\3\2\2\2\177\u0081\3\2\2\2\u0080{\3\2\2\2\u0080"+
		"|\3\2\2\2\u0081\25\3\2\2\2\u0082\u0084\7\22\2\2\u0083\u0082\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\27\3\2\2"+
		"\2\u0087\u0088\5\34\17\2\u0088\u0089\5\36\20\2\u0089\31\3\2\2\2\u008a"+
		"\u008b\7\b\2\2\u008b\u0090\7\23\2\2\u008c\u008d\7\r\2\2\u008d\u008f\7"+
		"\23\2\2\u008e\u008c\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090"+
		"\u0091\3\2\2\2\u0091\u0093\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0094\7\t"+
		"\2\2\u0094\33\3\2\2\2\u0095\u0096\5 \21\2\u0096\35\3\2\2\2\u0097\u0098"+
		"\5 \21\2\u0098\37\3\2\2\2\u0099\u009a\t\2\2\2\u009a!\3\2\2\2\25#&)/\61"+
		"\67@HMUafmuy~\u0080\u0085\u0090";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}