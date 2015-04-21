package lesson_06;

public interface ExprVisitor<R> {
	public R visitVar(String name);
	public R visitUnary(Unop u, IExpr e);
	public R visitConst(int c);
	public R visitBinary(Binop b, IExpr left, IExpr right);
}
