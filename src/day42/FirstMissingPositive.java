package day42;

public class FirstMissingPositive {
	
	public static void main(String[] args) {
		int[] arr = {7,8,9,11,12,1,4};
		System.out.println("First missing number :: " + firstMissingPositive(arr));
	}
	
	private static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int index = -1;

        for (int i = 0; i < n; i++)
            if (nums[i] < 0)
                nums[i] = 0;

        for (int i = 0; i < n; i++) {
            index = Math.abs(nums[i]) - 1;
            if (index < 0 || index >= n)
                continue;
            if (nums[index] > 0)
                nums[index] *= -1;
            else if (nums[index] == 0) 
                nums[index] = Integer.MIN_VALUE + 1;
        }

        for (int i = 0; i < n; i++) 
            if (nums[i] >= 0)
                return i + 1;
        
        return n + 1;      

    }

}
