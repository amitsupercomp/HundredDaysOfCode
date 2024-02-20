package day7;

public class ReverseWord {

	public static void main(String[] args) {
		
		String string = "Let's take LeetCode contest";
		
		//First Approach
		System.out.println("Reverse Word :: " + reverseWordsI(string));
		
		//Second Approach
		System.out.println("Reverse Word :: " + reverseWordII(string));
		
		//Third Approach
		System.out.println("Reverse Word :: " + reverseWordIII(string));
		
	}
	private static String reverseWordsI(String s) {

        char[] ch = s.toCharArray();
        int i = 0, j = 0, n = ch.length;
        int breakPoint = 0;
        while (i < n) {
            while (j < n && ch[j] != ' ')
                j++;
            breakPoint = j;
            j -= 1;
            while (j > i) {
                char c = ch[j];
                ch[j--] = ch[i];
                ch[i++] = c;
            }
            i = breakPoint + 1;
            j = breakPoint + 1;
        }
        return String.valueOf(ch);
	}
	
	private static String reverseWordII(String s) {
		
		 String[] string = s.split(" ");
         StringBuffer result = new StringBuffer();
         for(int i = 0; i < string.length; i++) {
             int k = string[i].length() - 1;
             while(k > -1) {
                 result.append(string[i].charAt(k--));
             }
             if (i != string.length - 1)
              result.append(" ");
         }
         return result.toString();
	}
	
	private static String reverseWordIII(String s) {
		StringBuilder result = new StringBuilder();
         int limit = s.length(); 
         for (int i = 0; i < limit; i++) {
             if (i == limit - 1 || s.charAt(i) == ' ') {
                 int k = i == limit - 1 ? limit - 1 : i - 1;
                 while (k > -1 && s.charAt(k) != ' ') {
                     result.append(s.charAt(k--));
                 }
                 if (s.charAt(i) == ' ')
                     result.append(" ");
             }
         }
         return result.toString();
	}
}
