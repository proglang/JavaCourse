package lesson_02;

public enum PriceLevel {
	LEVEL_1(1), LEVEL_2(2), LEVEL_3(3);
	
	private final int level;

	public int getLevel() {
		return level;
	}

	private PriceLevel(int level) {
		this.level = level;
	}

}
