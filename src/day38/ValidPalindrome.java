package day38;

public class ValidPalindrome {

	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		System.out.println("Is Palindrome :: " + isPalindrome(s));
		System.out.println("Is Palindrome :: " + isPalChk(s));

	}

	private static boolean isPalChk(String s) {
		s = s.toLowerCase();
		String check = "asdfghjklqwertyuiopzxcvbnm1234567890";
		StringBuilder newString = new StringBuilder("");
		for (int i = 0; i < s.length(); i++) {
			//if ((s.charAt(i) >= 97 && s.charAt(i) <= 122) || (s.charAt(i) >= 48 && s.charAt(i) <= 57))
			if (check.indexOf(s.charAt(i)) != -1)
				newString.append(s.charAt(i));
		}
		if(newString.toString().equals(newString.reverse().toString()))
			return true;
		return false;
	}

	private static boolean isPalindrome(String s) {
		char[] ch = s.toLowerCase().toCharArray();
		String check = "asdfghjklqwertyuiopzxcvbnm1234567890";
		int i = 0, j = ch.length - 1;
		while (i <= j) {
			if (check.indexOf(ch[i]) == -1) {
				i++;
				continue;
			}
			if (check.indexOf(ch[j]) == -1) {
				j--;
				continue;
			}
			if (ch[i] != ch[j])
				return false;
			i++;
			j--;
		}
		return true;
	}

}
