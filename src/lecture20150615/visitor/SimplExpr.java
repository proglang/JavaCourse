package lecture20150615.visitor;

/**
 * A helper class for the Simplify visitor. It stores an IExpr with additional
 * information needed for simplification.
 * 
 * @author fennell
 *
 */
public class SimplExpr {

	/**
	 * Wrap a constant as a SimpleExpr
	 */
	public static SimplExpr makeConstant(Const c) {
		return new SimplExpr(c, true, c.value);
	}

	/**
	 * Wrap an expression as a SimpleExpr that is not considered to be a
	 * constant.
	 */
	public static SimplExpr makeNonConstant(IExpr e) {
		return new SimplExpr(e, false, 0/* ignored */);
	}

	public final IExpr expr;

	private final boolean constant;
	private final int constantValue;

	private SimplExpr(IExpr expr, boolean constant, int constantValue) {
		this.expr = expr;
		this.constant = constant;
		this.constantValue = constantValue;
	}

	/**
	 * Check whether the simplified expression is a constant of a particular value.
	 * @param v The value to check the constant against
	 */
	public boolean isConstant(int v) {
		return constant && constantValue == v;
	}
}
