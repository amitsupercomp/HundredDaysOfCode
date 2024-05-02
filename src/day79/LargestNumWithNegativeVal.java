package day79;
import java.util.*;

public class LargestNumWithNegativeVal {
	
	public static void main(String[] args) {
		int[] nums = {-1,2,-3,3};
		System.out.println("Output :: " + findMaxK(nums));
	}
	
	private static int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (nums[i] * (-1) == nums[j])
                return nums[j];
            else if (nums[i] * (-1) < nums[j])
                j--;
            else
                i++;
        }
        return -1;
    }

}
