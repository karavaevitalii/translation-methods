// Generated from /home/vitalii/translation-methods/parser-generator/src/main/java/antlr/GrammarGenerator.g4 by ANTLR 4.7
package antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarGeneratorLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, NON_TERM_NAME=12, TERM_NAME=13, PCKG_NAME=14, IMPORT=15, 
		STRING=16, CODE=17, WS=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "NON_TERM_NAME", "TERM_NAME", "PCKG_NAME", "IMPORT", 
		"STRING", "CODE", "WS"
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


	public GrammarGeneratorLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GrammarGenerator.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24\u008b\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\7\r"+
		"W\n\r\f\r\16\rZ\13\r\3\16\3\16\7\16^\n\16\f\16\16\16a\13\16\3\17\6\17"+
		"d\n\17\r\17\16\17e\3\20\6\20i\n\20\r\20\16\20j\3\21\3\21\6\21o\n\21\r"+
		"\21\16\21p\3\21\3\21\3\22\3\22\6\22w\n\22\r\22\16\22x\3\22\5\22|\n\22"+
		"\7\22~\n\22\f\22\16\22\u0081\13\22\3\22\3\22\3\23\6\23\u0086\n\23\r\23"+
		"\16\23\u0087\3\23\3\23\2\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\3\2\t\3\2c|\6\2\62;C\\"+
		"aac|\3\2C\\\5\2\60\60\62;c|\3\2))\4\2}}\177\177\5\2\13\f\17\17\"\"\2\u0093"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\3\'\3\2\2\2\5*\3\2\2\2\7-\3\2\2\2\t\66\3\2\2\2\13>\3\2"+
		"\2\2\rG\3\2\2\2\17I\3\2\2\2\21K\3\2\2\2\23N\3\2\2\2\25P\3\2\2\2\27R\3"+
		"\2\2\2\31T\3\2\2\2\33[\3\2\2\2\35c\3\2\2\2\37h\3\2\2\2!l\3\2\2\2#t\3\2"+
		"\2\2%\u0085\3\2\2\2\'(\7~\2\2()\7@\2\2)\4\3\2\2\2*+\7/\2\2+,\7@\2\2,\6"+
		"\3\2\2\2-.\7-\2\2./\7r\2\2/\60\7c\2\2\60\61\7e\2\2\61\62\7m\2\2\62\63"+
		"\7c\2\2\63\64\7i\2\2\64\65\7g\2\2\65\b\3\2\2\2\66\67\7-\2\2\678\7k\2\2"+
		"89\7o\2\29:\7r\2\2:;\7q\2\2;<\7t\2\2<=\7v\2\2=\n\3\2\2\2>?\7-\2\2?@\7"+
		"o\2\2@A\7g\2\2AB\7o\2\2BC\7d\2\2CD\7g\2\2DE\7t\2\2EF\7u\2\2F\f\3\2\2\2"+
		"GH\7*\2\2H\16\3\2\2\2IJ\7+\2\2J\20\3\2\2\2KL\7<\2\2LM\7?\2\2M\22\3\2\2"+
		"\2NO\7~\2\2O\24\3\2\2\2PQ\7=\2\2Q\26\3\2\2\2RS\7.\2\2S\30\3\2\2\2TX\t"+
		"\2\2\2UW\t\3\2\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\32\3\2\2\2Z"+
		"X\3\2\2\2[_\t\4\2\2\\^\t\3\2\2]\\\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2"+
		"\2`\34\3\2\2\2a_\3\2\2\2bd\t\5\2\2cb\3\2\2\2de\3\2\2\2ec\3\2\2\2ef\3\2"+
		"\2\2f\36\3\2\2\2gi\t\5\2\2hg\3\2\2\2ij\3\2\2\2jh\3\2\2\2jk\3\2\2\2k \3"+
		"\2\2\2ln\7)\2\2mo\n\6\2\2nm\3\2\2\2op\3\2\2\2pn\3\2\2\2pq\3\2\2\2qr\3"+
		"\2\2\2rs\7)\2\2s\"\3\2\2\2t\177\7}\2\2uw\n\7\2\2vu\3\2\2\2wx\3\2\2\2x"+
		"v\3\2\2\2xy\3\2\2\2y{\3\2\2\2z|\5#\22\2{z\3\2\2\2{|\3\2\2\2|~\3\2\2\2"+
		"}v\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0082\3"+
		"\2\2\2\u0081\177\3\2\2\2\u0082\u0083\7\177\2\2\u0083$\3\2\2\2\u0084\u0086"+
		"\t\b\2\2\u0085\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0085\3\2\2\2\u0087"+
		"\u0088\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\b\23\2\2\u008a&\3\2\2\2"+
		"\16\2X_cehjpx{\177\u0087\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}