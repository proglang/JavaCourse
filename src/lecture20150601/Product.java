package lecture20150601;

public class Product implements IExpr {
	private final IExpr left, right;

	public Product(IExpr left, IExpr right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public int value() {
		return this.left.value() * this.right.value();
	}

	@Override
	public int size() {
		return 1 + this.left.size() + this.right.size();
	}

}
