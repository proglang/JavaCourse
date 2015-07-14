package lecture20150713;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lecture20150615.visitor.IExpr;
import lecture20150622.IScanner;

public class Parser {
	private static final String REGEX_SEMICOLON = ";";
	private static final String REGEX_CLOSE_BRACE = "\\}";
	private static final String REGEX_EQUALS = "=";
	private static final String REGEX_CLOSE_PAREN = "\\)";
	private static final String REGEX_OPEN_PAREN = "\\(";
	private static final String REGEX_OPEN_BRACE = "\\{";
	private static final String REGEX_WORD = "[A-Za-z]+";
	private IScanner scan;

	public Parser(IScanner scan) {
		this.scan = scan;
	}
	
	public IStmt parseStmt() {
		String lexeme = scan.getLexeme(REGEX_WORD);
		if ("if".equals(lexeme)) {
			// if statement
			// "if" "(" <expr> ")" <stmt> "else" <stmt>
			if (scan.getLexeme(REGEX_OPEN_PAREN) != null) {
				IExpr condition = new lecture20150622.Parser(scan).parseExpr();
				if (scan.getLexeme(REGEX_CLOSE_PAREN) != null) {
					IStmt trueBranch = parseStmt();
					if (scan.getLexeme("else") != null) {
						IStmt falseBranch = parseStmt();
						return new If(condition, trueBranch, falseBranch);
					}
				}
			}
		}
		else if ("while".equals(lexeme)) {
			// while statement
			// "while" "(" <expr> ")" <stmt>
			if (scan.getLexeme(REGEX_OPEN_PAREN) != null) {
				IExpr condition = new lecture20150622.Parser(scan).parseExpr();
				if (scan.getLexeme(REGEX_CLOSE_PAREN) != null) {
					IStmt body = parseStmt();
					return new While(condition, body);
				}
			}
		}
		else if (lexeme != null) {
			// assignment
			// <var> "=" <expr>
			if (scan.getLexeme(REGEX_EQUALS) != null) {
				IExpr exp = new lecture20150622.Parser(scan).parseExpr();
				return new Assign(lexeme, exp);
			}
		}
		else if (scan.getLexeme(REGEX_OPEN_BRACE) != null) {
			// statement sequence
			// "{" <rest>
			// <rest> ::= "}" | stmt ";" <rest>
			List<IStmt> stmts = new ArrayList<IStmt>();
			while(scan.getLexeme(REGEX_CLOSE_BRACE) == null) {
				stmts.add(parseStmt());
				if(scan.getLexeme(REGEX_SEMICOLON) == null) {
					throw new IllegalArgumentException("cannot parse statment sequence");
				}
			}
			return new Sequence(stmts);
		}
		throw new IllegalArgumentException("cannot parse statement");
	}
}
