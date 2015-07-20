package lesson_08;

import java.util.LinkedList;
import java.util.List;

import lecture20150615.visitor.IExpr;
import lecture20150622.IScanner;
import lecture20150713.IStmt;

public class Parser extends lecture20150713.Parser {

	public Parser(IScanner scan) {
		super(scan);
	}
	
	/*
	 * Grammar for procedures
	 * <declaration>  ::= "var" <var_list> ";"
	 *                  | <function_name> "(" <var_list> ")" <stmt> ";"
	 * <var_list>     ::= eps
	 *                  | <var> <var_list_rst>
	 * <var_list_rst> ::= eps
	 *                  | "," <var> <var_list_rst>
	 * <stmt>         ::= ... | "call" <function_name> "(" <exp_list> ")" 
	 */

	public IDecl parseDeclaration() {
		String lexeme = getLexeme(REGEX_WORD);
		if ("var".equals(lexeme)) {
			List<String> vars = parseVarList();
			return new VarDecl(vars);
		} else if (lexeme != null) {
			String name = lexeme;
			if (getLexeme(REGEX_OPEN_PAREN) != null) {
				List<String> vars = parseVarList();
				if (getLexeme(REGEX_CLOSE_PAREN) != null) {
					IStmt body = parseStmt();
					return new FunDecl(name, vars, body);
				}
			}
		}
		throw new IllegalArgumentException("Cannot parse toplevel");
	}

	public List<String> parseVarList() {
		List<String> result = new LinkedList<String> ();
		String var = getLexeme(REGEX_WORD);
		while (var != null) {
			result.add(var);
			if (getLexeme(",") == null) {
				break;
			}
			var = getLexeme(REGEX_WORD);
		}
		return result;
	}
	
	public IStmt parseStmt() {
		if (getLexeme("call") != null) {
			String name = getLexeme(REGEX_WORD);
			if (name != null) {
				if (getLexeme(REGEX_OPEN_PAREN) != null) {
					List<IExpr> exprs = parseExprList();
					if (getLexeme(REGEX_CLOSE_PAREN) != null) {
						return new Call(name, exprs);
					}
				}
			}
		} else {
			return super.parseStmt();
		}
		throw new IllegalArgumentException("cannot parse call statement");
	}

	private List<IExpr> parseExprList() {
		List<IExpr> result = new LinkedList<IExpr>();
		while (!lookingAt(REGEX_CLOSE_PAREN)) {
			IExpr expr = parseExpr();
			result.add(expr);
			if (getLexeme(",") == null) {
				break;
			}			
		}
		return result;
	}
}
