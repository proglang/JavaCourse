package lesson_01;

/**
 * @author thiemann
 *
 */
public class SimpleTicket {
	private int level; // Preisstufe 1, 2, 3
	private int category; // Kind = 0, Erwachsener = 1
	private String id; // Nummer des Fahrscheins
	private long timestamp; // Zeitstempel der Entwertung (in Millisekunden seit 1.1.1970), nicht entwertet=0, ungültig=1
	private int zone; // Ort der Entwertung: Zone A=1, B=2, C=3

	/**
	 * @param level
	 * @param category
	 */
	public SimpleTicket(int level, int category) {
		this.level = level;
		this.category = category;
	}
	
	/**
	 * Safe constructor method for simple tickets.
	 * @param level must be 1,2,3
	 * @param category must be 0,1
	 * @return a new legal SimpleTicket
	 */
	public static SimpleTicket create(int level, int category) {
		if (level < 1 || level > 3 || category < 0 || category > 1 ) {
			throw new IllegalArgumentException("Illegal level or category");
		}
		return new SimpleTicket(level, category);
	}

	/**
	 * Check if ticket can be used for a ride.
	 * @return true if the ticket can still be used
	 */
	public boolean isUsable() {
		return timestamp == 0;
	}

	/**
	 * Stamp this ticket.
	 * @param t time of validation (in millisec)
	 * @param z location of validation (zone)
	 */
	public void stamp(long t, int z) {
		if (isUsable()) {
			zone = z;
			timestamp = t;
		} else {
			timestamp = 1;
		}
	}
	
	/**
	 * Check if this ticket is valid for the current ride at given checkpoint.
	 * @param c category of passenger (child or adult)
	 * @param t time of ticket check (millisec)
	 * @param z location of ticket check (zone)
	 * @return true iff the ticket is valid
	 */
	public boolean validate(int c, long t, int z) {
		boolean result = timestamp > 1;
		result = result && (c < category);
		long timediff = t - timestamp;
		result = result && (timediff <= level * 60 * 60 * 1000);
		int leveldiff = Math.abs(zone - z);
		result = result && (leveldiff < level);
		return result;
	}
}
