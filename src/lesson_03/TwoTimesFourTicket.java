package lesson_03;

import lesson_02.FareZone;
import lesson_02.ITicket;
import lesson_02.TicketCategory;
import lesson_02.Tickets;

public class TwoTimesFourTicket implements ITicket {
	private static final int MAX_RIDES = 8;

	private int level; // Preisstufe 1, 2, 3

	private TicketCategory category; // new: Kind = CHILD, Erwachsener = ADULT

	private String id; // Nummer des Fahrscheins
	
	private Validation[] validation;
	
	private int nr_of_stamps;

	/**
	 * Create a new ticket given its price level and category.
	 * @param level must be one of LEVEL1, LEVEL2, or LEVEL3
	 * @param category
	 */
	public TwoTimesFourTicket(int level, TicketCategory category) {
		if (level != Tickets.LEVEL1 && level != Tickets.LEVEL2 && level != Tickets.LEVEL3) {
			throw new IllegalArgumentException("Level should be 1, 2, 3");
		}
		this.level = level;
		this.category = category;
		this.validation = new Validation[MAX_RIDES];
		this.nr_of_stamps = 0;
	}

	/**
	 * @return true if the ticket can still be used
	 */
	public boolean isUsable() {
		return nr_of_stamps < MAX_RIDES;
	}

	/**
	 * Stamp the ticket.
	 * @param t time of validation (in millisec)
	 * @param z location of validation (zone)
	 */
	public void stamp(long t, FareZone z) { 
		if (isUsable()) {
			validation[nr_of_stamps] = new Validation(t, z);
		}
		nr_of_stamps++;
	}

	@Override
	public boolean validate(TicketCategory c, long t, FareZone z) {
		// TODO Auto-generated method stub
		return false;
	}

}
