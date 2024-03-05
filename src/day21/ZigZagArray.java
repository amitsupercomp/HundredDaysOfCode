package day21;

import java.util.Arrays;

public class ZigZagArray {
	
	public static void main(String[] args) {
		int[] arr = {4, 3, 7, 8, 6, 2, 1};
		System.out.println("Actual array is :: " + Arrays.toString(arr));
		System.out.println("Array after ZigZag :: " + Arrays.toString(zigZag(arr)));
	}
	
	private static int[] zigZag(int[] arr) {
		boolean flag = true;
		
		for (int i = 0; i < arr.length - 1; i++) {
			
			if(flag) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			} else {
					if (arr[i] < arr[i + 1]) {
						int temp = arr[i];
						arr[i] = arr[i + 1];
						arr[i + 1] = temp;
					}
				}
				flag = !flag;
			}
		return arr;
	}
	

}
