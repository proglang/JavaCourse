package lesson_05;

import lesson_02.ITicket;
import lesson_02.PriceLevel;
import lesson_02.TicketCategory;
import lesson_04.PointsTicket;
import lesson_04.SimpleTicket;
import lesson_04.TwoTimesFourTicket;

public class TicketFactory {
	private static class Points implements IOrder {
		private static final int priceForPointsTicket = 1370;
		private PointsTicket previous;
		public Points(ITicket previous) {
			if (previous != null && ! (previous instanceof PointsTicket)) {
				throw new IllegalArgumentException("previous is not a PointsTicket");
			}
			this.previous = (PointsTicket) previous;
		}
		
		@Override
		public ITicket make(int price) {
			if (price == priceForPointsTicket) {
				return new PointsTicket(previous);
			}
			return null;
		}

	}

	private static int[] priceForSimpleChild = new int[] {0, 130, 230, 320};
	private static int[] priceForSimpleAdult = new int[] {0, 220, 380, 540};
	private static int[] priceForTwoFourChild = new int [] {0, 910, 1610, 2240};
	private static int[] priceForTwoFourAdult = new int [] {0, 1540, 2660, 3780};
	private interface IOrder {
		public ITicket make(int price);
	}
	private static abstract class AOrder implements IOrder {

		protected PriceLevel level;
		protected TicketCategory category;
		protected AOrder(PriceLevel level2, TicketCategory category) {
			this.level = level2;
			this.category = category;
		}
		protected boolean checkPrice(int price, int[] priceForChild, int[] priceForAdult) {
			switch(category) {
			case CHILD:
				return priceForChild[level.getLevel()] == price;
			case ADULT:
				return priceForAdult[level.getLevel()] == price;
			default:
				throw new AssertionError("Illegal ticket category");
			}
		}
		
	}
	private static class Simple extends AOrder {
		public Simple(PriceLevel level, TicketCategory category) {
			super(level, category);
		}
		@Override
		public ITicket make(int price) {
			if (checkPrice(price, priceForSimpleChild, priceForSimpleAdult)) {
				return new SimpleTicket(level, category);
			}
			return null;
		}
	}
	private static class TwoTimesFour extends AOrder {
		public TwoTimesFour(PriceLevel level, TicketCategory category) {
			super(level, category);
		}
		@Override
		public ITicket make(int price) {
			if (checkPrice(price, priceForTwoFourChild, priceForTwoFourAdult)) {
				return new TwoTimesFourTicket(level, category);
			}
			return null;
		}
	}
	
	public static ITicket makeSimple(int price, PriceLevel level, TicketCategory category) {
		return new Simple(level, category).make(price);
	}

	public static ITicket makeTwoTimesFour(int price, PriceLevel level, TicketCategory category) {
		return new TwoTimesFour(level, category).make(price);
	}
	
	public static ITicket makePointsTicket(int price, ITicket previous) {
		return new Points(previous).make(price);
	}
}
