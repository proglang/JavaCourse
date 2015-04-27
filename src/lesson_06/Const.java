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
	public <R> R accept(IExprVisitor<R> v) {
		return v.visitConst(value);
	}

	@Override
	public String toString() {
		return "" + value;
	}

	@Override
	public boolean isConst(int value) {
		return value == this.value;
	}
}
