package day78;

public class ReversePrefWord {
	
	public static void main(String[] args) {
		String word = "abcdefd";
		char ch = 'd';
		System.out.println("Output :: " + reversePrefix(word, ch));
	}
	
	private static String reversePrefix(String word, char ch) {
        StringBuffer result = new StringBuffer();
        int i = 0;
        for (; i < word.length(); i++) {
            if (word.charAt(i) == ch)
                break;
        }
        if (i == word.length())
            return word;
        else {
            int j = i + 1;
            while (i >= 0) {
                result.append(word.charAt(i--));
            }
            result.append(word.substring(j));
        }
        return result.toString();
    }

}
