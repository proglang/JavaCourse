package lecture20150615.visitor;

/**
 * An integer constant is an arithmetic expression.
 */
public class Const implements IExpr {
	public final int value;
	
	public Const(int v) {
		this.value = v;
	}

	@Override
	public <T> T accept(IExprVisitor<T> v) {
		return v.visitConst(this);
	}

	@Override
	public String toString() {
		return value + "";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
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
		Const other = (Const) obj;
		if (value != other.value)
			return false;
		return true;
	}

	
	

}
