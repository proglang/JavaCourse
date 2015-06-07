package decorator;

public class InvisibleDecoration extends AMonsterDecoration {

	protected InvisibleDecoration(AMonster monster) {
		super(monster);
	}

	@Override
	public String name() {
		return "invisible monster";
	}

}
