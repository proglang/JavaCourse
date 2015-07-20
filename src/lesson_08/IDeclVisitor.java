package lesson_08;

import java.util.List;

public interface IDeclVisitor {
	void visitVarDecl(VarDecl vd);
	void visitFunDecl(FunDecl fd);
	void visitDecls(Decls ds);
}
