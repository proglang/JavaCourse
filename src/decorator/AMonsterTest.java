package decorator;

import static org.junit.Assert.*;

import org.junit.Test;

public class AMonsterTest {

	@Test
	public void testHit() {
		IMonsterInternal m = new Troll();
		m.hit(10);
		IMonsterInternal d = new Dragon();
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
		assertEquals("Troll", "Troll", new Troll().name());
		assertEquals("Dragon", "Dragon", new Dragon().name());
		IMonsterInternal m = new Troll();
		IMonsterInternal mc = new CursedDecoration(m);
		IMonsterInternal mi = new InvisibleDecoration(m);
		IMonsterInternal mci = new InvisibleDecoration(mc);
		IMonsterInternal mic = new CursedDecoration(mi);
	}

}
