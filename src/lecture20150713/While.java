package lecture20150713;

import lecture20150615.visitor.IExpr;

/**
 * Object of this class represent while statements of the form
 * "while" "(" <exp> ")" <stmt>
 * 
 * @author thiemann
 *
 */
public class While implements IStmt {
	public final IExpr condition;
	public final IStmt body;
	public While(IExpr condition, IStmt body) {
		this.condition = condition;
		this.body = body;
	}
	@Override
	public void accept(StmtVisitor v) {
		v.visitWhile(this);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result
				+ ((condition == null) ? 0 : condition.hashCode());
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
		While other = (While) obj;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (condition == null) {
			if (other.condition != null)
				return false;
		} else if (!condition.equals(other.condition))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "While [condition=" + condition + ", body=" + body + "]";
	}
	
}
