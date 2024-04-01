package day48;

public class LengthOfLastWord {
	
	public static void main(String[] args) {
		String s = "Hello World   ";
		System.out.println("Length of last word :: " + lengthOfLastWord(s));
	}

	private static int lengthOfLastWord(String s) {
        int n = s.length() - 1;
        StringBuffer str = new StringBuffer();
        while (n >= 0) {
            if (s.charAt(n) == ' ' && str.toString().equals("")) {
                n--;
                continue;
            } else if (s.charAt(n) == ' ') {
                break;
            } else {
                str.append(s.charAt(n--));
            }
        }
        return str.length();
    }
	
}
