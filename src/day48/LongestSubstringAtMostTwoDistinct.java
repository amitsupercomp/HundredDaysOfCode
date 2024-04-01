package day48;
import java.util.*;

public class LongestSubstringAtMostTwoDistinct {
	
	public static void main(String[] args) {
		String s = "ccaabbb";
		System.out.println("Longest Substring :: " + lengthOfLongestSubstringTwoDistinct(s));
		System.out.println("Longest Substring :: " + lengthOfLongestSubstringTwoDistinct1(s));
	}

	private static int lengthOfLongestSubstringTwoDistinct(String s) {
		int n = s.length();
		if (n == 0)
			return 0;
		int left = 0, right = 0;
		int maxLen = 1;
		Map<Character, Integer> map = new LinkedHashMap<>();
		Character c = '1';
		while (right < n) {
			c = s.charAt(right);
			if (map.containsKey(c))
				map.remove(c);
			map.put(c, right++);
			if (map.size() > 2) {
				Map.Entry<Character, Integer> lside = map.entrySet().iterator().next();
				map.remove(lside.getKey());
				left = lside.getValue() + 1;
			}
			maxLen = Math.max(maxLen, right - left);
		}
		return maxLen;
	}

	private static int lengthOfLongestSubstringTwoDistinct1(String s) {

		final int n = s.length();
		if (n <= 2)  return n;
		int left = 0;
		int right = 0;
		int distinctCount = 0;
		int maxLen = 0;
		int[] counts = new int[128];

		while (right < n) {
			if (counts[s.charAt(right++)]++ == 0) {
				if (++distinctCount > 2) {
					maxLen = Math.max(maxLen, right - left - 1);
					while (--counts[s.charAt(left++)] != 0)  { }
					distinctCount--;
				}
			}
		}

		return Math.max(maxLen, n - left);
	}


}
