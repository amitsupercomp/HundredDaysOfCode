package day6;

import java.util.Arrays;

public class ThreeSum {

	public static void main(String[] args) {
		int[] arr = {-1, 2, 1, -4};
		int target = 1;
		System.out.println("The closest sum :: " + threeSumClosest(arr, target));
	}
	private static int threeSumClosest(int[] nums, int target) {
		int min = Integer.MAX_VALUE;
		int result = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				int diff = Math.abs(sum - target);
				if(diff == 0) return sum;
				if (diff < min) {
					min = diff;
					result = sum;
				}
				if (sum <= target) {
					j++;
				} else {
					k--;
				}
			}
		}
		return result;
	}
}
