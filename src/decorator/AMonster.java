package decorator;

public abstract class AMonster implements IMonster {

	@Override
	public final boolean hit(int force) {
		return hit(force, this);
	}
	
	@Override
	public abstract String name();

	protected boolean hit(int force, AMonster target) {
		System.out.println("You hit the " + target.name() + "!");
		return true;
	}

}
