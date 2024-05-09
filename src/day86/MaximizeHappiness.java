package day86;
import java.util.*;

public class MaximizeHappiness {
	
	public static void main(String[] args) {
		int[] happiness = {2,3,4,5};
		int k = 1;
		System.out.println("Output :: " + maximumHappinessSum(happiness, k));
	}
	
	private static long maximumHappinessSum(int[] h, int k) {
        long max = 0;
        int c = 0, value = 0;
        Arrays.sort(h);
        for (int i = h.length - 1;i >= h.length - k; i--)
        {
            value = h[i] - c++;
            if (value > 0)
            {
                max += value;
            }
        }
        return max;
    }

}
