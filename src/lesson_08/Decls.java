package lesson_08;

import java.util.Arrays;
import java.util.List;

public class Decls implements IDecl {
	public final List<IDecl> ds;

	public Decls(List<IDecl> ds) {
		this.ds = ds;
	}
	
	public Decls(IDecl... ds) {
		this.ds = Arrays.asList(ds);
	}

	@Override
	public void accept(IDeclVisitor v) {
		v.visitDecls(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ds == null) ? 0 : ds.hashCode());
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
		Decls other = (Decls) obj;
		if (ds == null) {
			if (other.ds != null)
				return false;
		} else if (!ds.equals(other.ds))
			return false;
		return true;
	}

}
