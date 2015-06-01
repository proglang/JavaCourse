package decorator;

public class SleepyDecoration extends AMonsterDecoration {

	protected SleepyDecoration(IMonsterInternal monster) {
		super(monster);
	}

	@Override
	public String name() {
		return "sleepy " + super.name();
	}

	
}
