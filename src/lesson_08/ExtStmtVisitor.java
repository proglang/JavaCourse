package lesson_08;

import lecture20150713.StmtVisitor;

public interface ExtStmtVisitor extends StmtVisitor {
	void visitCall(Call cstm);
}
