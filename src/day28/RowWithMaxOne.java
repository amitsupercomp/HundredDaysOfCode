package day28;

public class RowWithMaxOne {

	public static void main(String[] args) {
		int[][] arr = {{0, 1, 1, 1},
		           {0, 0, 1, 1},
		           {1, 1, 1, 1},
		           {0, 0, 0, 0}};
		
		int n = arr.length;
		int m = arr[0].length;
		System.out.println("Row (Index) with max One's :: " + rowWithMax1s(arr, n, m));
	}

	private static int rowWithMax1s(int arr[][], int n, int m) {
		// code here

		int max = 0, index = -1;

		for (int i = 0, count = 0; i < n; i++, count = 0) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1)
					count++;
			}
			if (count > max) {
				max = count;
				index = i;
			}
		}
		return index;
	}

}
