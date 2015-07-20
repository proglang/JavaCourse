package lesson_08;

import java.util.List;

import lecture20150713.IStmt;

public class FunDecl implements IDecl {
	public final String name;
	public final List<String> vars;
	public final IStmt body;

	public FunDecl(String name, List<String> vars, IStmt body) {
		this.name = name;
		this.vars = vars;
		this.body = body;
	}

	@Override
	public void accept(IDeclVisitor v) {
		v.visitFunDecl(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		FunDecl other = (FunDecl) obj;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (vars == null) {
			if (other.vars != null)
				return false;
		} else if (!vars.equals(other.vars))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FunDecl [name=" + name + ", vars=" + vars + ", body=" + body
				+ "]";
	}

}
