package lesson_06;

public class Left<A,B> implements Either<A, B> {
	private A leftVal;

	public Left(A leftVal) {
		this.leftVal = leftVal;
	}

	@Override
	public <R> R accept(EitherVisitor<A, B, R> visitor) {
		return visitor.visitLeft(leftVal);
	}


}
