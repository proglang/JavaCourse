package decorator;

public class InvisibleDecoration extends AMonsterDecoration {

	protected InvisibleDecoration(IMonsterInternal monster) {
		super(monster);
	}

	@Override
	public String name() {
		return "invisible monster";
	}

}
