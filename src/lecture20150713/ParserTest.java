package lecture20150713;

import static lecture20150615.visitor.Expressions.*;
import static lecture20150713.Statements.*;
import static org.junit.Assert.*;

import lecture20150622.StringScanner;

import org.junit.Test;

public class ParserTest {

	@Test
	public void test() {
		String input = "x=5";
		IStmt expected = assign("x", cnst(5));
		runParser(input, expected);
		
		input = "{}";
		expected = seq();
		runParser(input, expected);
		
		input = "if(x) { } else { }";
		expected = if_st(var("x"), seq(), seq());
		runParser(input, expected);
		
		
	}

	private void runParser(String input, IStmt expected) {
		IStmt actual = new Parser(new StringScanner(input)).parseStmt();
		assertEquals(expected, actual);
	}

}
