package lesson_06;

public interface EitherVisitor<A, B, R> {
	public R visitLeft(A left);
	public R visitRight(B right);
}
