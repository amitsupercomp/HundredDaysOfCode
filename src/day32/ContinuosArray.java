package day32;

import java.util.*;

public class ContinuosArray {
	public static void main(String[] args) {
		int[] arr = {0,1,0,1,0,1,1,1,0,0};
		System.out.println("Size of Longest Continuous Array :: " + findMaxLength(arr));
	}

	private static int findMaxLength(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int max = 0, count = 0;
		for (int i = 0; i < nums.length; i++) {
			count += (nums[i] == 1 ? 1 : -1);
			if (map.containsKey(count))
				max = Math.max(max, i - map.get(count));
			else
				map.put(count, i);
		}
		return max;
	}
}
