package decorator;

public abstract class AMonster implements IMonster {
	
	public boolean hitOld(int force) {
		System.out.println("You hit the " + name() + "!");
		return true;
	}
	
	@Override
	public abstract String name();

	/////

	@Override
	public final boolean hit(int force) {
		return hit(force, this);
	}

	protected boolean hit(int force, AMonster target) {
		System.out.println("You hit the " + target.name() + "!");
		return true;
	}

}
