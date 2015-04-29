package lesson_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserBase {

	/**
	 * input buffer. invariant: never starts with whitespace
	 */
	private String inp;

	public ParserBase(String inp) {
		this.inp = inp.trim();
	}

	/**
	 * Checks the next lexeme in the input. Consumes no input.
	 * @param regexp a string that specifies the syntax of the lexeme
	 * @return true if next lexeme in input matches regexp
	 */
	public boolean hasNext(String regexp) {
		Matcher m = Pattern.compile(regexp).matcher(inp);
		return m.lookingAt();
	}

	/**
	 * Consume the next lexeme of the input if it matches regexp.
	 * @param regexp a string that specifies the syntax of the lexeme
	 * @return the next lexeme if it matches regexp. Null, otherwise.
	 */
	protected String nextToken(String regexp) {
		Matcher m = Pattern.compile(regexp).matcher(inp);
		String r = null;
		if (m.lookingAt()) {
			r = inp.substring(0, m.end());
			inp = inp.substring(m.end()).trim();
		}
		return r;
	}

}