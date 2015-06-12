package lecture20150615.composite;

/**
 * An integer constant is an arithmetic expression.
 */
public class Const implements IExpr {
	public final int value;
	
	public Const(int v) {
		this.value = v;
	}

	@Override
	public int eval() {
		return this.value;
	}

	@Override
	public int size() {
		return 1;
	}
	
	

}
