package day24;

public class KthElementInTwoSortedArray {

	public static void main(String[] args) {
		
		int[] arr1 = {100, 112, 256, 349, 770};
		int[] arr2 = {72, 86, 113, 119, 265, 445, 892};
		
		int k = 7;
		
		System.out.println("Find By Optimal :: " + kthElementOptimal(arr1, arr2, arr1.length, arr2.length, k));
		
		System.out.println("Find by Extra Space technic :: " + kthElement(arr1, arr2, arr1.length, arr2.length, k));

	}

	private static int kthElementOptimal( int arr1[], int arr2[], int n, int m, int k) {

		int i = 0, j = 0, count = 0;
		while (i < n && j < m) {
			if (arr1[i] < arr2[j]) {
				count++;
				if (count == k)
					return arr1[i];
				i++;
			} else {
				count++;
				if (count == k)
					return arr2[j];
				j++;
			}
		}
		while (i < n) {
			count++;
			if (count == k)
				return arr1[i];
			i++;
		}

		while (j < m) {
			count++;
			if (count == k)
				return arr2[j];
			j++;
		}
		return -1;
	}

	private static int kthElement( int arr1[], int arr2[], int n, int m, int k) {
		int[] result = new int[n + m];
		int i = 0, j = 0, count = 0;

		while (i < n && j < m) {
			if (arr1[i] < arr2[j]) {
				result[count++] = arr1[i++];
			} else if (arr1[i] > arr2[j]) {
				result[count++] = arr2[j++];
			} else {
				result[count++] = arr1[i++];
				result[count++] = arr2[j++];
			}
		}
		if (i < n) {
			while (i < n) {
				result[count++] = arr1[i++]; 
			}
		}
		if (j < m) {
			while (j < m) {
				result[count++] = arr2[j++];
			}
		}

		return result[k - 1];
	}

}
