package lesson_04;

import lesson_02.FareZone;
import lesson_02.PriceLevel;
import lesson_02.TicketCategory;
import lesson_02.Tickets;
import lesson_03.Validation;

public class ATicketLevelCategory extends ATicket {
	private PriceLevel level; // Preisstufe 1, 2, 3

	private TicketCategory category; // new: Kind = CHILD, Erwachsener = ADULT

	protected ATicketLevelCategory(PriceLevel level, TicketCategory category, int maxStamps) {
		super(maxStamps);
		if (maxStamps < 1) {
			throw new IllegalArgumentException("maxStamps must be greater than zero");
		}
		this.level = level;
		this.category = category;
	}

	@Override
	public boolean validate(TicketCategory c, long t, FareZone z) {
		boolean result = (stamps.size() <= maxStamps);
		result = result && (c.ordinal() <= category.ordinal()); // Adult with child's ticket?
		if (result) {
			Validation lastStamp = stamps.get(stamps.size()-1); 
			result = result && (lastStamp.timeSinceCreated(t) <= level.getLevel() * Tickets.MILLISECONDS_PER_HOUR);
			result = result && (lastStamp.levelDifference(z) < level.getLevel());
		}
		return result;
	}

}
