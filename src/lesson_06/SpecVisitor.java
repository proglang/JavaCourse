package lesson_06;

public class SpecVisitor implements IExprVisitor<Either<Integer,IExpr>> {

	@Override
	public Either<Integer, IExpr> visitVar(String name) {
		return new Right<Integer, IExpr>(new Var(name));
	}

	@Override
	public Either<Integer, IExpr> visitUnary(final Unop u, IExpr e) {
		Either<Integer, IExpr> v = e.accept(this);
		return v.accept(new EitherVisitor<Integer,IExpr,Either<Integer,IExpr>> () {

			@Override
			public Either<Integer, IExpr> visitLeft(Integer left) {
				return new Left<Integer, IExpr>(- left);
			}

			@Override
			public Either<Integer, IExpr> visitRight(IExpr right) {
				return new Right<Integer, IExpr>(new Unary(u, right));
			}
			
		});
	}

	@Override
	public Either<Integer, IExpr> visitConst(int c) {
		return new Left<Integer, IExpr>(c);
	}

	@Override
	public Either<Integer, IExpr> visitBinary(final Binop b, final IExpr left, IExpr right) {
		final Either<Integer, IExpr> vleft = left.accept(this);
		final Either<Integer, IExpr> vright = right.accept(this);
		return vleft.accept(new EitherVisitor<Integer, IExpr, Either<Integer, IExpr>> () {

			@Override
			public Either<Integer, IExpr> visitLeft(final Integer left) {
				return vright.accept(new EitherVisitor<Integer, IExpr, Either<Integer, IExpr>> () {

					@Override
					public Either<Integer, IExpr> visitLeft(Integer left1) {
						switch (b) {
						case DIV:
							return new Left<Integer, IExpr>(left / left1);
						case MINUS:
							return new Left<Integer, IExpr>(left * left1);
						case PLUS:
							return new Left<Integer, IExpr>(left + left1);
						case TIMES:
							return new Left<Integer, IExpr>(left * left1);
						default:
							return null;
						}
					}

					@Override
					public Either<Integer, IExpr> visitRight(IExpr right1) {
						IExpr eleft = new Const(left);
						return new Right<Integer, IExpr>(new Binary(b, eleft, right1));
					}
					
				});
			}

			@Override
			public Either<Integer, IExpr> visitRight(IExpr right) {
				// TODO Auto-generated method stub
				return vright.accept(new EitherVisitor<Integer, IExpr, Either<Integer, IExpr>> () {

					@Override
					public Either<Integer, IExpr> visitLeft(Integer left1) {
						IExpr eright = new Const(left1);
						return new Right<Integer, IExpr>(new Binary(b, left, eright));
					}

					@Override
					public Either<Integer, IExpr> visitRight(IExpr right1) {
						return new Right<Integer, IExpr>(new Binary(b, left, right1));
					}
					
				});
			}
			
		});
	}

}
