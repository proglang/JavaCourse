package lesson_06;

public enum Binop {
	PLUS ("+"),
	MINUS ("-"),
	TIMES ("*"),
	DIV ("/");
	private final String token;

	private Binop(String token) {
		this.token = token;
	}
	
	public static Binop fromToken(String token) {
		for (Binop op : Binop.values()) {
			if(op.token.equals(token)) {
				return op;
			}
		}
		return null;
	}
}
