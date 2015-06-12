package lecture20150615.visitor;

import java.util.Map;

/**
 * The evaluation of arithmetic expression implemented as an
 * IExprVisitor<Integer>. The value of variables is given by a map from variable
 * names to integers (called an "environment"). If a variable is not found in
 * the environment it is assumed to be "0".
 * 
 * @author fennell
 *
 */
public class Eval implements IExprVisitor<Integer> {

	private final Map<String, Integer> env;

	/**
	 * Initialize an evaluation visitor
	 * 
	 * @param env
	 *            The "variable environment". This is a map that maps variable
	 *            names to integers.
	 */
	public Eval(Map<String, Integer> env) {
		this.env = env;
	}

	@Override
	public Integer visitConst(Const c) {
		return c.value;
	}

	@Override
	public Integer visitAdd(Add a) {
		return a.left.accept(this) + a.right.accept(this);
	}

	@Override
	public Integer visitProduct(Product p) {
		return p.left.accept(this) * p.right.accept(this);
	}

	@Override
	public Integer visitVar(Var v) {
		Integer val = env.get(v.name);
		return val == null ? 0 : val;
	}

}
