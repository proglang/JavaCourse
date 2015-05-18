package lesson_07;

import lesson_06.Binop;
import lesson_06.IExpr;
import lesson_06.Unop;

public interface IExprFactory {
	IExpr makeVar(String ident);
	IExpr makeConst(int value);
	IExpr makeUnary(Unop unop, IExpr exp);
	IExpr makeBinary(Binop binop, IExpr left, IExpr right);
}
