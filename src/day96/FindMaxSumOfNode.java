package day96;

public class FindMaxSumOfNode {
	
	public static void main(String[] args) {
		int k = 3;
		int[] nums = {1,2,1};
		int[][] edge = {{0,1}, {0,2}};
		System.out.println("Output :: " + maximumValueSum(nums, k, edge));
	}
	
	private static long maximumValueSum(int[] nums, int k, int[][] edges) {
        long totalSum = 0;
        int count = 0;
        int positiveMin = Integer.MAX_VALUE;
        int negativeMax = Integer.MIN_VALUE;

        for (int nodeValue : nums) {
            int nodeValAfterOperation = nodeValue ^ k;
            totalSum += nodeValue;
            int netChange = nodeValAfterOperation - nodeValue;

            if (netChange > 0) {
                positiveMin = Math.min(positiveMin, netChange);
                totalSum += netChange;
                count += 1;
            } else {
                negativeMax = Math.max(negativeMax, netChange);
            }
        }

        if (count % 2 == 0) {
            return totalSum;
        }
        return Math.max(totalSum - positiveMin, totalSum + negativeMax);
    }

}
