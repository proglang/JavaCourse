package lecture20150601;

import static org.junit.Assert.*;

import org.junit.Test;

public class IListIntTest {

	@Test
	public void test() {
		IListInt l1 = new ConsInt(1, new ConsInt(4, new ConsInt(9, new NilInt())));
	}
	
	@Test
	public void testLength() {
		assertEquals(0, new NilInt().length());
		IListInt l1 = new ConsInt(51, new NilInt());
		assertEquals(1, l1.length());
		IListInt l2 = new ConsInt(42, new ConsInt(51, new NilInt()));
		assertEquals(2, l2.length());
	}

	@Test
	public void testSum() {
		assertEquals(0, new NilInt().sum());
		IListInt l1 = new ConsInt(51, new NilInt());
		assertEquals(51, l1.sum());
		IListInt l2 = new ConsInt(42, new ConsInt(51, new NilInt()));
		assertEquals(93, l2.sum());
	}
	
	@Test
	public void testAppend() {
		IListInt other = new ConsInt(888, new NilInt());
		IListInt l1 = new NilInt();
		assertEquals(other, l1.append(other));
		IListInt l2 = new ConsInt(51, l1);
		assertEquals(
				new ConsInt(51, new ConsInt(888, new NilInt())),
				l2.append(other));
	}

}
