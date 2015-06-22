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
		fail("Not yet implemented");
	}

	@Test
	public void testParseExpr1() {
		fail("Not yet implemented");
	}

	@Test
	public void testParseTerm() {
		fail("Not yet implemented");
	}

	@Test
	public void testParseTerm1() {
		String input = "";
		IExpr stop = var("stop");
		IExpr expected = stop;
		IScanner scan = new StringScanner(input);
		IExpr result = new Parser(scan).parseTerm1(stop);
		assertEquals(expected, result);
	}

}
