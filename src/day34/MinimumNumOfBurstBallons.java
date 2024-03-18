package day34;
import java.util.*;

public class MinimumNumOfBurstBallons {

	public static void main(String[] args) {
		int[][] arr = {{10,16},{2,8},{1,6},{7,12}};
		System.out.println("Minimum no of Arrows :: " + findMinArrowShots(arr));
	}
	
	private static int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;
        Arrays.sort(points, (a, b) -> {
            if (a[1] < b[1])
                return -1;
            else if (a[1] > b[1])
                return 1;
            return 0;
        });
        int res = 1;
        int start, end, first = points[0][1];

        for (int[] point : points) {
            start = point[0];
            end = point[1];
            if (first < start) {
                res++;
                first = end;
            }
        }
        return res;
    }
}
