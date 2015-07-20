package lesson_08;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import lecture20150615.visitor.IExpr;

public class DeclCollector implements IDeclVisitor {
	public final SymbolTable<String,Integer> st;
	public final Map<String,FunDecl> functions; 
	private final String main_function;

	public DeclCollector(String main_function) {
		this.main_function = main_function;
		this.st = new SymbolTable<String,Integer>();
		this.functions = new HashMap<String,FunDecl>();
	}

	@Override
	public void visitVarDecl(VarDecl vd) {
		for (String var : vd.vars) {
			st.put(var, 0);
		}
	}

	@Override
	public void visitFunDecl(FunDecl fd) {
		functions.put(fd.name, fd);
	}

	@Override
	public void visitDecls(Decls ds) {
		for(IDecl d : ds.ds) {
			d.accept(this);
		}
		// System.out.println("visitDecls:\n" + "st = " + st.entrySet() + "\n" + "ft = " + functions);
		new Call(main_function, new LinkedList<IExpr>()).accept(new ExtRunVisitor(st, functions));
	}

}
