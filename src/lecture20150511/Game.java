package lecture20150511;

public class Game {
	public static void main (String[] arg) {
		Troll tr = Troll.create(1000);
		Dragon dr = Dragon.create(1000);
		IMonster m = tr;
		
		boolean survived = dr.hit(600);
		if (!survived) {
			System.out.println("The dragon dies");
		}
		survived = dr.hit(600);
		if (!survived) {
			System.out.println("Dragon dies on second attempt");
		}
		
		m = new Zombie(1000);
		survived = m.hit(10000);
		if (!survived) {
			System.out.println("try #1");
		}
		survived = m.attack(new Sword());
		if (!survived) {
			System.out.println("try #2");
		}
		survived = m.attack(new Axe(true));
		if (!survived) {
			System.out.println("try #3" );
		}
/*		
		m.hit(600);
		m = dr;
		m.hit(600);
		tr.hit(600);
		dr.hit(600);
		tr.hit(600);
		*/
	}
}
