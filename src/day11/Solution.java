package day11;

public class Solution {
	
	public static void main(String[] args) {
		long[] arr =  {1,3,5,2,2};
		
		int n = arr.length;
		
		System.out.println("Equilibirum point is :: " + equilibriumPoint(arr, n));
	}

	private static int equilibriumPoint(long arr[], int n) {

		// Your code here
		long sum = 0;
		long totalSum = 0;
		for (int i = 0; i < arr.length; i++) {
			totalSum += arr[i];
		}

		for (int i = 0; i < arr.length; i++) {
			if(sum == (totalSum - sum - arr[i]))
				return i + 1;
			sum += arr[i];
		}
		return -1;
	}

}
