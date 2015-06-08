package lecture20150608;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

public class IListTest {

	@Test
	public void test() {
		IList<Integer> il = new Nil<Integer>();
		il = new Cons<>(32, il);
		il = new Cons<>(16, il);
		il = new Cons<>(8, il);
		/*
		System.out.println("[");
		for (Integer i : il) {
			System.out.println(i);
		}
		System.out.println("]");
		*/
		Iterator<Integer> iter = il.iterator();
		assertTrue(iter.hasNext());
		int i8 = iter.next();
		assertEquals(8, i8);
		assertTrue(iter.hasNext());
		int i16 = iter.next();
		assertEquals(16, i16);
		assertTrue(iter.hasNext());
		int i32 = iter.next();
		// iter.remove(); // raises UnsupportedOperationException
		assertEquals(32, i32);
		assertFalse(iter.hasNext());
	}

}
