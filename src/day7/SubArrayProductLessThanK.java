package day7;

public class SubArrayProductLessThanK {

	public static void main(String[] args) {
		
		int[] nums = {10,5,2,6};
		int k = 100;
		System.out.println("No of Sub-Array :: " + numSubarrayProductLessThanK(nums, k));
	}
	
	
	private static int numSubarrayProductLessThanK(int[] nums, int k) {
		if (k <= 1) {
			return 0;
		}
		int left = 0, right = 0, curr = 1;
		int ans = 0;
		for (; right < nums.length; right++) {
			curr *= nums[right];

			while (curr >= k) {
				curr /= nums[left];
				left++; 
			}
			ans += right - left + 1;
		}
		return ans;
	}

}
