package day31;

import java.util.Arrays;

public class ProductOfArrayItself {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		System.out.println("Output Array :: " + Arrays.toString(productExceptSelf(arr)));
	}

	private static int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		int[] res = new int[len];
		res[len - 1] = 1;
		res[len - 2] = nums[len - 1];
		for (int i = len - 3; i >= 0; i--) {
			res[i] = res[i + 1] * nums[i + 1];
		}

		for (int prodPre = 1, curr = 1; curr < len; curr++) {
			prodPre *= nums[curr - 1];
			res[curr] = res[curr] * prodPre;
		}
		return res;
	}
}
