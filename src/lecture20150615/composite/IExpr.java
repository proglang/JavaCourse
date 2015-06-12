package lecture20150615.composite;

/**
 * The type of arithmetic expressions (composite style).
 * 
 * @author fennell
 *
 */
public interface IExpr {

	/**
	 * Evaluate the expression to an integer
	 */
	public int eval();

	/**
	 * Calculate the size of an expression. The size is the number of operations
	 * and constants.
	 */
	public int size();

}
