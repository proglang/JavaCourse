package lecture20150615.visitor;

/**
 * The type of arithmetic expressions (visitor style).
 * @author fennell
 *
 */
public interface IExpr {
	
	/**
	 * The accept method for an IExprVisitor.
	 */
	<T> T accept(IExprVisitor<T> v);
	
}
