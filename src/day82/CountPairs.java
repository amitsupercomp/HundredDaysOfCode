package day82;
import java.util.*;

public class CountPairs {
	
	public static void main(String[] args) {
		int[] nums1 = {2,1,2,1}, nums2 = {1,2,1,2};
		System.out.println("Output :: " + countPairs(nums1, nums2));
	}
	
	private static long countPairs(int[] nums1, int[] nums2) {
        int n = nums1.length;
       int[] nums = new int[n];
       for (int i = 0; i < n; i++) 
           nums[i] = nums1[i] - nums2[i];
       Arrays.sort(nums);
       int start = 0, end = n - 1;
       long cnt = 0;
       while (start < end){
           if (nums[start] + nums[end] > 0){
               cnt += end - start;
               end--;
           }else start++;
       }
       return cnt;
   }

}
