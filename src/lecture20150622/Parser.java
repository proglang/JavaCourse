package lecture20150622;

import lecture20150615.visitor.IExpr;
import static lecture20150615.visitor.Expressions.*;

public class Parser {
	private static final String REGEX_STAR = "\\*";
	private static final String REGEX_PLUS = "\\+";
	private static final String REGEXP_CLOSE_PAREN = "\\)";
	private static final String REGEXP_OPEN_PAREN = "\\(";
	private static final String REGEXP_DIGITS = "\\d+";
	private static final String REGEXP_WORD = "[A-Za-z]+";

	private IScanner scan;

	public Parser(IScanner scan) {
		this.scan = scan;
	}
	
	protected boolean lookingAt(String regex) {
		return scan.lookingAt(regex);
	}
	protected String getLexeme(String regex) {
		return scan.getLexeme(regex);
	}
	
	// <Factor> ::= <VAR> | <NUM> | ( <Expr> )
	public IExpr parseFactor() {
		// ... <VAR>
		String lexeme;
		lexeme = getLexeme(REGEXP_WORD);
		if (lexeme != null) {
			return var(lexeme);
		}
		// ... <NUM>
		lexeme = getLexeme(REGEXP_DIGITS);
		if (lexeme != null) {
			return cnst(new Integer(lexeme));
		}
		// ... ( <Expr> )
		lexeme = getLexeme(REGEXP_OPEN_PAREN);
		if (lexeme != null) {
			// ... <Expr> )
			IExpr e = parseExpr();
			lexeme = getLexeme(REGEXP_CLOSE_PAREN);
			if (lexeme != null) {
				return e;
			}
		}
		throw new IllegalArgumentException("cannot parse expression");
	}

	public IExpr parseExpr() {
		// <Expr> ::= <Term> <Expr1>
		IExpr e = parseTerm();
		return parseExpr1(e);
	}

	public IExpr parseExpr1(IExpr left) {
		// <Expr1> ::= eps | + <Term> <Expr1>
		String lexeme = getLexeme(REGEX_PLUS);
		if (lexeme != null) {
			IExpr right = parseTerm();
			IExpr e = add(left, right);
			return parseExpr1(e);
		}
		// eps
		return left;
	}

	public IExpr parseTerm() {
		// <Term> ::= <Factor> <Term1>
		IExpr e = parseFactor();
		return parseTerm1(e);
	}

	public IExpr parseTerm1(IExpr left) {
		// <Term1> ::= eps | * <Factor> <Term1>
		String lexeme = getLexeme(REGEX_STAR);
		if (lexeme != null) {
			IExpr right = parseFactor();
			IExpr e = product(left, right);
			return parseTerm1(e);
		}
		// eps
		return left;
	}

}
