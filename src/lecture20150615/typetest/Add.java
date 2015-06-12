package lecture20150615.typetest;

public class Add implements IExpr {
	public final IExpr left, right;

	public Add(IExpr left, IExpr right) {
		this.left = left;
		this.right = right;
	}

}
