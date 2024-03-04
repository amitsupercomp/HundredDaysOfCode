package day20;

import java.util.Arrays;

public class DutchNationalFlag {

	public static void main(String[] args) {
		
		int[] arr = {0,0,0,0,1,1,1,2,2,2,1,1,2,2,0,0,0,1,0,1};
		int mid = 0, low = 0, high = arr.length - 1;
		System.out.println("Before Sorting :: " + Arrays.toString(arr));
		while (mid <= high) {
			if (arr[mid] == 0) {
				int temp = arr[mid];
				arr[mid] = arr[low];
				arr[low] = temp;
				mid++;
				low++;
			} else if (arr[mid] == 2) {
				int temp = arr[mid];
				arr[mid] = arr[high];
				arr[high] = temp;
				high--;
			} else {
				mid++;
			}
		}
		System.out.println(Arrays.toString(arr));

	}

}