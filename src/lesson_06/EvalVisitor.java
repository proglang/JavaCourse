package lesson_06;

import java.util.Map;

public class EvalVisitor implements IExprVisitor<Integer> {
	private Map<String,Integer> environment;

	@Override
	public Integer visitVar(String name) {
		return environment.get(name);
	}

	@Override
	public Integer visitUnary(Unop u, IExpr e) {
		int v = e.accept(this);
		switch(u) {
		case UMINUS:
			return -v;
		}
		return null;
	}

	@Override
	public Integer visitConst(int c) {
		return c;
	}

	@Override
	public Integer visitBinary(Binop b, IExpr left, IExpr right) {
		int l = left.accept(this);
		int r = right.accept(this);
		switch (b) {
		case PLUS:
			return l + r;
		case MINUS:
			return l - r;
		case TIMES:
			return l * r;
		case DIV:
			return l / r;
		}
		return null;
	}

}
