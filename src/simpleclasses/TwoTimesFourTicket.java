package simpleclasses;

import java.util.Date;

public class TwoTimesFourTicket {
	private int price; // in cent
	private int level; // Preisstufe: 1, 2 oder 3
	private PassengerKind kind;
	private int id; // unique identification
	private Date validation1; // first stamp
	private Date validation2; // second stamp
	private Date validation3; // etc
	private Date validation4;
	
	// task: write a toString() method!
	// task: write a stamp() method!
	
	public boolean stamp(Date d) {
		if (validation1 != null) {
			validation1 = d;
			return true;
		} else if (validation2 != null) {
			validation2 = d;
			return true;
		} else if (validation3 != null) {
			validation3 = d;
			return true;
		} else if (validation4 != null) {
			validation4 = d;
			return true;
		} else {
			return false;
		}
	}
}
