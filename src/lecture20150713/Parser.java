package lecture20150713;

import java.util.ArrayList;
import java.util.List;

import lecture20150615.visitor.IExpr;
import lecture20150622.IScanner;

public class Parser extends lecture20150622.Parser {
	protected static final String REGEX_SEMICOLON = ";";
	private static final String REGEX_CLOSE_BRACE = "\\}";
	private static final String REGEX_EQUALS = "=";
	protected static final String REGEX_CLOSE_PAREN = "\\)";
	protected static final String REGEX_OPEN_PAREN = "\\(";
	private static final String REGEX_OPEN_BRACE = "\\{";
	protected static final String REGEX_WORD = "[A-Za-z]+";

	public Parser(IScanner scan) {
		super(scan);
	}
	
	public IStmt parseStmt() {
		String lexeme = getLexeme(REGEX_WORD);
		if ("if".equals(lexeme)) {
			// if statement
			// "if" "(" <expr> ")" <stmt> "else" <stmt>
			if (getLexeme(REGEX_OPEN_PAREN) != null) {
				IExpr condition = parseExpr();
				if (getLexeme(REGEX_CLOSE_PAREN) != null) {
					IStmt trueBranch = parseStmt();
					if (getLexeme("else") != null) {
						IStmt falseBranch = parseStmt();
						return new If(condition, trueBranch, falseBranch);
					}
				}
			}
		}
		else if ("while".equals(lexeme)) {
			// while statement
			// "while" "(" <expr> ")" <stmt>
			if (getLexeme(REGEX_OPEN_PAREN) != null) {
				IExpr condition = parseExpr();
				if (getLexeme(REGEX_CLOSE_PAREN) != null) {
					IStmt body = parseStmt();
					return new While(condition, body);
				}
			}
		}
		else if (lexeme != null) {
			// assignment
			// <var> "=" <expr>
			if (getLexeme(REGEX_EQUALS) != null) {
				IExpr exp = parseExpr();
				return new Assign(lexeme, exp);
			}
		}
		else if (getLexeme(REGEX_OPEN_BRACE) != null) {
			// statement sequence
			// "{" <rest>
			// <rest> ::= "}" | stmt ";" <rest>
			List<IStmt> stmts = new ArrayList<IStmt>();
			while(getLexeme(REGEX_CLOSE_BRACE) == null) {
				stmts.add(parseStmt());
				if(getLexeme(REGEX_SEMICOLON) == null) {
					throw new IllegalArgumentException("cannot parse statment sequence");
				}
			}
			return new Sequence(stmts);
		}
		throw new IllegalArgumentException("cannot parse statement");
	}
}
