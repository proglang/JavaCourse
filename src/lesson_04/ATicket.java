package lesson_04;

import lesson_02.FareZone;
import lesson_02.ITicket;
import lesson_02.TicketCategory;
import lesson_03.Validation;

public abstract class ATicket implements ITicket {
	private String id; // Nummer des Fahrscheins
	
	protected Validation[] validation;
	
	protected int nrOfStamps;

	protected int maxStamps;

	/**
	 * Create a new ticket given its price level and category.
	 * @param level must be one of LEVEL1, LEVEL2, or LEVEL3
	 */
	protected ATicket(int maxStamps) {
		this.nrOfStamps = 0;
		this.maxStamps = maxStamps;
		this.validation = new Validation[maxStamps];
	}

	@Override
	public boolean isUsable() {
		return nrOfStamps < maxStamps;
	}

	@Override
	public void stamp(long t, FareZone z) {
		if (isUsable()) {
			validation[nrOfStamps] = new Validation(t, z);
		}
		nrOfStamps++;
	}

	@Override
	public abstract boolean validate(TicketCategory c, long t, FareZone z);

}
