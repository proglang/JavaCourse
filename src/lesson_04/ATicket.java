package lesson_04;

import java.util.LinkedList;
import java.util.List;

import lesson_02.FareZone;
import lesson_02.ITicket;
import lesson_02.TicketCategory;
import lesson_03.Validation;

public abstract class ATicket implements ITicket {
	private String id; // Nummer des Fahrscheins
	
	protected List<Validation> stamps;
	
	protected int maxStamps;

	/**
	 * Create a new ticket given its price level and category.
	 * @param level must be one of LEVEL1, LEVEL2, or LEVEL3
	 */
	protected ATicket(int maxStamps) {
		this.maxStamps = maxStamps;
		this.stamps = new LinkedList<Validation>();
	}

	protected int getNrOfStamps() {
		return this.stamps.size();
	}

	@Override
	public boolean isUsable() {
		return getNrOfStamps() < maxStamps;
	}

	@Override
	public void stamp(long t, FareZone z) {
		this.stamps.add(new Validation(t, z));
	}

	@Override
	public abstract boolean validate(TicketCategory c, long t, FareZone z);

}
