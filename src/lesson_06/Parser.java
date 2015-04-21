package lesson_06;


public class Parser extends ParserBase {
	public Parser(String inp) {
		super(inp);
	}
	public Const parseConst() {
		String source = nextToken("\\d+");
		if (source != null) {
			return new Const(Integer.parseInt(source));
		}
		return null;
	}
	public Var parseVar() {
		String source = nextToken("\\w+");
		if (source != null) {
			return new Var(source);
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
				left = new Binary(op, left, right);
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
				left = new Binary(op, left, right);
			} else {
				return null;
			}
		}
		return left;
	}
}
