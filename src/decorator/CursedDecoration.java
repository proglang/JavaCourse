package decorator;

public class CursedDecoration extends AMonsterDecoration {

	protected CursedDecoration(AMonster monster) {
		super(monster);
	}

	@Override
	public String name() {
		return "cursed " + super.name();
	}
	

}
