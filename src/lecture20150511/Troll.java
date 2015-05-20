package lecture20150511;

public class Troll extends AMonster {
	/**
	 * health points - some measure about the live force
	 */
	private Troll(int hp) {
		super(hp);
	}
	
	/**
	 * factory method for trolls. ensure that only living trolls are created.
	 * @param hp health points must be > 0.
	 * @return a fit troll.
	 */
	public static Troll create(int hp) {
		if (hp<=0) {
			throw new IllegalArgumentException("troll unfit for life");
		}
		return new Troll(hp);
	}

	/**
	 * update troll status when hit
	 * @param force
	 * @return true if still alive
	 */
	public boolean hit(int force) {
		System.out.println("Ouch!");
		boolean stayingAlive = super.hit(force);
		if (!stayingAlive) {
			System.out.println("You slayed me, but my friends will avenge me!!!");
		}
		return stayingAlive;
	}
	
	// demo code fragments
	public void playground() {
		Troll tr = Troll.create(1000);
	}
}
