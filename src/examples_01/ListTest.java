package examples_01;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void testList() {
		List<Integer> il = new LinkedList<Integer>();
		assertEquals(0, il.size());
		il.add(1);
		assertEquals(1, il.size());
		il.add(4);
		assertEquals(2, il.size());
		il.add(9);
		assertEquals(3, il.size());
		assertEquals((int)1, (int)il.get(0));
		assertEquals((int)4, (int)il.get(1));
		assertEquals((int)9, (int)il.get(2));
	}

}
