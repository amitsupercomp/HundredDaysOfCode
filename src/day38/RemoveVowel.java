package day38;

public class RemoveVowel {
	
	public static void main(String[] args) {
		String string = "leetcodeisacommunityforcoders";
		
		System.out.println("Output is :: " + removeVowels(string));
		System.out.println("Output is :: " + removeVowl(string));
	}
	
	private static String removeVowl(String s) {
		StringBuffer str = new StringBuffer("");

         for (int i = 0; i < s.length(); i++) {
             if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u')
                 continue;
             str.append(s.charAt(i));
         }
         return str.toString();
	}
	
	private static String removeVowels(String s) {
        
        StringBuffer res = new StringBuffer("");
        StringBuilder resB = new StringBuilder("");
        String str = "aeiou";
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (str.indexOf(s.charAt(i)) == -1) 
                res.append(s.charAt(i));
            if (str.indexOf(s.charAt(j)) == -1)
                resB.append(s.charAt(j));
            i++;
            j--;
        }
        if (s.length() % 2 == 1 && str.indexOf(s.charAt(j)) == -1)
            resB.append(s.charAt(j));
        res.append(resB.reverse());
        return res.toString();
    }

}
