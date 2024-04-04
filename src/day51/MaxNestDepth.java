package day51;

public class MaxNestDepth {
	
	public static void main(String[] args) {
		String  s = "(1+(2*3)+((8)/4))+1";
		System.out.println("Answer is :: " + maxDepth(s));
	}
	
	private static int maxDepth(String s) {
        int par = 0;
        if (s.length() == 0)
            return par;
        int maxPar = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                par++;
            else if (s.charAt(i) == ')')
                par--;
            if (maxPar < par)
                maxPar = par;
        }
        return maxPar;
    }

}
