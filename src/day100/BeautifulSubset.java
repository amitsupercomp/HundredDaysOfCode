package day100;
import java.util.*;

public class BeautifulSubset {
	
	public static void main(String[] args) {
		int[] nums = {2,4,6};
		int k = 2;
		System.out.println("Output :: " + beautifulSubsets(nums, k));
	}
	
	 private static int beautifulSubsets(int[] nums, int k) {        
	        Map<Integer, Integer> m = new HashMap<>();
	        for (int num : nums) 
	            m.put(num, m.getOrDefault(num, 0) + 1);
	        int res = 1, prev = 0, prevPrev = 0;
	        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
	            int cur = e.getKey();
	            if (m.containsKey(cur - k)) 
	                continue;
	            prev = 0;
	            while (m.containsKey(cur)) {
	                prevPrev = prev;
	                prev = ((1 << m.get(cur)) - 1) * res;
	                res += prevPrev;
	                cur += k;
	            }
	            res += prev;
	        }
	        return res - 1;
	    }

}
