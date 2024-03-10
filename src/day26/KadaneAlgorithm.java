package day26;

public class KadaneAlgorithm {

	public static void main(String[] args) {
		int[] arr = {1,2,3,-2,5};
		System.out.println("Output :: " + maxSubarraySum(arr, arr.length));
	}

	private static long maxSubarraySum(int arr[], int n){
		
		long totalSum = 0;
		long max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			totalSum += arr[i];
			max = Math.max(max, totalSum);
			if (totalSum < 0) 
				totalSum = 0;
		}
		return max;
	}
}
