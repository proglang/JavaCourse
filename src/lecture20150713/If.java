package lecture20150713;

import lecture20150615.visitor.IExpr;

/**
 * Objects of this class represent a conditional statement (if statement) of the form
 * "if" "(" <exp> ")" <true_stmt> "else" <false_stmt>
 *  
 * @author thiemann
 *
 */
public class If implements IStmt {
	public final IExpr condition;
	public final IStmt trueBranch;
	public final IStmt falseBranch;
	public If(IExpr condition, IStmt trueBranch, IStmt falseBranch) {
		this.condition = condition;
		this.trueBranch = trueBranch;
		this.falseBranch = falseBranch;
	}
	@Override
	public void accept(StmtVisitor v) {
		v.visitIf(this);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((condition == null) ? 0 : condition.hashCode());
		result = prime * result
				+ ((falseBranch == null) ? 0 : falseBranch.hashCode());
		result = prime * result
				+ ((trueBranch == null) ? 0 : trueBranch.hashCode());
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
		If other = (If) obj;
		if (condition == null) {
			if (other.condition != null)
				return false;
		} else if (!condition.equals(other.condition))
			return false;
		if (falseBranch == null) {
			if (other.falseBranch != null)
				return false;
		} else if (!falseBranch.equals(other.falseBranch))
			return false;
		if (trueBranch == null) {
			if (other.trueBranch != null)
				return false;
		} else if (!trueBranch.equals(other.trueBranch))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "If [condition=" + condition + ", trueBranch=" + trueBranch
				+ ", falseBranch=" + falseBranch + "]";
	}
}
