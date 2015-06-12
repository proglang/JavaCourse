package lecture20150615.visitor;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimplifyTest {

	IExpr e_42 = new Product(new Const(1), new Add(new Const(42), new Const(0)));
	IExpr e_0 = new Product(new Const(42), new Add(new Const(0), (new Product(new Var("y"), new Const(0)))));

	@Test
	public void test42() {
		IExpr result = e_42.accept(new Simplify()).expr;
		assertEquals(new Const(42), result);
	}
	
	@Test
	public void test0() {
		IExpr result = e_0.accept(new Simplify()).expr;
		assertEquals(new Const(0), result);
	}

}
