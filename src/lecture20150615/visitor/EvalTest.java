package lecture20150615.visitor;

import static org.junit.Assert.assertEquals;

import static lecture20150615.visitor.Expressions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class EvalTest {
	
	
	IExpr e_noVar = product(4, add(42, 8));
	IExpr e_var = product(var("x"), add(42, var("y")));
	
	@Test
	public void testNoVar() {
		assertEquals(200, (int)e_noVar.accept(new Eval(null)));
	}
	
	@Test
	public void testVar() {
		Map<String, Integer> env = new HashMap<>();
		env.put("x", 4);
		env.put("y", 8);
		assertEquals(200, (int)e_var.accept(new Eval(env)));
		
		env.put("x", 5);
		env.put("y", 9);
		assertEquals(255, (int)e_var.accept(new Eval(env)));
		
	}

}
