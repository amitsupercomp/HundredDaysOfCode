package day30;
import java.util.*;

public class SubArrayWithSum {
	
	public static void main(String[] args) {
		int[] arr = {1,0,1,0,1};
		int goal = 2;
		System.out.println("Output :: " + numSubarraysWithSum(arr, goal));
	}
	
	private static int numSubarraysWithSum(int[] nums, int goal) {
        int totalCount = 0;
        int currSum = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int e : nums) {
            currSum += e;
            if(currSum == goal) {
                totalCount++;
            }

            if(map.containsKey(currSum - goal)) {
                totalCount += map.get(currSum - goal);
            }

            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }

        return totalCount;
    }

}
