package day8;

import java.util.Arrays;

public class MoveZero {

	public static void main(String[] args) {
		int[] nums = {0,1,0,3,12};
		System.out.println("Result is :: " + Arrays.toString(moveZeroes(nums)));
	}
	
	private static int[] moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        
        while (j < nums.length) {
            nums[j++] = 0;
        }
        return nums;
    }
}
