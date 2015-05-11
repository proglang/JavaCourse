package lecture20150511;

public abstract class AMonster implements IMonster {
	
	protected int hp;

	protected AMonster(int hp) {
		this.hp = hp;
	}

	@Override
	public abstract boolean hit(int force);

}
