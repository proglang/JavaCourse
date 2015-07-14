package lecture20150713;

import java.util.Collection;

/**
 * Objects of this class sequences of statements that must be executed in order
 * "{" "}"
 * "{" <stmt> ";" <stmt> ";" ... "}"
 * 
 * @author thiemann
 *
 */
public class Sequence implements IStmt {
	public final Collection<IStmt> stmts;
	public Sequence(Collection<IStmt> stmts) {
		this.stmts = stmts;
	}
	@Override
	public void accept(StmtVisitor v) {
		v.visitSequence(this);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stmts == null) ? 0 : stmts.hashCode());
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
		Sequence other = (Sequence) obj;
		if (stmts == null) {
			if (other.stmts != null)
				return false;
		} else if (!stmts.equals(other.stmts))
			return false;
		return true;
	}

}
