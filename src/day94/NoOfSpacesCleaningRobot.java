package day94;

public class NoOfSpacesCleaningRobot {
	
	private static int m, n, r, c, d = 1;
	private static int[][] dirs = new int[][] { {}, {0,1}, {1,0}, {0,-1}, {-1,0}  };
    
	public static void main(String[] args) {
		int[][] grid = {{0,1,0}, {1,0,0}, {0,0,0}};
		System.out.println("Output :: " + numberOfCleanRooms(grid));
	}
	
	private static int numberOfCleanRooms(int[][] room) {
		NoOfSpacesCleaningRobot.m = room.length;
		NoOfSpacesCleaningRobot.n = room[0].length;
        int[][] visited = new int[m][n];
        
        int count = 0;
        while (true) {
            if (isOutOfBounds() || room[r][c] == 1) {
                turnRight();
                continue;
            }
            
            if (visited[r][c] == d) return count;

            if (visited[r][c] == 0) {
                visited[r][c] = d;
                count++;
            }
            
            r += dirs[d][0];
            c += dirs[d][1];
        }
    }
    
	private static boolean isOutOfBounds() {
        return r < 0 || r == m || c < 0 || c == n;
    }

	private static void turnRight() {
        r -= dirs[d][0];
        c -= dirs[d][1];
        d = (d % 4) + 1;        
    }

}
