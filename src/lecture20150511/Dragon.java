package lecture20150511;

public class Dragon extends AMonster {

	private Dragon(int hp) {
		super(hp);
	}
	
	public static Dragon create(int hp) {
		if (hp <= 0) {
			throw new IllegalArgumentException("unfit for live");
		}
		return new Dragon(hp);
	}
	
	public boolean hit(int force) {
		return false;
	}
	
	public void breatheFire() {
		System.out.println(">>>>>>>>>======-----");
	}
}
