package lesson_08;

import java.util.List;

public class VarDecl implements IDecl {
	public final List<String> vars;

	public VarDecl(List<String> vars) {
		this.vars = vars;
	}

	@Override
	public void accept(IDeclVisitor v) {
		v.visitVarDecl(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vars == null) ? 0 : vars.hashCode());
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
		VarDecl other = (VarDecl) obj;
		if (vars == null) {
			if (other.vars != null)
				return false;
		} else if (!vars.equals(other.vars))
			return false;
		return true;
	}

}
