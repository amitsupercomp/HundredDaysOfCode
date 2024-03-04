package day20;

import java.util.*;

public class ReverseArrayInGroup {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		
		System.out.println("Array before reverse :: " + list);
		reverseInGroups(list, list.size(), 4);
		System.out.println("Array after reverse :: " + list);

	}
	
	public static void reverseInGroups(ArrayList<Integer> arr, int n, int k) {        
        for (int i = 0; i < n; i += k) {
            int right = Math.min(n - 1, i + k - 1);
            int left = i;
            while (left < right) {
                int temp = arr.get(left);
                arr.set(left, arr.get(right));
                arr.set(right, temp);
                right--;
                left++;
            }
        }
    }

}