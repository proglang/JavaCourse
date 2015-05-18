package lesson_07;

import lesson_06.Binary;
import lesson_06.Binop;
import lesson_06.Const;
import lesson_06.IExpr;
import lesson_06.Unary;
import lesson_06.Unop;
import lesson_06.Var;

public class PlainExprFactory implements IExprFactory {

	@Override
	public IExpr makeVar(String ident) {
		return new Var(ident);
	}

	@Override
	public IExpr makeConst(int value) {
		return new Const(value);
	}

	@Override
	public IExpr makeUnary(Unop unop, IExpr exp) {
		return new Unary(unop, exp);
	}

	@Override
	public IExpr makeBinary(Binop binop, IExpr left, IExpr right) {
		return new Binary(binop, left, right);
	}

}
