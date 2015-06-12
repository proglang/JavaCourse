package lecture20150615.visitor;

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
	public <T> T accept(IExprVisitor<T> v) {
		return v.visitProduct(this); 
	}

}
