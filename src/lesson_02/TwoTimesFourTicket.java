package lesson_02;

public class TwoTimesFourTicket implements ITicket {
	private int level; // Preisstufe 1, 2, 3

	private TicketCategory category; // new: Kind = CHILD, Erwachsener = ADULT

	private String id; // Nummer des Fahrscheins

	private long[] timestamp; // Zeitstempel der Entwertung (in Millisekunden seit 1.1.1970), nicht entwertet=0, ungültig=1

	private FareZone[] zone; // new: Ort der Entwertung: ZONE_A, ZONE_B, ZONE_C

	private int nr_of_stamps;
	private static final int MAX_RIDES = 8;

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
		this.timestamp = new long[MAX_RIDES];
		this.zone = new FareZone[MAX_RIDES];
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
	public void stamp(long t, FareZone z) { // new: type adapted
		if (isUsable()) {
			timestamp[nr_of_stamps] = t;
			zone[nr_of_stamps] = z;
		}
		nr_of_stamps++;
	}

	@Override
	public boolean validate(TicketCategory c, long t, FareZone z) {
		// TODO Auto-generated method stub
		return false;
	}

}
