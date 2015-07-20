package lesson_08;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import lecture20150615.visitor.Eval;
import lecture20150615.visitor.IExpr;
import lecture20150713.RunVisitor;

public class ExtRunVisitor extends RunVisitor implements ExtStmtVisitor {
	private final SymbolTable<String, Integer> symtab;
	private final Map<String,FunDecl> functions;

	public ExtRunVisitor(SymbolTable<String, Integer> state, Map<String,FunDecl> functions) {
		super(state);
		this.symtab = state;
		this.functions = functions;
	}

	@Override
	public void visitCall(Call cstm) {
		FunDecl fd = functions.get(cstm.name);
		Iterator<String> vars = fd.vars.iterator();
		Map<String,Integer> locals = new HashMap<String,Integer>();
		for(IExpr arg : cstm.args) {
			int value = arg.accept(new Eval(state));
			if(vars.hasNext()) {
				String var = vars.next();
				locals.put(var, value);
			}
		}
		while (vars.hasNext()) {
			locals.put(vars.next(), 0);
		}
		// push locals
		// System.out.println("locals = " + locals);
		symtab.enterScope(locals);
		fd.body.accept(this);
		// pop locals
		symtab.leaveScope();
	}

}
