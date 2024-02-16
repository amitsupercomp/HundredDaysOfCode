package day3;

public class FindMaxAvg {

	public static void main(String[] args) {
		int[] arr = {1,12,-5,-6,50,3};
		System.out.println("Output :: " + findMaxAverage(arr, 4));
	}
	
	private static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        
        int maxSum = sum;
        
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            maxSum = Math.max(sum, maxSum);
        }
        
        double result = (double) maxSum / k;
        
        return result;
    }
}
