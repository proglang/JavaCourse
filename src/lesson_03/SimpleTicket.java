package lesson_03;

import lesson_02.FareZone;
import lesson_02.ITicket;
import lesson_02.TicketCategory;
import lesson_02.Tickets;

public class SimpleTicket implements ITicket {
	private int level; // Preisstufe 1, 2, 3

	private TicketCategory category; // new: Kind = CHILD, Erwachsener = ADULT

	private String id; // Nummer des Fahrscheins
	
	private Validation validation; 
	
	private int nr_of_stamps; 

	/**
	 * Create a new ticket given its price level and category.
	 * @param level must be one of LEVEL1, LEVEL2, or LEVEL3
	 * @param category
	 */
	public SimpleTicket(int level, TicketCategory category) {
		if (level != Tickets.LEVEL1 && level != Tickets.LEVEL2 && level != Tickets.LEVEL3) {
			throw new IllegalArgumentException("Level should be 1, 2, 3");
		}
		this.level = level;
		this.category = category;
		this.nr_of_stamps = 0;
	}

	/**
	 * @return true if the ticket can still be used
	 */
	public boolean isUsable() {
		return nr_of_stamps < 1;
	}

	/**
	 * Stamp the ticket.
	 * @param t time of validation (in millisec)
	 * @param z location of validation (zone)
	 */
	public void stamp(long t, FareZone z) {
		if (nr_of_stamps < 1) {
			validation = new Validation(t, z);
		}
		nr_of_stamps++;
	}
	
	/**
	 * Check if a ticket is valid given the passenger's category, the time of the check, and its location.
	 * @param c category of passenger (child or adult)
	 * @param t time of ticket check (millisec)
	 * @param z location of ticket check (zone)
	 * @return true iff the ticket is valid
	 */
	public boolean validate(TicketCategory c, long t, FareZone z) {
		boolean result = nr_of_stamps == 1;
		result = result && (c.compareTo(category) < 0);
		result = result && (validation.timeSinceCreated(t) <= level * Tickets.MILLISECONDS_PER_HOUR);
		result = result && (validation.levelDiff(z) < level);
		return result;
	}

}
