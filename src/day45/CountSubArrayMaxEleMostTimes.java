package day45;

public class CountSubArrayMaxEleMostTimes {
	
	public static void main(String[] args) {
		int[] arr = {1,3,2,3,3};
		int k = 2;
		System.out.println("Output :: " + countSubarrays(arr, k));
	}
	
	private static long countSubarrays(int[] nums, int k) {
        int max = -999, n = nums.length;
        for (int i = 0, j = n - 1; i <= j; i++, j--) {
            if (max < nums[i])
                max = nums[i];
            if (max < nums[j])
                max = nums[j];
        }
        long res = 0l;
        int left = 0, windowEle = 0, right = 0;

        while (right < n) {
            if (nums[right] == max)
                windowEle++;
            while (k == windowEle) {
                if (nums[left] == max)
                    windowEle--;
                left++;
            }
            res += left;
            right++;
        }
        return res;
    }

}
