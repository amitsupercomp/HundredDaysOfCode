package day29;

public class WinnerOfLinkedList {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(5);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(7);
		ListNode n5 = new ListNode(20);
		ListNode n6 = new ListNode(5);
		ListNode head = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		System.out.println("Result is :: " + gameResult(head));
	}

	private static String gameResult(ListNode head) {
		int odd = 0, even = 0;
		ListNode duplicate = head;
		int first = 0, second = 0;

		while (duplicate != null) {
			first = duplicate.val;
			duplicate = duplicate.next;
			second = duplicate.val;
			if (first > second)
				even++;
			else
				odd++;
			duplicate = duplicate.next;
		}
		if (even > odd)
			return "Even";
		else if (odd > even)
			return "Odd";
		else
			return "Tie";
	}
}
