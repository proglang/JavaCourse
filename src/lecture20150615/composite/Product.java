package lecture20150615.composite;

/**
 * The product of two arithmetic expressions ("left * right") is an arithmetic
 * expression.
 * 
 * @author fennell
 *
 */
public class Product implements IExpr {
	public final IExpr left, right;

	public Product(IExpr left, IExpr right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public int eval() {
		return left.eval() * right.eval();
	}

	@Override
	public int size() {
		return 1 + left.size() + right.size();
	}


}
