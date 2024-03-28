package day44;
import java.util.*;

public class LengthOfLongestSubArray {
	
	public static void main(String[] args) {
		int[] arr = {1,2,1,2,1,2,1,2};
		int k = 2;
		System.out.println("Maximum Length :: " + maxSubarrayLength1(arr, k));
		System.out.println("Maximum Length :: " + maxSubArrayLength2(arr, k));
	}

	//It will take 66 ms time and memory efficient
	private static int maxSubarrayLength1(int[] nums, int k) {
		int res = 0, n = nums.length;
		Map<Integer, Integer> map = new HashMap<>();

		for (int left = 0, right = 0; right < n; right++) {
			map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
			while (map.get(nums[right]) > k) {
				map.put(nums[left], map.get(nums[left]) - 1);
				left++;
			}
			res = Math.max(res, right - left + 1);
		}
		return res;
	}

	//It will take 26 ms time
	private static int maxSubArrayLength2(int[] nums, int k) {

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int num : nums) {
			min = Math.min(min, num);
			max = Math.max(max, num);
		}

		int[] frequencies = new int[max - min + 1];

		int left = 0;

		int maxWindow = 0;

		for (int right = 0; right < nums.length; right++) {
			frequencies[nums[right] - min]++;

			while (frequencies[nums[right] - min] > k) {
				frequencies[nums[left] - min]--;
				left++;
			}

			maxWindow = Math.max(maxWindow, right - left + 1);
		}

		return maxWindow;

	}

}
