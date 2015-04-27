package lesson_06;

public class Var implements IExpr {
	private String name;

	public Var(String name) {
		this.name = name;
	}

	@Override
	public int valueOf() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <R> R accept(IExprVisitor<R> v) {
		return v.visitVar(name);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
