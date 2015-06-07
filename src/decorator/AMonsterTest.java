package decorator;

import static org.junit.Assert.*;

import org.junit.Test;

public class AMonsterTest {

	@Test
	public void testHit() {
		AMonster m = new Troll();
		m.hit(10);
		AMonster d = new Dragon();
		d.hit(10);
		m = new CursedDecoration(m);
		m.hit(10);
		m = new InvisibleDecoration(m);
		m.hit(10);
		m = new SleepyDecoration(m);
		m.hit(10);
	}

	@Test
	public void testName() {
		assertEquals("troll", "troll", new Troll().name());
		assertEquals("dragon", "dragon", new Dragon().name());
		AMonster m = new Troll();
		AMonster mc = new CursedDecoration(m);
		AMonster mi = new InvisibleDecoration(m);
		AMonster mci = new InvisibleDecoration(mc);
		AMonster mic = new CursedDecoration(mi);
	}

}
