package day81;
import java.util.*;

public class BoatToSavePeople {

	public static void main(String[] args) {
		
		int[] people = {3,5,3,4};
		int limit = 5;
		System.out.println("Output :: " + numRescueBoats(people, limit));

	}

	private static int numRescueBoats(int[] people, int limit) {
		int i = 0, j = people.length - 1;
		int ans = 0;
		Arrays.sort(people);
		while (i <= j) {
			ans++;
			if (people[i] + people[j] <= limit)
				i++;
			j--;
		}
		return ans;
	}

}
