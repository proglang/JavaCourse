package decorator;

public abstract class AMonster implements IMonster {

	@Override
	public final boolean hit(int force) {
		return hit(force, this);
	}
	
	protected abstract boolean hit(int force, AMonster entry);

	@Override
	public abstract String name();

}
