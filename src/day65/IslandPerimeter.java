package day65;

public class IslandPerimeter {
	
	public static void main(String[] args) {
		int[][] grid = {{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}};
		System.out.println("Island Perimeter :: " + islandPerimeter(grid));
	}

	private static int islandPerimeter(int[][] grid) {        
		int result = 0;
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				if (grid[r][c] == 1) {
					result += 4;

					if (r > 0 && grid[r-1][c] == 1) {
						result -= 2;
					}

					if (c > 0 && grid[r][c-1] == 1) {
						result -= 2;
					}
				}
			}
		}
		return result;
	}

}
