package lesson_06;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinopTest {

	@Test
	public void testFromToken() {
		assertEquals(Binop.DIV, Binop.fromToken("/"));
		assertEquals(Binop.MINUS, Binop.fromToken("-"));
		assertEquals(Binop.PLUS, Binop.fromToken("+"));
		assertEquals(Binop.TIMES, Binop.fromToken("*"));
		assertNull(Binop.fromToken("foo"));
	}

}
