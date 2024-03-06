package day22;

import java.util.Arrays;

public class RearrangeArrayAlternatively {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		rearrange(arr, arr.length);
	}
	
	private static void rearrange(int arr[], int n){
		int maxId = n - 1, minId = 0;
		int mx = arr[n - 1] + 1;
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				arr[i] += (arr[maxId] % mx) * mx;
				maxId--;
			}
			else {
				arr[i] += (arr[minId] % mx) * mx;
				minId++;
			}
		}
		for (int i = 0; i < n; i++)
			arr[i] = arr[i] / mx;
		System.out.println(Arrays.toString(arr));
	}

}
