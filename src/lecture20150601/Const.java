package lecture20150601;

public class Const implements IExpr {
	private final int v;
	

	public Const(int v) {
		this.v = v;
	}

	@Override
	public int value() {
		return this.v;
	}

	@Override
	public int size() {
		return 1;
	}

}
