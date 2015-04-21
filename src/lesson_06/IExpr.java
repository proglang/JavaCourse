package lesson_06;

public interface IExpr {
	public <R> R accept(ExprVisitor<R> v);

	public int valueOf();
}
