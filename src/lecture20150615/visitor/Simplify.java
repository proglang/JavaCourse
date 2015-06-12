package lecture20150615.visitor;

/**
 * A simplification visitor (not discussed in the lecture). It simplifies
 * additions and multiplications with 0, e.g., it simplifies "(1 * 0) + 5" to
 * "5". It returns a SimplExpr where the simplified IExpr is stored in its
 * "expr" field.
 * 
 * The implementation uses some Java-features not (yet) discussed in the
 * lecture: - nested interfaces - anonymous classes
 * 
 * @author fennell
 *
 */
public class Simplify implements IExprVisitor<SimplExpr> {

	@Override
	public SimplExpr visitConst(Const c) {
		return SimplExpr.makeConstant(c);
	}

	@Override
	public SimplExpr visitAdd(Add a) {
		SimplExpr left = a.left.accept(this);
		SimplExpr right = a.right.accept(this);
		if (left.isConstant(0)) {
			return right;
		} else if (right.isConstant(0)) {
			return left;
		} else {
			return SimplExpr.makeNonConstant(new Add(left.expr, right.expr));
		}
	}

	@Override
	public SimplExpr visitProduct(Product p) {
		SimplExpr left = p.left.accept(this);
		SimplExpr right = p.right.accept(this);
		if (left.isConstant(0) || right.isConstant(0)) {
			return SimplExpr.makeConstant(new Const(0));
		} else if (left.isConstant(1)) {
			return right;
		} else if (right.isConstant(1)) {
			return left;
		} else {
			return SimplExpr.makeNonConstant(new Product(left.expr, right.expr));
		}
	}

	@Override
	public SimplExpr visitVar(Var v) {
		return SimplExpr.makeNonConstant(v);
	}

}
