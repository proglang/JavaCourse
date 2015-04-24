package lesson_02;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class SimpleTicketTest {

	@Test
	public void testUsable() {
		SimpleTicket st;
		st = new SimpleTicket(PriceLevel.LEVEL_1, TicketCategory.ADULT);
		assertTrue(st.isUsable());
		st.stamp(4711, FareZone.ZONE_A);
		assertFalse(st.isUsable());
		st.stamp(4711, FareZone.ZONE_B);
		assertFalse(st.isUsable());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testStamp() {
		SimpleTicket st;
		st = new SimpleTicket(PriceLevel.LEVEL_1, TicketCategory.ADULT);
		st.stamp(0, FareZone.ZONE_A);
	}

	@Test
	public void testValid() {
		fail("Not yet implemented");
	}

}
