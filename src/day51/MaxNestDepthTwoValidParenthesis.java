package day51;

import java.util.Arrays;

public class MaxNestDepthTwoValidParenthesis {
	
	public static void main(String[] args) {
		String seq = "()(())()";
		System.out.println("Answer is :: " + Arrays.toString(maxDepthAfterSplit(seq)));
	}
	
	private static int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] res = new int[n];
        int par = -1;
        
        for (int i = 0; i < n; i++) {
            if (seq.charAt(i) == '(') {
                par++;
                res[i] = par % 2;
            } else {
                res[i] = par % 2;
                par--;
            }
        }
        return res;
    }

}
