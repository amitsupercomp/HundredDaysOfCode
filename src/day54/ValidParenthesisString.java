package day54;

public class ValidParenthesisString {
	
	public static void main(String[] args) {
		String s = "(*))";
		System.out.println("Output :: " + checkValidString(s));
	}

	private static boolean checkValidString(String s) {

		int openPare = 0, closePare = 0;
		for (char ch : s.toCharArray()) {
			openPare += ch == '(' ? 1 : -1;
			closePare += ch == ')' ? -1 : 1;

			if (closePare < 0)
				break;
			openPare = Math.max(openPare, 0);
		}

		return openPare == 0;

	}

}
