package lecture20150511;

public class Game {
	public static void main (String[] arg) {
		Troll tr = Troll.create(1000);
		Dragon dr = Dragon.create(1000);
		IMonster m = tr;
		m.hit(600);
		m = dr;
		m.hit(600);
		tr.hit(600);
		dr.hit(600);
		tr.hit(600);
	}
}
