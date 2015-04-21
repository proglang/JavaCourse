package lesson_02;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class SimpleTicketTest {

	@Test
	public void testSimpleTicket() {
		SimpleTicket st;
		st = new SimpleTicket(Tickets.LEVEL1, TicketCategory.CHILD);
		st = new SimpleTicket(Tickets.LEVEL2, TicketCategory.CHILD);
		st = new SimpleTicket(Tickets.LEVEL3, TicketCategory.CHILD);
		st = new SimpleTicket(Tickets.LEVEL1, TicketCategory.ADULT);
		st = new SimpleTicket(Tickets.LEVEL2, TicketCategory.ADULT);
		st = new SimpleTicket(Tickets.LEVEL3, TicketCategory.ADULT);
		try {
			st = new SimpleTicket(0, TicketCategory.ADULT);
			assertTrue(false);
		} catch (Exception e) {
			// correct behavior	
		}
		try {
			st = new SimpleTicket(42, TicketCategory.ADULT);
			assertTrue(false);
		} catch (Exception e) {
			// correct behavior	
		}
	}

	@Test
	public void testUsable() {
		SimpleTicket st;
		st = new SimpleTicket(Tickets.LEVEL1, TicketCategory.ADULT);
		assertTrue(st.isUsable());
		st.stamp(4711, FareZone.ZONE_A);
		assertFalse(st.isUsable());
		st.stamp(4711, FareZone.ZONE_B);
		assertFalse(st.isUsable());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testStamp() {
		SimpleTicket st;
		st = new SimpleTicket(Tickets.LEVEL1, TicketCategory.ADULT);
		st.stamp(0, FareZone.ZONE_A);
	}

	@Test
	public void testValid() {
		fail("Not yet implemented");
	}

}
