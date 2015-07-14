package lecture20150713;

import java.util.Map;

import lecture20150615.visitor.*;

/**
 * Execution of While programs.
 * 
 * @author thiemann
 *
 */
public class RunVisitor implements StmtVisitor {
	/**
	 * Store that contains the values of the variables
	 */
	public final Map<String,Integer> state;

	public RunVisitor(Map<String, Integer> state) {
		this.state = state;
	}

	@Override
	public void visitAssign(Assign s) {
		int value = s.exp.accept(new Eval(state));
		state.put(s.var, value);
	}

	@Override
	public void visitIf(If s) {
		int value = s.condition.accept(new Eval(state));
		if (value != 0) {
			s.trueBranch.accept(this);
		} else {
			s.falseBranch.accept(this);
		}
	}

	@Override
	public void visitSequence(Sequence s) {
		for(IStmt stmt : s.stmts) {
			stmt.accept(this);
		}
	}

	@Override
	public void visitWhile(While s) {
		while( s.condition.accept(new Eval(state)) != 0) {
			s.body.accept(this);
		}
	}

}
