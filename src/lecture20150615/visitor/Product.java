package lecture20150615.visitor;

/**
 * The product of two arithmetic expressions ("left * right") is an arithmetic
 * expression.
 * 
 * @author fennell
 *
 */
public class Product implements IExpr {
	public final IExpr left, right;

	public Product(IExpr left, IExpr right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public <T> T accept(IExprVisitor<T> v) {
		return v.visitProduct(this); 
	}

	@Override
	public String toString() {
		return "(" + left.toString() + " * " + right.toString() + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		return true;
	}

}
