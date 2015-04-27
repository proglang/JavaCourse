package lesson_04;

import lesson_02.PriceLevel;
import lesson_02.TicketCategory;

public class SimpleTicket extends ATicketLevelCategory {

	public SimpleTicket(PriceLevel level, TicketCategory category) {
		super(level, category, 1);
	}

}
