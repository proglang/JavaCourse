package lecture20150615.visitor;

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
	public <T> T accept(IExprVisitor<T> v) {
		return v.visitAdd(this);
	}

	
	
}
