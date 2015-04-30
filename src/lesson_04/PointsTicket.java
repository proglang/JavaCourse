package lesson_04;

import lesson_02.FareZone;
import lesson_02.PriceLevel;
import lesson_02.TicketCategory;
import lesson_02.Tickets;
import lesson_03.Validation;

public class PointsTicket extends ATicket {
	private String id;
	private PointsTicket previous;
	private static int MAX_STAMPS = 20;

	public PointsTicket(PointsTicket previous) {
		super(MAX_STAMPS);
		init(previous);
	}
	
	public PointsTicket() {
		super(MAX_STAMPS);
		init(null);
	}

	private void init(PointsTicket previous) {
		this.previous = previous;
	}

	@Override
	public boolean validate(TicketCategory c, long t, FareZone z) {
		boolean result = this.stamps.size() <= MAX_STAMPS;
		if (result) {
			Validation lastValidation = stamps.get(stamps.size()-1);
			int count = countValidations(lastValidation);
			PriceLevel level;
			if (count >= Tickets.STAMPS_FOR_LEVEL3) {
				level = PriceLevel.LEVEL_3;
			} else if (count >= Tickets.STAMPS_FOR_LEVEL2) {
				level = PriceLevel.LEVEL_2;
			} else if (count >= Tickets.STAMPS_FOR_LEVEL1) {
				level = PriceLevel.LEVEL_1;
			} else {
				return false;
			}
			result = result && (lastValidation.timeSinceCreated(t) <= level.getLevel() * Tickets.MILLISECONDS_PER_HOUR);
			result = result && (lastValidation.levelDifference(z) < level.getLevel());
		}
		return result;
	}

	private int countValidations(Validation lastValidation) {
		int count = 0;
		if (this.stamps.size() <= MAX_STAMPS) {
			for (Validation stamp : this.stamps) {
				if (lastValidation.equals(stamp)) {
					count++;
				}
			}
		}
		if (previous != null) {
			count += previous.countValidations(lastValidation);
		}
		return count;
	}

}
