package day47;

public class CountSubArrayWithFixBound {
	
	public static void main(String[] args) {
		int[] arr = {1,3,5,2,7,5};
		int mink = 1, maxk = 5;
		System.out.println("Total sub Array is :: " + countSubarrays1(arr, mink, maxk));
		System.out.println("Total sub Array is :: " + countSubarrays2(arr, mink, maxk));
	}
	
	//Time Complexity - 8ms
	private static long countSubarrays1(int[] nums, int minK, int maxK) {
        long res = 0;
        int left = -1, right = -1, index = -1, n = nums.length;
        for (int i = 0;  i < n; i++) {
            if (!(minK <= nums[i] && nums[i] <= maxK)) {
                index = i;
            }

            if (nums[i] == minK) {
                left = i;
            }
            if (nums[i] == maxK) {
                right = i;
            }
            res += Math.max(0, Math.min(left, right) - index);
        }
        return res;   
    }
	
	private static long countSubarrays2(int[] nums, int minK, int maxK) {
		 int min = -1, max = -1, left = -1, right = 0, n = nums.length;
         long res = 0;
         while(right < n){
             if(nums[right] < minK || nums[right] > maxK){
                 min = right;
                 max = right;
                 left = right;
             }
             min = nums[right] == minK ? right : min;
             max = nums[right] == maxK ?  right : max;
             res += Math.min(min, max) - left;
             right++;
         }
         return res;
	}

}
