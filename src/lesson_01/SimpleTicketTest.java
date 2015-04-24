package lesson_01;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleTicketTest {

	@Test
	public void testIsUsable() {
		SimpleTicket st = SimpleTicket.create(1, 1);
		assertTrue("Ticket should be usable", st.isUsable());
		st.stamp(4711, 1);
		assertFalse("Ticket should no longer be usable", st.isUsable());
		st.stamp(5000, 2);
		assertFalse("Ticket should remain unusable", st.isUsable());
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
