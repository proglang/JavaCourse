package lecture20150615.visitor;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class EvalTest {
	
	
	IExpr e_noVar = new Product(new Const(4), new Add(new Const(42), new Const(8)));
	IExpr e_var = new Product(new Var("x"), new Add(new Const(42), new Var("y")));
	
	@Test
	public void noVar() {
		assertEquals(200, (int)e_noVar.accept(new Eval(null)));
	}
	
	@Test
	public void var() {
		Map<String, Integer> env = new HashMap<>();
		env.put("x", 4);
		env.put("y", 8);
		assertEquals(200, (int)e_var.accept(new Eval(env)));
		
		env.put("x", 5);
		env.put("y", 9);
		assertEquals(255, (int)e_var.accept(new Eval(env)));
		
	}

}
