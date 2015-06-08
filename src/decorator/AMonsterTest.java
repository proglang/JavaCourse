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
		System.out.println(m.name());
		AMonster mc = new CursedDecoration(m);
		System.out.println(mc.name());
		AMonster d = new Dragon();
		System.out.println(d.name());
		AMonster dc = new CursedDecoration(d);
		System.out.println(dc.name());
		AMonster mi = new InvisibleDecoration(m);
		System.out.println(mi.name());
		AMonster mci = new InvisibleDecoration(mc);
		AMonster mic = new CursedDecoration(mi);
		System.out.println(mic.name());
	}

}
