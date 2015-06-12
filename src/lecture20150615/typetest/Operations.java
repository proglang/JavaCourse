package lecture20150615.typetest;

public class Operations {
	
	public static int eval(IExpr e) {
		if (e instanceof Const) {
			Const c = (Const) e;
			return c.value;
		} else if (e instanceof Add) {
			Add a = (Add) e;
			return eval(a.left) + eval(a.right);
		} else if (e instanceof Product) {
			Product p = (Product) e;
			return eval(p.left) * eval(p.right);
		} else {
			throw new IllegalArgumentException("Unexpected expression case.");
		}
		
	}

}
