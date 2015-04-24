package lesson_04;

import lesson_02.FareZone;
import lesson_02.TicketCategory;
import lesson_02.Tickets;
import lesson_03.Validation;

public class ATicketLevelCategory extends ATicket {
	private int level; // Preisstufe 1, 2, 3

	private TicketCategory category; // new: Kind = CHILD, Erwachsener = ADULT

	protected ATicketLevelCategory(int level, TicketCategory category, int max_stamps) {
		super(max_stamps);
		if (level != Tickets.LEVEL1 && level != Tickets.LEVEL2 && level != Tickets.LEVEL3) {
			throw new IllegalArgumentException("Level should be 1, 2, 3");
		}
		if (max_stamps < 1) {
			throw new IllegalArgumentException("max_rides must be at least 1");
		}
		this.level = level;
		this.category = category;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validate(TicketCategory c, long t, FareZone z) {
		boolean result = (nr_of_stamps > 0) && (nr_of_stamps <= max_stamps);
		if (result) {
			Validation currentValidation = validation[nr_of_stamps - 1];
			result = result && (currentValidation.timeSinceCreated(t) <= level * Tickets.MILLISECONDS_PER_HOUR);
			result = result && (currentValidation.levelDifference(z) < level);
		}
		return result;
	}

}
