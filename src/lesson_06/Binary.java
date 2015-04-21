package lesson_06;

public class Binary implements IExpr {
	private Binop binop;
	private IExpr left;
	private IExpr right;
	public Binary(Binop binop, IExpr left, IExpr right) {
		this.binop = binop;
		this.left = left;
		this.right = right;
	}
	@Override
	public int valueOf() {
		int vleft = left.valueOf();
		int vright = right.valueOf();
		switch (binop) {
		case PLUS:
			return vleft + vright;
		case MINUS:
			return vleft - vright;
		case TIMES:
			return vleft * vright;
		case DIV:
			return vleft / vright;
		default:
			throw new IllegalStateException("unknown binary operator");
		}
	}
	
	@Override
	public <R> R accept(ExprVisitor<R> v) {
		return v.visitBinary(binop, left, right);
	}
	
	@Override
	public String toString() {
		return "(" + left.toString() + " " + binop.toString() + " " + right.toString() + ")";
	}
	
}
