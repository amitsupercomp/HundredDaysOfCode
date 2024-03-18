package day34;
import java.util.*;

public class MeetingRooms {

	public static void main(String[] args) {
		int[][] arr = {
				{0, 30},
				{5, 10},
				{15, 20}
		};
		System.out.println("A person can attend all meetings :: " + canAttendMeetings(arr));
	}
	
	private static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for(int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0])
                return false;
        }
        return true;
    }
}
