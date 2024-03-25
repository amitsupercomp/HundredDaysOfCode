package day41;
import java.util.*;

public class FindAllDuplicates {
	
	public static void main(String[] args) {
		int[] arr = {4,3,2,7,8,2,3,1};
		System.out.println("Duplicates are :: " + findDuplicates(arr));
	}

	private static List<Integer> res;
	private static List<Integer> findDuplicates(int[] nums) {
		init(nums);
		return res;
	}

	private static void init(int[] nums) {
		if (res != null) return;
		res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int num = Math.abs(nums[i]);
			if (nums[num - 1] < 0) {
				res.add(num);
			} else {
				nums[num - 1] *= -1;
			}
		}
	}

}
