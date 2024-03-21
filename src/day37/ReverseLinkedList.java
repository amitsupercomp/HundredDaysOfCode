package day37;

public class ReverseLinkedList {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(10); 
		head.next = new ListNode(20); 
		head.next.next = new ListNode(30); 
		head.next.next.next = new ListNode(40); 
		head.next.next.next.next = new ListNode(50); 
		head.next.next.next.next.next = new ListNode(60); 
		head.next.next.next.next.next.next = new ListNode(70); 
		
		System.out.println("Original List is :: ");
		ListNode duplicate = head;
		while (duplicate != null) {
			System.out.print(duplicate.val + ", ");
			duplicate = duplicate.next;
		}
		
		System.out.println("\n Reverse List is :: ");
		ListNode result = reverseList(head);
		while (result != null) {
			System.out.print(result.val + ", ");
			result = result.next;
		}
	}

	private static ListNode reverseList(ListNode head) {
		if (head == null)
			return null;
		ListNode reverse = new ListNode(head.val);
		head = head.next;
		while (head != null) {
			reverse = new ListNode(head.val, reverse);
			head = head.next;
		}
		return reverse;
	}
}
