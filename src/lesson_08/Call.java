package lesson_08;

import java.util.List;

import lecture20150615.visitor.IExpr;
import lecture20150713.IStmt;
import lecture20150713.StmtVisitor;

public class Call implements IStmt {
	public final String name;
	public final List<IExpr> args;

	public Call (String name, List<IExpr> exprs) {
		this.name = name;
		this.args = exprs;
	}

	@Override
	public void accept(StmtVisitor v) {
		// unsafe
		((ExtStmtVisitor)v).visitCall(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((args == null) ? 0 : args.hashCode());
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
		Call other = (Call) obj;
		if (args == null) {
			if (other.args != null)
				return false;
		} else if (!args.equals(other.args))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Call [name=" + name + ", args=" + args + "]";
	}

}
