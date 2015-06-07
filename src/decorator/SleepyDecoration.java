package decorator;

public class SleepyDecoration extends AMonsterDecoration {

	protected SleepyDecoration(AMonster monster) {
		super(monster);
	}

	@Override
	public String name() {
		return "sleepy " + super.name();
	}

	
}
