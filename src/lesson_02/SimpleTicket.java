package lesson_02;

public class SimpleTicket implements ITicket {
	private PriceLevel level; // Preisstufe 1, 2, 3

	private TicketCategory category; // new: Kind = CHILD, Erwachsener = ADULT

	private String id; // Nummer des Fahrscheins

	private long timestamp; // Zeitstempel der Entwertung (in Millisekunden seit 1.1.1970)

	private FareZone zone; // new: Ort der Entwertung: ZONE_A, ZONE_B, ZONE_C
	
	private static final int MAX_RIDES = 1;
	private int nrOfStamps;

	/**
	 * Create a new ticket given its price level and category.
	 * @param level must be one of LEVEL1, LEVEL2, or LEVEL3
	 * @param category
	 */
	public SimpleTicket(PriceLevel level, TicketCategory category) { // new: changed type
		// new: test argument for legality
		this.level = level;
		this.category = category;
		this.nrOfStamps = 0;
	}

	/**
	 * @return true if the ticket can still be used
	 */
	public boolean isUsable() {
		return nrOfStamps < MAX_RIDES; // new: named
	}

	/**
	 * Stamp the ticket.
	 * @param t time of validation (in millisec)
	 * @param z location of validation (zone)
	 */
	public void stamp(long t, FareZone z) { // new: type adapted
		if (isUsable()) {
			zone = z;
			timestamp = t;
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
		boolean result = (nrOfStamps > 0) && (nrOfStamps < MAX_RIDES); // new: adapted to named values
		result = result && (c.ordinal() <= category.ordinal()); // new: changed type and comparison
		long timediff = t - timestamp;
		result = result && (timediff <= level.getLevel() * Tickets.MILLISECONDS_PER_HOUR); // new: named
		int leveldiff = Math.abs(zone.ordinal() - z.ordinal()); // new: enum -> number
		result = result && (leveldiff < level.getLevel());
		return result;
	}
}
