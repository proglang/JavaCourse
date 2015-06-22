package lecture20150622;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringScannerTest {

	@Test
	public void testLookingAt() {
		IScanner scan = new StringScanner("1234 xxx+ yyy");
		assertTrue(scan.lookingAt("\\d+"));
		
		scan = new StringScanner("  xxxx");
		assertTrue(scan.lookingAt("\\w+"));
		
		scan = new StringScanner("+ ");
		assertTrue(scan.lookingAt("\\+"));
		
		scan = new StringScanner("123");
		assertFalse(scan.lookingAt("[A-Za-z]+"));
	}

	@Test
	public void testGetLexeme() {
		IScanner scan = new StringScanner("1234 xxx+ yyy");
		assertEquals("1234", scan.getLexeme("\\d+"));
		assertEquals("xxx", scan.getLexeme("\\w+"));
		assertEquals("+", scan.getLexeme("\\+"));
		assertNull(scan.getLexeme("\\d+"));
	}

}
