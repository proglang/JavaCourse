package decorator;

public abstract class AMonsterDecoration implements IMonsterInternal {
	private final IMonsterInternal monster;
	
	protected AMonsterDecoration(IMonsterInternal monster) {
		this.monster = monster;
	}

	@Override
	public boolean hit(int force) {
		return monster.hit(force, this);
	}

	@Override
	public String name() {
		return monster.name();
	}
	@Override
	public boolean hit(int force, IMonster target) {
		return monster.hit(force, target);
	}

}
