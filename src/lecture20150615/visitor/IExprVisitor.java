package lecture20150615.visitor;

/**
 * The visitor interface for arithmetic expressions that consist of constants,
 * addition, multiplication, and variables.
 * 
 * @author fennell
 */
public interface IExprVisitor<T> {

	T visitConst(Const c);

	T visitAdd(Add a);

	T visitProduct(Product p);

	T visitVar(Var name);

}
