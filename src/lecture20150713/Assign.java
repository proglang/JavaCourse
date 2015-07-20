package lecture20150713;

import lecture20150615.visitor.IExpr;

/**
 * Objects of this class stand for assignment statements of form:
 * <var> "=" <exp>
 * 
 * @author thiemann
 *
 */
public class Assign implements IStmt {
	public final String var;
	public final IExpr exp;
	public Assign(String var, IExpr exp) {
		this.var = var;
		this.exp = exp;
	}
	@Override
	public void accept(StmtVisitor v) {
		v.visitAssign(this);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exp == null) ? 0 : exp.hashCode());
		result = prime * result + ((var == null) ? 0 : var.hashCode());
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
		Assign other = (Assign) obj;
		if (exp == null) {
			if (other.exp != null)
				return false;
		} else if (!exp.equals(other.exp))
			return false;
		if (var == null) {
			if (other.var != null)
				return false;
		} else if (!var.equals(other.var))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Assign [var=" + var + ", exp=" + exp + "]";
	}
	

}
