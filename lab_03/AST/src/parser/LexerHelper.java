package parser;

public class LexerHelper {
	
	public static int lexemeToInt(String str) {
		try {
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}

	public static double lexemeToReal(String str) {
		try {
			return Double.parseDouble(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}

	public static char lexemeToChar(String str) {
		if(str.length() == 3){
			return str.charAt(1);
		}
		else if (str.equals("'\\n'")) {
			return '\n';
		}
		else if (str.equals("'\\t'")) {
			return '\t';
		}
		else {
			try {
				int asciiValue = Integer.parseInt(str.substring(2, str.length() - 1));
				return (char) asciiValue;
			} catch (NumberFormatException e) {
				System.out.println(e);
				return (char) -1;
			}
		}
	}

	// TODO: Implement the lexemeToChar and lexemeToReal methods
	
}
