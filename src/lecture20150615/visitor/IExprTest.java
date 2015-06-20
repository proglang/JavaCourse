package lecture20150615.visitor;

import static org.junit.Assert.*;
import static lecture20150615.visitor.Expressions.*;

import org.junit.Test;

public class IExprTest {

	@Test
	public void test() {
		checkToString("x", var("x"));
		checkToString("45", cnst(45));
		checkToString("(3 + 4)", add(cnst(3), cnst(4)));
		checkToString("(3 * 4)", product(cnst(3), cnst(4)));
		checkToString("((2 * 3) + 4)", add(product(cnst(2),cnst(3)), cnst(4)));
	}

	private void checkToString(String x, IExpr e) {
		String r = e.toString();
		System.out.println("'" + r + "'");
		assertEquals(x, r);
	}

	public void testParse() {
		checkParse("x", var("x"));
		checkParse("45", cnst(45));
		checkParse("(3 + 4)", add(cnst(3), cnst(4)));
		checkParse("(3 * 4)", product(cnst(3), cnst(4)));
		checkParse("((2 * 3) + 4)", add(product(cnst(2),cnst(3)), cnst(4)));
	}

	private void checkParse(String input, IExpr expected) {
		IExpr result = parse(input);
		assertEquals(expected, result);
	}

	private IExpr parse(String input) {
		// TODO Auto-generated method stub
		return null;
	}
}
