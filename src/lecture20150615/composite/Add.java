package lecture20150615.composite;

/**
 * The addition of two arithmetic expressions ("left + right") is an arithmetic
 * expression.
 * 
 * @author fennell
 *
 */
public class Add implements IExpr {
	public final IExpr left, right;

	public Add(IExpr left, IExpr right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public int eval() {
		return this.left.eval() + this.right.eval();
	}

	@Override
	public int size() {
		return 1 + this.left.size() + this.right.size();
	}

}
