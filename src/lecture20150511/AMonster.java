package lecture20150511;

public abstract class AMonster implements IMonster {
	
	private int hp;

	protected AMonster(int hp) {
		this.hp = hp;
	}

	@Override
	public boolean hit(int force) {
		this.hp -= force;
		boolean stayingAlive = this.hp > 0;
		return stayingAlive;
	}

	public boolean attack(IWeapon weapon) {
		return true;
	}
}
