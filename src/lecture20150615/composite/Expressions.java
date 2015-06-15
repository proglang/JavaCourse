package lecture20150615.composite;

public class Expressions {
	
	public static IExpr cnst(int i) { return new Const(i); }
	public static IExpr add(IExpr left, IExpr right) { return new Add(left, right); }
	public static IExpr add(int left, IExpr right) { return add(cnst(left), right); }
	public static IExpr add(IExpr left, int right) { return add(left, cnst(right)); }
	public static IExpr add(int left, int right) { return add(cnst(left), cnst(right)); }

	public static IExpr product(IExpr left, IExpr right) { return new Product(left, right); }
	public static IExpr product(int left, IExpr right) { return product(cnst(left), right); }
	public static IExpr product(IExpr left, int right) { return product(left, cnst(right)); }
	public static IExpr product(int left, int right) { return product(cnst(left), cnst(right)); }

}
