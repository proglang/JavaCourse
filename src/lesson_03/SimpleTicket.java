package lesson_03;

import lesson_02.FareZone;
import lesson_02.ITicket;
import lesson_02.PriceLevel;
import lesson_02.TicketCategory;
import lesson_02.Tickets;

public class SimpleTicket implements ITicket {
	// Preisstufe 1, 2, 3	
	private PriceLevel level;
	// CHILD or ADULT
	private TicketCategory category;
	
	private String id; // Nummer des Fahrscheins
	// representation of validation stamp
	private Validation validation; 
	
	private int nrOfStamps; 
	private static final int MAX_RIDES = 1;

	/**
	 * Create a new ticket given its price level and category.
	 * @param level must be one of LEVEL1, LEVEL2, or LEVEL3
	 * @param category
	 */
	public SimpleTicket(PriceLevel level, TicketCategory category) {
		this.level = level;
		this.category = category;
		this.nrOfStamps = 0;
	}

	/**
	 * @return true if the ticket can still be used
	 */
	public boolean isUsable() {
		return nrOfStamps < MAX_RIDES;
	}

	/**
	 * Stamp the ticket.
	 * @param t time of validation (in millisec)
	 * @param z location of validation (zone)
	 */
	public void stamp(long t, FareZone z) {
		if (this.isUsable()) {
			validation = new Validation(t, z);
		}
		nrOfStamps++;
	}
	
	/**
	 * Check if a ticket is valid given the passenger's category, the time of the check, and its location.
	 * @param c category of passenger (child or adult)
	 * @param t time of ticket check (millisec)
	 * @param z location of ticket check (zone)
	 * @return true iff the ticket is valid
	 */
	public boolean validate(TicketCategory c, long t, FareZone z) {
		boolean result = nrOfStamps == 1;
		result = result && (c.ordinal() <= this.category.ordinal());
		result = result && (validation.timeSinceCreated(t) <= level.getLevel() * Tickets.MILLISECONDS_PER_HOUR);
		result = result && (validation.levelDifference(z) < level.getLevel());
		return result;
	}

}
