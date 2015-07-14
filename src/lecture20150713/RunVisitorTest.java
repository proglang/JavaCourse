package lecture20150713;

import static lecture20150615.visitor.Expressions.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import jdk.nashorn.internal.objects.annotations.Setter;

import org.junit.Before;
import org.junit.Test;

public class RunVisitorTest {
	private Map<String, Integer> state;
	private RunVisitor r;
	
	@Before
	public void setup() {
		state = new HashMap<String,Integer>();
		r = new RunVisitor(state);
	}

	@Test
	public void test() {
		IStmt ass1 = new Assign("x", cnst(1));
		ass1.accept(r);
		assertEquals(state.get("x"), new Integer(1));
	}

	@Test
	public void testIf() {
		IStmt iff = new If(cnst(1),
				new Assign("x", cnst(21)),
				new Assign("x", cnst(42)));
		iff.accept(r);
		assertEquals(state.get("x"), new Integer(21));
	}
	
	@Test
	public void testWhile() {
		IStmt whi = new While(var("x"), 
				new Assign("x", add(var("x"), cnst(-1))));
		state.put("x", 1000);
		whi.accept(r);
		assertEquals(state.get("x"), new Integer(0));
	}
	
	@Test
	public void testSequence0() {
		IStmt seq = new Sequence(Arrays.asList());
		seq.accept(r);
		assertEquals(0, state.size());
	}
	
	@Test
	public void testSequence1() {
		IStmt seq = new Sequence(Arrays.asList(
				new Assign("x", cnst(1)),
				new Assign("x", cnst(2))));
		seq.accept(r);
		assertEquals(new Integer(2), state.get("x"));
	}
	
	@Test
	public void testString() {
		assertFalse(new String("hello") == new String("hello"));
	}
}
