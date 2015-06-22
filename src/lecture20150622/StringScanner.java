package lecture20150622;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringScanner implements IScanner {
	private String input;

	public StringScanner(String input) {
		this.input = input.trim();
	}

	@Override
	public boolean lookingAt(String regexp) {
		Matcher m = Pattern.compile(regexp).matcher(input);
		return m.lookingAt();
	}

	@Override
	public String getLexeme(String regexp) {
		Matcher m = Pattern.compile(regexp).matcher(input);
		String r = null;
		if (m.lookingAt()) {
			r = input.substring(0, m.end());
			input = input.substring(m.end()).trim();
		}
		return r;
	}

}
