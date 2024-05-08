package day84;


public class DoubleNuberLinkedList {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(9); 
		head.next = new ListNode(9); 
		head.next.next = new ListNode(9); 
		head.next.next.next = new ListNode(2); 
		head.next.next.next.next = new ListNode(5); 
		head.next.next.next.next.next = new ListNode(6); 
		head.next.next.next.next.next.next = new ListNode(7);
		System.out.println("Original list is :: ");
		ListNode ret = head;
		while (ret != null) {
			System.out.print(ret.val + ", ");
			ret = ret.next;
		}
		System.out.println("\n Result List :: ");
		ListNode result = doubleIt(head);
		while (result != null) {
			System.out.print(result.val + ", ");
			result = result.next;
		}
	}

	private static ListNode doubleIt(ListNode head) {
		ListNode head1 = new ListNode();
		head1.next = head;

		ListNode left = head1;
		ListNode right = head;
		while (right != null) {
			if (right.val * 2 >= 10) {
				left.val += 1;
			}
			right.val = (right.val * 2) % 10;
			left = left.next;
			right = right.next;
		}
		return head1.val > 0 ? head1 : head;
	}

}
