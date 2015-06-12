package lecture20150615.typetest;

import static org.junit.Assert.*;

import org.junit.Test;

public class OperationsTest {

	IExpr e_noVar = new Product(new Const(4), new Add(new Const(42), new Const(8)));
	IExpr e_var = new Product(new Var("x"), new Add(new Const(42), new Var("y")));

	@Test
	public void testEval() {
		assertEquals(200, Operations.eval(e_noVar));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFailingEval() {
		assertEquals(200, Operations.eval(e_var));
	}

}
