package lesson_04;

import lesson_02.FareZone;
import lesson_02.ITicket;
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
		boolean result = this.nrOfStamps > 0 && this.nrOfStamps <= MAX_STAMPS;
		if (result) {
			Validation lastValidation = validation[this.nrOfStamps - 1];
			int count = countValidations(lastValidation);
			int level;
			if (count >= Tickets.STAMPS_FOR_LEVEL3) {
				level = Tickets.LEVEL3;
			} else if (count >= Tickets.STAMPS_FOR_LEVEL2) {
				level = Tickets.LEVEL2;
			} else if (count >= Tickets.STAMPS_FOR_LEVEL1) {
				level = Tickets.LEVEL1;
			} else {
				return false;
			}
			result = result && (lastValidation.timeSinceCreated(t) <= level * Tickets.MILLISECONDS_PER_HOUR);
			result = result && (lastValidation.levelDifference(z) < level);
		}
		return result;
	}

	private int countValidations(Validation lastValidation) {
		int count = 0;
		if (this.nrOfStamps <= MAX_STAMPS) {
			for (int i = this.nrOfStamps - 1; i >= 0; i--) {
				if (lastValidation.equals(validation[i])) {
					count++;
				} else {
					break;
				}
			}
		}
		if (previous != null) {
			count += previous.countValidations(lastValidation);
		}
		return count;
	}

}
