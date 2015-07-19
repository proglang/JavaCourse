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
		
		input = "while(x) {}";
		expected = while_st(var("x"), seq());
		runParser(input, expected);
		
		input = "{x=1; y=2;}";
		expected = seq(assign("x", cnst(1)), assign("y", cnst(2)));
		runParser(input, expected);
		
		input = "while(b) b = b + 1";
		expected = while_st(var("b"), assign("b", add(var("b"), 1)));
		runParser(input, expected);
				
	}

	private void runParser(String input, IStmt expected) {
		IStmt actual = new Parser(new StringScanner(input)).parseStmt();
		assertEquals(expected, actual);
	}

}
