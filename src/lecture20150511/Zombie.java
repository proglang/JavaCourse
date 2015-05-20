package lecture20150511;

public class Zombie extends AMonster {

	protected Zombie(int hp) {
		super(hp);
	}

	@Override
	public boolean hit(int force) {
		return true;
	}
	
	private static IWeapon magicAxe = new Axe(true);
	
	public boolean attack(IWeapon weapon) {
		// if attacked by magic axe, then die
		if (magicAxe.equals(weapon)) {
			super.hit(10000);
			System.out.println("Cursed mortal you killed me!");
			return false;
		}
		return true;
	}

}
