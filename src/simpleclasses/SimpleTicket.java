package simpleclasses;

import java.util.Date;

public class SimpleTicket {
	private int price; // in cent
	private int level; // Preisstufe: one of 1, 2, 3
	private PassengerKind kind;
	private int id; // unique ticket identification
	private Date validation; // time when the ticket was stamped; null = ticket not yet stamped
	
	// task: write a toString() method!
	// task: write a stamp() method!
	
	public boolean stamp(Date d) {
		if (validation != null) {
			validation = d;
			return true;
		} else {
			return false;
		}
	}
}
