package day7;

public class ReverseOnlyLetters {

	public static void main(String[] args) {
		String string = "Test1ng-Leet=code-Q!";
		System.out.println("Reverse is :: " + reverseOnlyLetters(string));
	}
	
	private static String reverseOnlyLetters(String s) {
        char[] result = new char[s.length()];
        int left = 0, right = s.length() -1;
        
        while (left < right) {
            if (s.charAt(left) < 65 || (s.charAt(left) >= 91 && s.charAt(left) <= 96)) {
                result[left] = s.charAt(left++);
                continue;
            }
            if (s.charAt(right) < 65 || (s.charAt(right) >= 91 && s.charAt(right) <= 96)) {
                result[right] = s.charAt(right--);
                continue;
            }
            if (((s.charAt(left) >= 65 && s.charAt(left) <= 90) || (s.charAt(left) >= 97 && s.charAt(left) <= 122)) && 
            ((s.charAt(right) >= 65 && s.charAt(right) <= 90) || (s.charAt(right) >= 97 && s.charAt(right) <= 122))) {
                result[left] = s.charAt(right);
                result[right] = s.charAt(left);
                right--;
                left++;
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] == '\u0000') {
                result[i] = s.charAt(left);
            }
        }
        return String.valueOf(result);
    }
}
