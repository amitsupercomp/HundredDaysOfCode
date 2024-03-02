package day18;

public class LongestSubstringWithoutRepChar {

	public static void main(String[] args) {
		String str = "pwwkewdfgh";
		System.out.println("Length of longest substring :: " + lengthOfLongestSubstring(str));
	}

	private static int lengthOfLongestSubstring(String s) 
	{
		int right = 0, left = 0;
		int res = 0;
		Integer[] chars = new Integer[128];

		while (right < s.length()) {
			char r = s.charAt(right);
			Integer index = chars[r];
			if (index != null && index >= left && index < right)
				left = index + 1;
			res = Math.max(res, right - left + 1);
			chars[r] = right;
			right++;
		}
		return res;
	}

}
