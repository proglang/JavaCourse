package lecture20150615.visitor;

/**
 * The size operation for arithmetic expression implemented as an
 * IExprVisitor<Integer>.
 * 
 * @author fennell
 *
 */
public class Size implements IExprVisitor<Integer> {

	@Override
	public Integer visitConst(Const c) {
		return 1;
	}

	@Override
	public Integer visitAdd(Add a) {
		return 1 + a.left.accept(this) + a.right.accept(this);
	}

	@Override
	public Integer visitProduct(Product p) {
		return 1 + p.left.accept(this) + p.right.accept(this);
	}

	@Override
	public Integer visitVar(Var v) {
		return 1;
	}

}
