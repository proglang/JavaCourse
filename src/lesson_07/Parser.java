package lesson_07;

import lesson_06.Binary;
import lesson_06.Binop;
import lesson_06.Const;
import lesson_06.IExpr;
import lesson_06.ParserBase;
import lesson_06.Var;

public class Parser extends ParserBase {
	private IExprFactory b;

	public Parser(String inp, IExprFactory b) {
		super(inp);
		this.b = b;
	}
	public IExpr parseConst() {
		String source = nextToken("\\d+");
		if (source != null) {
			return b.makeConst(Integer.parseInt(source));
		}
		return null;
	}
	public IExpr parseVar() {
		String source = nextToken("\\w+");
		if (source != null) {
			return b.makeVar(source);
		}
		return null;
	}
	public IExpr parseFactor() {
		IExpr r = parseConst();
		if (r==null) {
			r = parseVar();
			if (r==null) {
				r = parseParens();
			}
		}
		return r;
	}
	public IExpr parseParens() {
		String source = nextToken("\\(");
		if (source!=null) {
			IExpr r = parseExpr();
			source = nextToken("\\)");
			if (source!=null) {
				return r;
			}
		}
		return null;
	}
	public IExpr parseExpr() {
		// E ::= E + T | T
		// ==>
		// E ::= T E'
		// E' ::= e | + T E' | - T E'
		IExpr r = parseTerm();
		if (r != null) {
			r = parseExpr1(r);
		}
		return r;
	}
	public IExpr parseExpr1(IExpr r) {
		IExpr left = r;
		// System.out.println(left);
		String source = nextToken("[+-]");
		// System.out.println("source="+ source);
		while (source != null) {
			Binop op = Binop.fromToken(source);
			IExpr right = parseTerm();
			if (right != null) {
				left = b.makeBinary(op, left, right);
				// System.out.println(left);
			} else {
				return null;
			}
			source = nextToken("[+-]");
		}
		return left;
	}
	public IExpr parseTerm() {
		IExpr r = parseFactor();
		if (r != null) {
			r = parseTerm1(r);
		}
		return r;
	}
	public IExpr parseTerm1(IExpr r) {
		// System.out.println("Term1: " + s.next());
		IExpr left = r;
		for (String source = null; (source = nextToken("[*/]")) != null; ) {
			Binop op = Binop.fromToken(source);
			IExpr right = parseFactor();
			if (right != null) {
				left = b.makeBinary(op, left, right);
			} else {
				return null;
			}
		}
		return left;
	}

}
