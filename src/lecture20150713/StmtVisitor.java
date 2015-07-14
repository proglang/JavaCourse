package lecture20150713;

public interface StmtVisitor {
	void visitAssign(Assign s);
	void visitIf(If s);
	void visitSequence(Sequence s);
	void visitWhile(While s);
}
