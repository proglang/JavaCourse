package lesson_08;

import static org.junit.Assert.*;

import java.util.Arrays;

import static lecture20150713.Statements.*;
import static lecture20150615.visitor.Expressions.*;

import org.junit.Test;

public class ExtRunVisitorTest {
	VarDecl vd1 = new VarDecl(Arrays.asList("x", "y", "z"));
	FunDecl fd1 = new FunDecl("xinc", Arrays.asList("a"), assign("x", add(var("x"), var("a"))));
	FunDecl fdm = new FunDecl("main", Arrays.asList(), seq(
			assign("x", cnst(13)), 
			new Call("xinc", Arrays.asList(cnst(33)))));

	@Test
	public void test1() {
		IDecl prog = new Decls(vd1, fd1, fdm);
		DeclCollector dc = new DeclCollector("main");
		prog.accept(dc);
		SymbolTable<String,Integer> st = dc.st;
		assertEquals(new Integer(46), st.get("x"));
	}

	FunDecl fib = new FunDecl("fib", Arrays.asList("n","t"),
			if_st(var("n"),
					seq(new Call("fib", Arrays.asList(add(var("n"), cnst(-1)))),
							assign("t",var("x")),
							assign("x", add(var("x"), var("y"))),
							assign("y", var("t"))),
					seq(assign("x", cnst(0)), assign("y", cnst(1)))))
					;
	FunDecl fim = new FunDecl("main", Arrays.asList(), new Call("fib", Arrays.asList(cnst(9))));
	
	@Test
	public void test2() {
		IDecl prog = new Decls(vd1, fib, fim);
		DeclCollector dc = new DeclCollector("main");
		prog.accept(dc);
		SymbolTable<String, Integer> st = dc.st;
		assertEquals(new Integer(34), st.get("x"));
	}
}
