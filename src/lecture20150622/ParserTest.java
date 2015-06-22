package lecture20150622;

import static org.junit.Assert.*;
import static lecture20150615.visitor.Expressions.*;
import lecture20150615.visitor.IExpr;

import org.junit.Test;

public class ParserTest {

	@Test
	public void testParseFactor() {
		String input = "xxx";
		IExpr expected = var("xxx");
		checkParseFactor(input, expected);
		
		input = " 1234";
		expected = cnst(1234);
		checkParseFactor(input, expected);
	}

	private void checkParseFactor(String input, IExpr expected) {
		IScanner scan = new StringScanner(input);
		IExpr result = new Parser(scan).parseFactor();
		assertEquals(expected, result);
	}

	@Test
	public void testParseExpr() {
		String input = "42";
		IExpr expected = cnst(42);
		checkParseExpr(input, expected);
		
		input = "42 + x";
		expected = add(cnst(42), var("x"));
		checkParseExpr(input, expected);
		
		input = "4711 * z";
		expected = product(cnst(4711), var("z"));
		checkParseExpr(input, expected);
		
		input = "1 + 2 * 3";
		expected = add(cnst(1), product(cnst(2), cnst(3)));
		checkParseExpr(input, expected);
		
		input = "(1 + 2) * 3";
		expected = product(add(cnst(1), cnst(2)), cnst(3));
		checkParseExpr(input, expected);
	}

	private void checkParseExpr(String input, IExpr expected) {
		IScanner scan = new StringScanner(input);
		IExpr result = new Parser(scan).parseExpr();
		assertEquals(expected, result);
	}

	@Test
	public void testParseExpr1() {
		String input = "";
		IExpr stop = var("stop");
		IExpr expected = stop;
		checkParseExpr1(input, stop, expected);
		
		input = "+ xy";
		expected = add(stop, var("xy"));
		checkParseExpr1(input, stop, expected);
		
		input = "+ x * y";
		expected = add(stop, product(var("x"), var("y")));
		checkParseExpr1(input, stop, expected);
		
		input = "+ x*y + 13";
		expected = add (add(stop, product(var("x"), var("y"))), cnst(13));
		checkParseExpr1(input, stop, expected);
	}

	private void checkParseExpr1(String input, IExpr stop, IExpr expected) {
		IScanner scan = new StringScanner(input);
		IExpr result = new Parser(scan).parseExpr1(stop);
		assertEquals(expected, result);
	}

	@Test
	public void testParseTerm() {
		String input = "level";
		IExpr expected = var("level");
		checkParseTerm(expected, input);
		
		input = "level * 17";
		expected = product(var("level"), cnst(17));
		checkParseTerm(expected, input);
		
		input = "2 * xx * yy";
		expected = product(product(cnst(2), var("xx")), var("yy"));
		checkParseTerm(expected, input);
	}

	private void checkParseTerm(IExpr expected, String input) {
		IScanner scan = new StringScanner(input);
		IExpr result = new Parser(scan).parseTerm();
		assertEquals(expected, result);
	}

	@Test
	public void testParseTerm1() {
		String input = "";
		IExpr stop = var("stop");
		IExpr expected = stop;
		checkTestTerm1(input, stop, expected);
		
		input = "* index";
		expected = product(stop, var("index"));
		checkTestTerm1(input, stop, expected);
		
		input = "   *42 ";
		expected = product(stop, cnst(42));
		checkTestTerm1(input, stop, expected);
	}

	private void checkTestTerm1(String input, IExpr stop, IExpr expected) {
		IScanner scan = new StringScanner(input);
		IExpr result = new Parser(scan).parseTerm1(stop);
		assertEquals(expected, result);
	}

}
