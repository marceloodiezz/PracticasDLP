// Generated from /Users/marcelo/Desktop/PracticasDLP/lab_03/AST/src/parser/TSmm.g4 by ANTLR 4.13.2
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class TSmmLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WHITE=1, COMMENTS=2, REAL_CONSTANT=3, INT_CONSTANT=4, CHAR_CONSTANT=5, 
		ID=6;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"DIGIT", "LETTER", "BASE", "EXP", "ESCAPED_CHAR", "WHITE", "COMMENTS", 
			"REAL_CONSTANT", "INT_CONSTANT", "CHAR_CONSTANT", "ID"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WHITE", "COMMENTS", "REAL_CONSTANT", "INT_CONSTANT", "CHAR_CONSTANT", 
			"ID"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public TSmmLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TSmm.g4"; }

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
		"\u0004\u0000\u0006\u0093\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0005\u0002\u001d"+
		"\b\u0002\n\u0002\f\u0002 \t\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"$\b\u0002\n\u0002\f\u0002\'\t\u0002\u0001\u0003\u0001\u0003\u0003\u0003"+
		"+\b\u0003\u0001\u0003\u0004\u0003.\b\u0003\u000b\u0003\f\u0003/\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0004\u00045\b\u0004\u000b\u0004\f\u0004"+
		"6\u0003\u00049\b\u0004\u0001\u0005\u0004\u0005<\b\u0005\u000b\u0005\f"+
		"\u0005=\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0005\u0006F\b\u0006\n\u0006\f\u0006I\t\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0005\u0006O\b\u0006\n\u0006\f\u0006R\t"+
		"\u0006\u0001\u0006\u0001\u0006\u0003\u0006V\b\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0005\u0007[\b\u0007\n\u0007\f\u0007^\t\u0007\u0001"+
		"\u0007\u0001\u0007\u0005\u0007b\b\u0007\n\u0007\f\u0007e\t\u0007\u0001"+
		"\u0007\u0003\u0007h\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007m\b\u0007\u0001\b\u0001\b\u0005\bq\b\b\n\b\f\bt\t\b\u0001\b\u0003"+
		"\bw\b\b\u0001\t\u0001\t\u0001\t\u0003\t|\b\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0005\n\u0084\b\n\n\n\f\n\u0087\t\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0005\n\u008d\b\n\n\n\f\n\u0090\t\n\u0003\n\u0092\b\n"+
		"\u0001P\u0000\u000b\u0001\u0000\u0003\u0000\u0005\u0000\u0007\u0000\t"+
		"\u0000\u000b\u0001\r\u0002\u000f\u0003\u0011\u0004\u0013\u0005\u0015\u0006"+
		"\u0001\u0000\t\u0001\u000009\u0002\u0000AZaz\u0002\u0000EEee\u0002\u0000"+
		"++--\u0002\u0000nntt\u0003\u0000\t\n\r\r  \u0002\u0000\n\n\r\r\u0001\u0000"+
		"19\u0004\u0000\n\n\r\r\'\'\\\\\u00a5\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000"+
		"\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000"+
		"\u0015\u0001\u0000\u0000\u0000\u0001\u0017\u0001\u0000\u0000\u0000\u0003"+
		"\u0019\u0001\u0000\u0000\u0000\u0005\u001e\u0001\u0000\u0000\u0000\u0007"+
		"(\u0001\u0000\u0000\u0000\t1\u0001\u0000\u0000\u0000\u000b;\u0001\u0000"+
		"\u0000\u0000\rU\u0001\u0000\u0000\u0000\u000fl\u0001\u0000\u0000\u0000"+
		"\u0011v\u0001\u0000\u0000\u0000\u0013x\u0001\u0000\u0000\u0000\u0015\u0091"+
		"\u0001\u0000\u0000\u0000\u0017\u0018\u0007\u0000\u0000\u0000\u0018\u0002"+
		"\u0001\u0000\u0000\u0000\u0019\u001a\u0007\u0001\u0000\u0000\u001a\u0004"+
		"\u0001\u0000\u0000\u0000\u001b\u001d\u0003\u0011\b\u0000\u001c\u001b\u0001"+
		"\u0000\u0000\u0000\u001d \u0001\u0000\u0000\u0000\u001e\u001c\u0001\u0000"+
		"\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f!\u0001\u0000\u0000"+
		"\u0000 \u001e\u0001\u0000\u0000\u0000!%\u0005.\u0000\u0000\"$\u0003\u0001"+
		"\u0000\u0000#\"\u0001\u0000\u0000\u0000$\'\u0001\u0000\u0000\u0000%#\u0001"+
		"\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&\u0006\u0001\u0000\u0000"+
		"\u0000\'%\u0001\u0000\u0000\u0000(*\u0007\u0002\u0000\u0000)+\u0007\u0003"+
		"\u0000\u0000*)\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000+-\u0001"+
		"\u0000\u0000\u0000,.\u0003\u0001\u0000\u0000-,\u0001\u0000\u0000\u0000"+
		"./\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000"+
		"\u00000\b\u0001\u0000\u0000\u000018\u0005\\\u0000\u000029\u0007\u0004"+
		"\u0000\u000035\u0007\u0000\u0000\u000043\u0001\u0000\u0000\u000056\u0001"+
		"\u0000\u0000\u000064\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u0000"+
		"79\u0001\u0000\u0000\u000082\u0001\u0000\u0000\u000084\u0001\u0000\u0000"+
		"\u00009\n\u0001\u0000\u0000\u0000:<\u0007\u0005\u0000\u0000;:\u0001\u0000"+
		"\u0000\u0000<=\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000=>\u0001"+
		"\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?@\u0006\u0005\u0000\u0000"+
		"@\f\u0001\u0000\u0000\u0000AB\u0005/\u0000\u0000BC\u0005/\u0000\u0000"+
		"CG\u0001\u0000\u0000\u0000DF\b\u0006\u0000\u0000ED\u0001\u0000\u0000\u0000"+
		"FI\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000"+
		"\u0000HV\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000JK\u0005/\u0000"+
		"\u0000KL\u0005*\u0000\u0000LP\u0001\u0000\u0000\u0000MO\t\u0000\u0000"+
		"\u0000NM\u0001\u0000\u0000\u0000OR\u0001\u0000\u0000\u0000PQ\u0001\u0000"+
		"\u0000\u0000PN\u0001\u0000\u0000\u0000QS\u0001\u0000\u0000\u0000RP\u0001"+
		"\u0000\u0000\u0000ST\u0005*\u0000\u0000TV\u0005/\u0000\u0000UA\u0001\u0000"+
		"\u0000\u0000UJ\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WX\u0006"+
		"\u0006\u0000\u0000X\u000e\u0001\u0000\u0000\u0000Y[\u0003\u0011\b\u0000"+
		"ZY\u0001\u0000\u0000\u0000[^\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000"+
		"\u0000\\]\u0001\u0000\u0000\u0000]_\u0001\u0000\u0000\u0000^\\\u0001\u0000"+
		"\u0000\u0000_c\u0005.\u0000\u0000`b\u0003\u0001\u0000\u0000a`\u0001\u0000"+
		"\u0000\u0000be\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000cd\u0001"+
		"\u0000\u0000\u0000dg\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000"+
		"fh\u0003\u0007\u0003\u0000gf\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000"+
		"\u0000hm\u0001\u0000\u0000\u0000ij\u0003\u0011\b\u0000jk\u0003\u0007\u0003"+
		"\u0000km\u0001\u0000\u0000\u0000l\\\u0001\u0000\u0000\u0000li\u0001\u0000"+
		"\u0000\u0000m\u0010\u0001\u0000\u0000\u0000nr\u0007\u0007\u0000\u0000"+
		"oq\u0003\u0001\u0000\u0000po\u0001\u0000\u0000\u0000qt\u0001\u0000\u0000"+
		"\u0000rp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000sw\u0001\u0000"+
		"\u0000\u0000tr\u0001\u0000\u0000\u0000uw\u00050\u0000\u0000vn\u0001\u0000"+
		"\u0000\u0000vu\u0001\u0000\u0000\u0000w\u0012\u0001\u0000\u0000\u0000"+
		"x{\u0005\'\u0000\u0000y|\u0003\t\u0004\u0000z|\b\b\u0000\u0000{y\u0001"+
		"\u0000\u0000\u0000{z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000"+
		"}~\u0005\'\u0000\u0000~\u0014\u0001\u0000\u0000\u0000\u007f\u0085\u0003"+
		"\u0003\u0001\u0000\u0080\u0084\u0003\u0003\u0001\u0000\u0081\u0084\u0003"+
		"\u0001\u0000\u0000\u0082\u0084\u0005_\u0000\u0000\u0083\u0080\u0001\u0000"+
		"\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0083\u0082\u0001\u0000"+
		"\u0000\u0000\u0084\u0087\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000"+
		"\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0092\u0001\u0000"+
		"\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0088\u008e\u0005_\u0000"+
		"\u0000\u0089\u008d\u0003\u0003\u0001\u0000\u008a\u008d\u0003\u0001\u0000"+
		"\u0000\u008b\u008d\u0005_\u0000\u0000\u008c\u0089\u0001\u0000\u0000\u0000"+
		"\u008c\u008a\u0001\u0000\u0000\u0000\u008c\u008b\u0001\u0000\u0000\u0000"+
		"\u008d\u0090\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000"+
		"\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u0092\u0001\u0000\u0000\u0000"+
		"\u0090\u008e\u0001\u0000\u0000\u0000\u0091\u007f\u0001\u0000\u0000\u0000"+
		"\u0091\u0088\u0001\u0000\u0000\u0000\u0092\u0016\u0001\u0000\u0000\u0000"+
		"\u0017\u0000\u001e%*/68=GPU\\cglrv{\u0083\u0085\u008c\u008e\u0091\u0001"+
		"\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}