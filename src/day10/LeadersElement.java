package day10;

import java.util.*;
public class LeadersElement {

	public static void main(String[] args) {
		int[] arr = {16,17,4,3,5,2};
		int len = arr.length;
		System.out.println("Leader elements are :: " + leaders(arr, len));
	}

	private static ArrayList<Integer> leaders(int arr[], int n){

		ArrayList<Integer> result = new ArrayList<>();
		int big = arr[n - 1];
		result.add(big);

		for (int i = n - 2; i >= 0; i--) {
			if (big <= arr[i]) {
				big = arr[i];
				result.add(big);
			}
		}

		for (int i = 0, j = result.size() - 1; i < j; i++, j--) {
			int temp = result.get(i);
			result.set(i, result.get(j));
			result.set(j, temp);
		}

		return result;
	}

}
