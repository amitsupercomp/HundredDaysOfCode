package day33;
import java.util.*;

public class InsertInterval {

	public static void main(String[] args) {
		int[][] arr = {{1,2},{3,5},{6,7},{8,10},{12,16}};
		int[] newIntervals = {4,8};
		//System.out.println("Intervals :: " + Arrays.toString(insert(arr, newIntervals)));
		System.out.println("Output is :: ");
		for (int[] interval : insert(arr, newIntervals)) {
			System.out.println(Arrays.toString(interval));
		}
	}
	
	private static int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> mergeInt = new ArrayList<>();

		for (int[] interval : intervals) {
			if (interval[1] < newInterval[0]) {
				mergeInt.add(interval);
			} else if (interval[0] > newInterval[1]) {
				mergeInt.add(newInterval);
				newInterval = interval;
			} else {
				newInterval[0] = Math.min(newInterval[0], interval[0]);
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			}
		}
		mergeInt.add(newInterval);
		return mergeInt.toArray(new int[mergeInt.size()][2]);
	}

}
