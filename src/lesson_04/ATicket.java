package lesson_04;

import lesson_02.FareZone;
import lesson_02.ITicket;
import lesson_02.TicketCategory;
import lesson_03.Validation;

public abstract class ATicket implements ITicket {
	private String id; // Nummer des Fahrscheins
	
	protected Validation[] validation;
	
	protected int nr_of_stamps;

	protected int max_stamps;

	/**
	 * Create a new ticket given its price level and category.
	 * @param level must be one of LEVEL1, LEVEL2, or LEVEL3
	 */
	protected ATicket(int max_stamps) {
		this.nr_of_stamps = 0;
		this.max_stamps = max_stamps;
		this.validation = new Validation[max_stamps];
	}

	@Override
	public boolean isUsable() {
		return nr_of_stamps < max_stamps;
	}

	@Override
	public void stamp(long t, FareZone z) {
		if (isUsable()) {
			validation[nr_of_stamps] = new Validation(t, z);
		}
		nr_of_stamps++;
	}

	@Override
	public abstract boolean validate(TicketCategory c, long t, FareZone z);

}
