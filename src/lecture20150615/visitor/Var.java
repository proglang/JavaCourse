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

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Var other = (Var) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
