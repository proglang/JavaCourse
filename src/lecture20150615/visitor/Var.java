package lecture20150615.visitor;

/**
 * A variable is an arithmetic expression. It has a name.
 * @author fennell
 *
 */
public class Var implements IExpr {
	
	public final String name;
	
	public Var(String name) {
		super();
		this.name = name;
	}

	@Override
	public <T> T accept(IExprVisitor<T> v) {
		return v.visitVar(this);
	}

}
