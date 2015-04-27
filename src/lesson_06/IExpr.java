package lesson_06;

public interface IExpr {
	public <R> R accept(IExprVisitor<R> v);

	public int valueOf();
	
	default boolean isConst(int value) {
		return false;
	};
}
