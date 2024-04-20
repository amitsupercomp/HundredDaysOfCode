package day67;
import java.util.*;

public class GroupOfFarmsLand {
	
	public static void main(String[] args) {
		int[][] land = {{1,0,0}, {0,1,1}, {0,1,1}};
		System.out.println("Output :: " + Arrays.deepToString(findFarmland(land)));
	}

	 private static int[][] findFarmland(int[][] land) {
	        List<int[]> res = new ArrayList<>();

	        for (int i = 0; i < land.length; i++) {
	            for (int j = 0; j < land[0].length; j++) {
	                if (land[i][j] == 1) {
	                    int a = i, b = j;
	                    for (a = i;a < land.length && land[a][j] == 1; a++) 
	                        for (b = j;b < land[0].length && land[a][b] == 1; b++) 
	                            land[a][b] = 0;
	                    int[] temp = new int[] {i, j, a - 1, b - 1};
	                    res.add(temp);
	                }
	            }
	        }
	        return res.stream().toArray(int[][] :: new);
	    }
}
