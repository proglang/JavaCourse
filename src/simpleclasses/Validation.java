package simpleclasses;

import java.util.Date;

public class Validation {
	private Date stamped; // time when the validation was created
	private int location; // zone where the validation was created: 1, 2, 3
	private PassengerKind kind; // validated for which kind of passenger
	private int level; // Preisstufe: 1, 2, 3
	
	public Validation(Date stamped, int location, PassengerKind kind, int level) {
		this.stamped = stamped;
		this.location = location;
		this.kind = kind;
		this.level = level;
	}
}
