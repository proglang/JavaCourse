package lesson_03a;

import java.util.LinkedList;
import java.util.List;

import lesson_02.FareZone;
import lesson_02.ITicket;
import lesson_02.PriceLevel;
import lesson_02.TicketCategory;
import lesson_02.Tickets;
import lesson_03.Validation;

public class SimpleTicket implements ITicket {
	// Preisstufe 1, 2, 3	
	private final PriceLevel level;
	// CHILD or ADULT
	private final TicketCategory category;
	
	private String id; // Nummer des Fahrscheins
	// representation of validation stamp
	private final List<Validation> stamps; 
	
	private static final int MAX_RIDES = 1;

	/**
	 * Create a new ticket given its price level and category.
	 * @param level must be one of LEVEL1, LEVEL2, or LEVEL3
	 * @param category
	 */
	public SimpleTicket(PriceLevel level, TicketCategory category) {
		this.level = level;
		this.category = category;
		this.stamps = new LinkedList<Validation>();
	}

	/**
	 * @return true if the ticket can still be used
	 */
	public boolean isUsable() {
		return stamps.size() < MAX_RIDES;
	}

	/**
	 * Stamp the ticket.
	 * @param t time of validation (in millisec)
	 * @param z location of validation (zone)
	 */
	public void stamp(long t, FareZone z) {
		this.stamps.add(new Validation(t, z));
	}
	
	/**
	 * Check if a ticket is valid given the passenger's category, the time of the check, and its location.
	 * @param c category of passenger (child or adult)
	 * @param t time of ticket check (millisec)
	 * @param z location of ticket check (zone)
	 * @return true iff the ticket is valid
	 */
	public boolean validate(TicketCategory c, long t, FareZone z) {
		boolean result = stamps.size() == 1;
		if (result) {
			Validation validation = stamps.get(0);
			result = result && (c.ordinal() <= this.category.ordinal());
			result = result && (validation.timeSinceCreated(t) <= level.getLevel() * Tickets.MILLISECONDS_PER_HOUR);
			result = result && (validation.levelDifference(z) < level.getLevel());
		}
		return result;
	}


}
