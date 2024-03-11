package day27;
import java.util.*;

public class FindIndexSubArrGivenSum {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		int len = arr.length;
		int s = 15;
		
		System.out.println("Index :: " + subarraySum(arr, len, s));
	}
	
	private static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
	{
		// Your code here
		int cSum = 0, start = 0;
		ArrayList<Integer> res = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			cSum += arr[i];
			while (cSum > s && start < i) {
				cSum -= arr[start];
				start++;
			}
			if (cSum == s) {
				res.add(start + 1);
				res.add(i + 1);
				return res;
			}
		}
		res.add(-1);
		return res;
	}
}
