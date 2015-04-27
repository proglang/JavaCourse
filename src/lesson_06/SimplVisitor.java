package lesson_06;

public class SimplVisitor implements IExprVisitor<IExpr> {

	@Override
	public IExpr visitVar(String name) {
		return new Var(name);
	}

	@Override
	public IExpr visitUnary(Unop u, IExpr e) {
		return new Unary(u, e.accept(this));
	}

	@Override
	public IExpr visitConst(int c) {
		return new Const(c);
	}

	@Override
	public IExpr visitBinary(Binop b, IExpr left, IExpr right) {
		IExpr leftAfter = left.accept(this);
		IExpr rightAfter = right.accept(this);
		switch (b) {
		case DIV:
			if (rightAfter.isConst(1)) {
				return leftAfter;
			}
			break;
		case MINUS:
			if (leftAfter.isConst(0)) {
				return new Unary(Unop.UMINUS, rightAfter);
			} else if (rightAfter.isConst(0)) {
				return leftAfter;
			}
			break;
		case PLUS:
			if (leftAfter.isConst(0)) {
				return rightAfter;
			} else if (rightAfter.isConst(0)) {
				return leftAfter;
			}
			break;
		case TIMES:
			if (leftAfter.isConst(1)) {
				return rightAfter;
			} else if (rightAfter.isConst(1)) {
				return leftAfter;
			}
			break;
		default:
			break;
		
		}
		return new Binary(b, leftAfter, rightAfter);
	}

}
