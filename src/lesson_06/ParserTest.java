package lesson_06;

import static org.junit.Assert.*;
import org.junit.Test;

public class ParserTest {

	@Test
	public void testParseConst() {
		String inp = " 711, ";
		Parser p = new Parser(inp);
		Const c = p.parseConst();
		assertNotNull("Did not parse constant", c);
		assertEquals(711, c.valueOf());
		assertTrue("Did not find next symbol", p.hasNext(","));
	}

	@Test
	public void testParseVar() {
		String inp = "  aNice_Variable+ ";
		Parser p = new Parser(inp);
		Var v = p.parseVar();
		assertNotNull("Did not parse variable", v);
		assertTrue("Did not find next symbol", p.hasNext("\\+"));
	}

	@Test
	public void testParseFactor() {
		String inp = " 4711, ";
		Parser p = new Parser(inp);
		IExpr e = p.parseFactor();
		assertNotNull("Factor: Did not parse constant", e);
		assertEquals(4711, e.valueOf());
		assertTrue("Did not find next symbol", p.hasNext(","));
		
		inp = " test_Parse_Factor42 . ";
		p = new Parser(inp);
		e = p.parseFactor();
		assertNotNull("Factor: Did not parse variable", e);
		assertTrue("Did not find next symbol", p.hasNext("."));
		
		inp = " (3+x) . ";
		p = new Parser(inp);
		e = p.parseFactor();
		assertNotNull("Factor: Did not parse paren", e);
		assertTrue("Did not find next symbol", p.hasNext("."));
	}

	@Test
	public void testParseParens() {
		String inp = "(42)";
		Parser p = new Parser(inp);
		IExpr e = p.parseParens();
		assertNotNull("Parens: did not parse", e);
		assertEquals(42, e.valueOf());
		assertFalse("Did not find next symbol", p.hasNext("."));
	}

	@Test
	public void testParseTerm() {
		String inp = "  2424 ; ";
		Parser p = new Parser(inp);
		IExpr t = p.parseTerm();
		assertNotNull("Term: Did not parse constant", t);
		assertEquals(2424, t.valueOf());
		assertTrue("Did not find next symbol", p.hasNext(";"));
		
		inp = " test_Parse_Factor42 . ";
		p = new Parser(inp);
		t = p.parseTerm();
		assertNotNull("Term: Did not parse variable", t);
		assertTrue("Did not find next symbol", p.hasNext("."));
	}
	@Test
	public void testParseTerm2() {
		String inp; Parser p; IExpr t;
		inp = " 3*9 -";
		p = new Parser(inp);
		t = p.parseTerm();
		assertNotNull("Term: Did not parse 3*9", t);
		assertEquals(27, t.valueOf());
		assertTrue("Term: did not find next symbol", p.hasNext("[+-]"));
		
		inp = "3*4*5";
		p = new Parser(inp);
		t = p.parseTerm();
		assertNotNull("Term: Did not parse 3*4*5", t);
		assertEquals(3*4*5, t.valueOf());
		assertFalse("Term: did not find EOF", p.hasNext(","));
		
		inp = "12/4*3";
		p = new Parser(inp);
		t = p.parseTerm();
		assertNotNull("Term: Did not parse 12/4*3", t);
		assertEquals(12/4*3, t.valueOf());
		assertFalse("Term: did not find EOF", p.hasNext(".+"));
	}
	
	@Test
	public void testParseTerm1() {
		String inp = "* 9 -";
		Parser p = new Parser(inp);
		IExpr t = new Const(3);
		t = p.parseTerm1(t);
		assertNotNull("Term1: Did not parse *9", t);
		assertEquals(27, t.valueOf());
		assertTrue("Term1: did not find next symbol", p.hasNext("[+-]"));
	}

	@Test
	public void testParseExpr() {
		String inp = "  2424 ; ";
		Parser p = new Parser(inp);
		IExpr t = p.parseExpr();
		assertNotNull("Expr: Did not parse constant", t);
		assertEquals(2424, t.valueOf());
		assertTrue("Did not find next symbol", p.hasNext(";"));
		
		inp = " test_Parse_Factor42 . ";
		p = new Parser(inp);
		t = p.parseExpr();
		assertNotNull("Expr: Did not parse variable", t);
		assertTrue("Did not find next symbol", p.hasNext("."));
		
		inp = " 3*9 ;";
		p = new Parser(inp);
		t = p.parseExpr();
		assertNotNull("Term: Did not parse 3*9", t);
		assertEquals(27, t.valueOf());
		assertTrue("Expr: did not find next symbol", p.hasNext(";"));
		
		inp = "3*4*5";
		p = new Parser(inp);
		t = p.parseExpr();
		assertNotNull("Expr: Did not parse 3*4*5", t);
		assertEquals(3*4*5, t.valueOf());
		assertFalse("Expr: did not find EOF", p.hasNext(","));
		
		inp = "12/4*3";
		p = new Parser(inp);
		t = p.parseExpr();
		assertNotNull("Expr: Did not parse 12/4*3", t);
		assertEquals(12/4*3, t.valueOf());
		assertFalse("Expr: did not find EOF", p.hasNext(".+"));
		
		inp = "3+4";
		p = new Parser(inp);
		t = p.parseExpr();
		assertNotNull("Expr: did not parse 3+4",t);
		assertEquals(3+4, t.valueOf());
		assertFalse("Expr: did not find EOF", p.hasNext(","));
		
		inp = "3-4+1";
		p = new Parser(inp);
		t = p.parseExpr();
		assertNotNull("Expr: did not parse 3-4+1",t);
		assertEquals(3-4+1, t.valueOf());
		assertFalse("Expr: did not find EOF", p.hasNext(","));
		
		inp = "3-2*2";
		p = new Parser(inp);
		t = p.parseExpr();
		assertNotNull("Expr: did not parse 3-2*2",t);
		assertEquals(3-2*2, t.valueOf());
		assertFalse("Expr: did not find EOF", p.hasNext(","));
		
		inp = "(3-2)*(1-2)";
		p = new Parser(inp);
		t = p.parseExpr();
		assertNotNull("Expr: did not parse (3-2)*(1-2)",t);
		assertEquals((3-2)*(1-2), t.valueOf());
		assertFalse("Expr: did not find EOF", p.hasNext(","));
		
		inp = "(3-2)*(1-2) + 1";
		p = new Parser(inp);
		t = p.parseExpr();
		assertNotNull("Expr: did not parse (3-2)*(1-2)+1",t);
		assertEquals((3-2)*(1-2) + 1, t.valueOf());
		assertFalse("Expr: did not find EOF", p.hasNext(","));
		
	}

}
