package lecture20150622;

public interface IScanner {
	/**
	 * Test if scanner is looking at pattern.
	 * @param pattern a regular expression
	 * @return true if input starts with pattern.
	 */
	boolean lookingAt(String pattern);
	/**
	 * If scanner is looking at pattern, return string matched by pattern and advance to next lexeme.
	 * Advancing ignores whitespace.
	 * @param pattern a regular expression
	 * @return matched string if input starts with pattern. Otherwise return null.
	 */
	String getLexeme(String pattern);
}
