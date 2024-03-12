package day28;

public class RowWithMinimumOne {
	
	public static void main(String[] args) {
		int[][] arr = {{0, 1, 1, 1},
		           {0, 0, 1, 1},
		           {1, 1, 1, 1},
		           {0, 0, 0, 0}};
		int n = arr.length;
		int m = arr[0].length;
		
		System.out.println("Row with minimum 1's :: " + minRow(n, m, arr));
	}
	
	private static int minRow(int N, int M, int A[][]) {
        // code here
        int min = Integer.MAX_VALUE, index = -1;
        
        for (int i = 0, count = 0; i < N; i++, count = 0) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == 1)
                    count++;
            }
            if (count < min) {
                min = count;
                index = i + 1;
            }
        }
        return index;
    }

}
