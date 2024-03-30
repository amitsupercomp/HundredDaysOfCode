package day46;
import java.util.*;

public class SubarrayWithKDiffInt {
	
	public static void main(String[] args) {
		int[] arr = {1,2,1,2,3};
		int k = 2;
		System.out.println("Total subArray is :: " + (subarraysWithKDistinct(arr, k) - subarraysWithKDistinct(arr, k - 1)));
	}

    private static int subarraysWithKDistinct(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, returnVal = 0, n = nums.length;

        while (right < n) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0)
                    map.remove(nums[left]);
                left++;
            }
            returnVal += right - left + 1;
            right++;
        }
        return returnVal;
    }

}
