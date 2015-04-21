package lesson_06;

public class Right<A, B> implements Either<A, B> {
	private B rightVal;

	public Right(B rightVal) {
		this.rightVal = rightVal;
	}

	@Override
	public <R> R accept(EitherVisitor<A, B, R> visitor) {
		return visitor.visitRight(rightVal);
	}
}
