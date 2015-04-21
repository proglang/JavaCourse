package lesson_01;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleTicketTest {

	@Test
	public void testIsUsable() {
		SimpleTicket st = new SimpleTicket(1, 1);
		assertTrue("Ticket should be usable", st.isUsable());
	}

	@Test
	public void testStamp() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidate() {
		fail("Not yet implemented");
	}

}
