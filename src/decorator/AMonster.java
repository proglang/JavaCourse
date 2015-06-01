package decorator;

public abstract class AMonster implements IMonsterInternal {

	@Override
	public boolean hit(int force, IMonster target) {
		System.out.println("You hit the " + target.name() + "!");
		return true;
	}

	@Override
	public boolean hit(int force) {
		return hit(force, this);
	}

	@Override
	public abstract String name();

}
