package lecture20150615.visitor;

import static org.junit.Assert.*;

import static lecture20150615.visitor.Expressions.*;

import org.junit.Test;

public class SimplifyTest {

	IExpr e_42 = product(1, add(42, 0));
	IExpr e_0 = product(42, add(0, (product(var("y"), 0))));

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
