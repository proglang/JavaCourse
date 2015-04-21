package lesson_06;

public class Const implements IExpr {
	private int value;

	public Const(int value) {
		this.value = value;
	}

	@Override
	public int valueOf() {
		return value;
	}

	@Override
	public <R> R accept(ExprVisitor<R> v) {
		return v.visitConst(value);
	}

	@Override
	public String toString() {
		return "" + value;
	}
}
