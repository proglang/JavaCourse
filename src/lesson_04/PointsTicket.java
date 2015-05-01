package lesson_04;

import lesson_02.FareZone;
import lesson_02.PriceLevel;
import lesson_02.TicketCategory;
import lesson_02.Tickets;
import lesson_03.Validation;

public class PointsTicket extends ATicket {
	private String id;
	private final PointsTicket previous;
	private final static int MAX_STAMPS = 20;

	public PointsTicket(PointsTicket previous) {
		super(MAX_STAMPS);
		this.previous = previous;
	}
	
	public PointsTicket() {
		super(MAX_STAMPS);
		this.previous = null;
	}

	@Override
	public boolean validate(TicketCategory c, long t, FareZone z) {
		int nrStamps = getNrOfStamps();
		boolean result = (nrStamps > 0) && (nrStamps <= MAX_STAMPS);
		if (result) {
			Validation validation = stamps.get(nrStamps-1);
			int count = countValidations(validation);
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
			result = result && (validation.timeSinceCreated(t) <= level.getLevel() * Tickets.MILLISECONDS_PER_HOUR);
			result = result && (validation.levelDifference(z) < level.getLevel());
		}
		return result;
	}

	private int countValidations(Validation validation) {
		int count = 0;
		if (this.stamps.size() <= MAX_STAMPS) {
			for (Validation stamp : this.stamps) {
				if (validation.equals(stamp)) {
					count++;
				}
			}
		}
		if (previous != null) {
			count += previous.countValidations(validation);
		}
		return count;
	}

}
