package day3;

public class MinValueToGetPosStepByStep {
	
	public static void main(String[] args) {
		int[] arr = {-3,2,-3,4,2};
		System.out.println("Output :: " + minStartValue(arr));
	}

	
	//Main Logics written in this method
	 private static int minStartValue(int[] nums) {
	        int startValue = 1;
	        int sum = startValue + nums[0];
	        for (int i = 1; i <= nums.length; i++) {
	            if (sum < 1) {
	            	//Actual logic apply here
	            	//increment sum and startValue till sum will be equal to 1
	                while (sum < 1) {
	                    sum++;
	                    startValue++;
	                }
	            }
	            if (i == nums.length)
	                    break;
	            sum = sum + nums[i];
	        }
	        return startValue;
	    }
}
