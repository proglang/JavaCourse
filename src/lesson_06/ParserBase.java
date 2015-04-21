package lesson_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserBase {

	private String inp;

	public ParserBase(String inp) {
		this.inp = inp.trim();
	}

	public boolean hasNext(String pattern) {
		Matcher m = Pattern.compile(pattern).matcher(inp);
		return m.lookingAt();
	}

	protected String nextToken(String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(inp);
		String r = null;
		if (m.lookingAt()) {
			r = inp.substring(0, m.end());
			inp = inp.substring(m.end()).trim();
		}
		// System.out.println("nextToken(\"" + pattern + "\") returns: " + r);
		return r;
	}

}