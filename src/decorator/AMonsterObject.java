package decorator;

public abstract class AMonsterObject extends AMonster {

	@Override
	protected boolean hit(int force, AMonster target) {
		System.out.println("You hit the " + target.name() + "!");
		return true;
	}

	@Override
	public abstract String name();

}
