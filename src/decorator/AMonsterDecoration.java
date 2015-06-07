package decorator;

public abstract class AMonsterDecoration extends AMonster {
	private final AMonster previous;
	
	protected AMonsterDecoration(AMonster monster) {
		this.previous = monster;
	}

	@Override
	public String name() {
		return previous.name();
	}
	@Override
	public boolean hit(int force, AMonster target) {
		return previous.hit(force, target);
	}

}
