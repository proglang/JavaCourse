package lesson_05;

import static org.junit.Assert.*;
import lesson_02.FareZone;
import lesson_02.ITicket;
import lesson_02.TicketCategory;
import lesson_02.Tickets;

import org.junit.Test;

public class TicketFactoryTest {

	@Test
	public void testMakeSimple() {
		ITicket ticket;
		ticket = TicketFactory.makeSimple(130, Tickets.LEVEL1, TicketCategory.CHILD);
		firstUse(ticket);
		assertFalse("Ticket should no longer be usable", 
				ticket.isUsable());
	}

	private void firstUse(ITicket ticket) {
		assertNotNull("No ticket issued",
				ticket);
		nextUse(ticket, 4711);
	}

	private void nextUse(ITicket ticket, int basetime) {
		assertTrue("Ticket should be usable", 
				ticket.isUsable());
		assertFalse("Ticket should not be valid before stamping",
				ticket.validate(TicketCategory.CHILD, basetime, FareZone.ZONE_A));
		ticket.stamp(basetime, FareZone.ZONE_A);
		assertTrue("Ticket should be valid right after stamping",
				ticket.validate(TicketCategory.CHILD, basetime + 1, FareZone.ZONE_A));
		assertTrue("Ticket should still be valid after almost one hour", 
				ticket.validate(TicketCategory.CHILD, basetime + Tickets.MILLISECONDS_PER_HOUR - 1, FareZone.ZONE_A));
		assertTrue("Ticket should be valid after exactly one hour",
				ticket.validate(TicketCategory.CHILD, basetime + Tickets.MILLISECONDS_PER_HOUR, FareZone.ZONE_A));
		assertFalse("Ticket should no longer be valid after one hour",
				ticket.validate(TicketCategory.CHILD, basetime + Tickets.MILLISECONDS_PER_HOUR + 1, FareZone.ZONE_A));
	}

	@Test
	public void testMakeTwoTimesFour() {
		ITicket ticket;
		ticket = TicketFactory.makeTwoTimesFour(910, Tickets.LEVEL1, TicketCategory.CHILD);
		firstUse(ticket);
		for (int j = 1; j < 8; j++) {
			nextUse(ticket, (Tickets.MILLISECONDS_PER_HOUR + 5000) * j);
		}
		assertFalse("Ticket should no longer be usable",
				ticket.isUsable());
	}

	@Test
	public void testMakePoints() {
		ITicket ticket;
		ticket = TicketFactory.makePointsTicket(1200, null);
		assertNull("Ticket issued for wrong price",
				ticket);
		ticket = TicketFactory.makePointsTicket(1370, null);
		assertNotNull("Ticket not issued", 
				ticket);
		assertTrue("Ticket should be usable", ticket.isUsable());
		ticket.stamp(4711, FareZone.ZONE_A);
		assertFalse("Ticket should not yet be valid", ticket.validate(TicketCategory.ADULT, 5000, FareZone.ZONE_A));
		ticket.stamp(4711, FareZone.ZONE_A);
		assertFalse("Ticket should not yet be valid", ticket.validate(TicketCategory.ADULT, 5000, FareZone.ZONE_A));
		ticket.stamp(4711, FareZone.ZONE_A);
		assertTrue("Ticket should be valid", ticket.validate(TicketCategory.ADULT, 5000, FareZone.ZONE_A));
		
		
	}
}
