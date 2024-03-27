package day43;

public class SubArrayProduct {
	
	public static void main(String[] args) {
		int[] arr = {10,5,2,6};
		int k = 100;
		System.out.println("Output :: " + numSubarrayProductLessThanK(arr, k));
		
		/*Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.*/
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
