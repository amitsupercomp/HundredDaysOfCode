package day9;
import java.util.*;
public class ContainDuplicates {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,6,7,7,8};
		System.out.println("Array contains duplicate :: " + containsDuplicate(arr));
	}
	
	private static boolean containsDuplicate(int[] nums) {
		if(nums==null || nums.length==0)
			return false;
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i: nums){
			if(!set.add(i)){
				return true;
			}
		}
		return false;
	}
}
