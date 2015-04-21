package lesson_02;

public interface ITicket {
	
	public boolean isUsable();
	public void stamp(long t, FareZone z);
	public boolean validate(TicketCategory c, long t, FareZone z);
}
