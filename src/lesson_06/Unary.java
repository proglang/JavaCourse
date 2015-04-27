package lesson_06;

public class Unary implements IExpr {
	private Unop unop;
	private IExpr expr;
	public Unary(Unop unop, IExpr expr) {
		this.unop = unop;
		this.expr = expr;
	}
	@Override
	public int valueOf() {
		int vexpr = expr.valueOf();
		switch (unop) {
		case UMINUS:
			return -vexpr;
		default:
			throw new IllegalStateException();
		}
	}
	@Override
	public <R> R accept(IExprVisitor<R> v) {
		return v.visitUnary(unop, expr);
	}
	@Override
	public String toString() {
		return "(" + unop.toString() + " " + expr.toString() + ")";
	}
	
}
