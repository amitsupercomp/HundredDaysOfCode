package day66;

public class NumberOfIsland {

	public static void main(String[] args) {
		char[][] grid = {{'1','1','1','1','0'},
							{'1','1','0','1','0'},
							{'1','1','0','0','0'},
							{'0','0','0','0','0'}};
		System.out.println("Numbers of Island :: " + numIslands(grid));

	}

	private static int numIslands(char[][] grid) {
		int islands = 0;
		int rows = grid.length;
		int cols = grid[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == '1') {
					islands++;
					dfs(grid, i, j);
				}
			}
		}
		return islands;
	}

	private static void dfs(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
			return;
		}

		grid[i][j] = '0';
		dfs(grid, i+1, j);
		dfs(grid, i-1, j);
		dfs(grid, i, j+1);
		dfs(grid, i, j-1);
	}

}
