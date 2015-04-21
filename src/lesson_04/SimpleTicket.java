package lesson_04;

import lesson_02.TicketCategory;

public class SimpleTicket extends ATicketLevelCategory {

	public SimpleTicket(int level, TicketCategory category) {
		super(level, category, 1);
	}

}
