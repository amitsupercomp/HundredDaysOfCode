package day40;
import java.util.*;

public class DuplicateNumber {
	
	public static void main(String[] args) {
		int[] nums = {1,3,4,2,2,3,3};
		System.out.println("Duplicate Number ::  " + findDuplicate(nums));
		System.out.println("Duplicate Number ::  " + findDuplicate1(nums));
		System.out.println("Duplicate Number ::  " + findDuplicate2(nums));
		System.out.println("Duplicate Number ::  " + findDuplicate3(nums));
	}

	private static int findDuplicate(int[] nums) {
		boolean[] present = new boolean[nums.length];
		for (int num : nums) {
			if (present[num])
				return num;
			present[num] = true;
		}
		return -1;
	}

	private static int findDuplicate1(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i]))
				return nums[i];
			else
				map.put(nums[i], 1);
		}
		return -1;
	}

	private static int findDuplicate2(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1])
				return nums[i];
		}
		return -1;
	}

	private static int findDuplicate3(int[] nums) {
		int dupl = nums[0], temp = 0;
		while (dupl != nums[dupl]) {
			temp = nums[dupl];
			nums[dupl] = dupl;
			dupl = temp;
		}
		return dupl;
	}
	
}
