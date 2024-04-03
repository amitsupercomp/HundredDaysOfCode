package day50;

public class WordSearch {

	private static char[][] board;
	private static int rows;
	private static int cols;

	public static void main(String[] args) {
		char[][] board = {{'A', 'B', 'C', 'E'},{'S', 'F', 'C', 'S'},{'A', 'D', 'E', 'E'}};
		String word = "SEE";
		System.out.println("Output :: " + exist(board, word));
		System.out.println("Output :: " + exist1(board, word));
	}

	private static boolean exist(char[][] board, String word) {
		WordSearch.board = board;
		WordSearch.rows = board.length;
		WordSearch.cols = board[0].length;

		for (int row = 0; row < WordSearch.rows; ++row)
			for (int col = 0; col < WordSearch.cols; ++col)
				if (WordSearch.backtrack(row, col, word, 0))
					return true;
		return false;
	}
	private static boolean backtrack(int row, int col, String word, int index) {
		/* Step 1). check the bottom case. */
		if (index >= word.length())
			return true;

		/* Step 2). Check the boundaries. */
		if (row < 0 || row == WordSearch.rows || col < 0 || col == WordSearch.cols
				|| WordSearch.board[row][col] != word.charAt(index))
			return false;

		/* Step 3). explore the neighbors in DFS */
		boolean ret = false;
		// mark the path before the next exploration
		WordSearch.board[row][col] = '#';

		int[] rowOffsets = {0, 1, 0, -1};
		int[] colOffsets = {1, 0, -1, 0};
		for (int d = 0; d < 4; ++d) {
			ret = WordSearch.backtrack(row + rowOffsets[d], col + colOffsets[d], word, index + 1);
			if (ret)
				break;
		}

		/* Step 4). clean up and return the result. */
		WordSearch.board[row][col] = word.charAt(index);
		return ret;
	}

	private static boolean helper(char[][] arr, String word, int i, int j, int idx, int row, int col, int[][] visited) {
		if (i < 0 || j < 0 || i >= row || j >= col || visited[i][j] == 1)
			return false;
		if (word.charAt(idx) != arr[i][j])
			return false;
		if (idx == word.length() - 1)
			return true;

		visited[i][j] = 1;
		if (helper(arr, word, i, j + 1, idx + 1, row, col, visited) ||
				helper(arr, word, i + 1, j, idx + 1, row, col, visited) ||
				helper(arr, word, i - 1, j, idx + 1, row, col, visited) ||
				helper(arr, word, i, j - 1, idx + 1, row, col, visited))
			return true;

		visited[i][j] = 0;
		return false;
	}

	private static boolean exist1(char[][] board, String word) {
		int row = board.length;
		int col = board[0].length;
		int[][] visited = new int[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (helper(board, word, i, j, 0, row, col, visited))
					return true;
			}
		}
		return false;
	}


}
