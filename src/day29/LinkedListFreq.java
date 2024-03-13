package day29;
import java.util.*;

public class LinkedListFreq {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(2);
		ListNode n6 = new ListNode(3);
		ListNode head = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		ListNode ansListNode = frequenciesOfElements(head);
		
		while (ansListNode != null) {
			System.out.println(ansListNode.val + ", ");
			ansListNode = ansListNode.next;
		}
	}

	private static ListNode frequenciesOfElements(ListNode head) {
		HashMap<Integer, Integer> map = new HashMap<>();
		ListNode duplicate = head;
		while (duplicate != null) {
			map.put(duplicate.val, map.getOrDefault(duplicate.val, 0) + 1);
			duplicate = duplicate.next;
		}
		// ListNode prev = null, h = null;
		// for (int k : map.keySet()) {
		//     int v = map.get(k);
		//     if (prev == null) {
		//         h = new ListNode(v);
		//         prev = h;
		//     } else {
		//         prev.next = new ListNode(v);
		//         prev = prev.next;
		//     }
		// }
		// return h;
		ListNode ans = new ListNode();
		ListNode ansCopy = ans;
		for(int val : map.values()) {
			ans.next = new ListNode(val);
			ans = ans.next;
		}
		return ansCopy.next;
	}
}
