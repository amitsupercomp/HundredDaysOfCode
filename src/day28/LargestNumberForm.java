package day28;

import java.util.Arrays;

public class LargestNumberForm {

	public static void main(String[] args) {
		String[] arr = {"3", "30", "34", "5", "9"};
		int len = arr.length;
		
		System.out.println("Largest Number is :: " + printLargest(len, arr));
	}

	private static String printLargest(int n, String[] arr) {
		// code here

		StringBuffer str = new StringBuffer();

		Arrays.sort(arr, (a, b) -> (a + b).compareTo(b + a));

		for (int i = n - 1; i >= 0; i--) {
			str.append(arr[i]);
		}

		return str.toString();
	}
}
