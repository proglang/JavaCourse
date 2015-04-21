package lesson_06;

public interface Either<A, B> {
	public <R> R accept(EitherVisitor<A, B, R> visitor);

}
