package day45;

public class LongestSubstringDistinct {
	
	public static void main(String[] args) {
		String str = "eceba";
		int k = 2;
		System.out.println("Length of Longest K Distinct character :: " + lengthOfLongestSubstringKDistinct(str, k));
	}
	
	private static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int num = 0, i = 0, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)]++ == 0) num++;
            if (num > k) {
                while (--count[s.charAt(i++)] > 0);
                num--;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;

    }

}
