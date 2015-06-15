package lecture20150615.composite;

import static org.junit.Assert.*;

import static lecture20150615.composite.Expressions.*;

import org.junit.Test;

public class IExprTest {

	@Test
	public void testEval() {
		// (42 + (5 * 4)) * (2 + 1)
		IExpr e = new Product(new Add(new Const(42), new Product(new Const(5),
				new Const(4))), new Add(new Const(2), new Const(1)));
		assertEquals(168, e.eval());
	}

	@Test
	public void testEvalStatic() {
		// (42 + (5 * 4)) * (2 + 1)
		IExpr e = product(add(cnst(42), product(cnst(5), cnst(4))), add(cnst(2), cnst(1)));
		assertEquals(168, e.eval());
	}

}
