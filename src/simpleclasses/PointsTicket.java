package simpleclasses;

import java.util.Date;

public class PointsTicket {
	private int price; // in cent
	private int id; // unique identification
	private int points = 20; // initial load of points
	
	// should contain a list of validations
	private Validation validation;
	// should contain a link to a followup pointsticket when there are insufficient points left
	private PointsTicket followup;
	
	public boolean stamp(Date d, int zone, int level) {
		if (points <= 0) {
			return false;
		}
		int pointsNeeded = 0;
		switch (level) {
		case 1:
			pointsNeeded = 3;
			break;
		case 2:
			pointsNeeded = 5;
			break;
		case 3:
			pointsNeeded = 7;
			break;
		default:
			return false;
		}
		if (this.collectPoints(pointsNeeded)) {
			validation = new Validation(d, zone, PassengerKind.ADULT, level);
			return true;
		} else {
			return false;
		}
	}

	private boolean collectPoints(int pointsNeeded) {
		// this method is called to obtain points from current and followup tickets
		if (pointsNeeded <= points) {
			points -= pointsNeeded;
			return true;
		} else if (followup == null) {
			return false;
		} else if (followup.collectPoints(pointsNeeded - points)) {
			points = 0;
			return true;
		} else {
			return false;			
		}
	}
}
