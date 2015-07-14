package lecture20150713;

import java.util.Arrays;

import lecture20150615.visitor.IExpr;

public class Statements {
	public static IStmt assign (String var, IExpr exp) {
		return new Assign(var, exp);
	}
	public static IStmt if_st (IExpr exp, IStmt tstmt, IStmt fstmt) {
		return new If (exp, tstmt, fstmt);
	}
	public static IStmt while_st(IExpr exp, IStmt body) {
		return new While(exp, body);
	}
	public static IStmt seq(IStmt... stmts) {
		return new Sequence(Arrays.asList(stmts));
	}
}
