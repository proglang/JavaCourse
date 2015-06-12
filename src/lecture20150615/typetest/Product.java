package lecture20150615.typetest;

public class Product implements IExpr {
	public final IExpr left, right;

	public Product(IExpr left, IExpr right) {
		this.left = left;
		this.right = right;
	}
}
