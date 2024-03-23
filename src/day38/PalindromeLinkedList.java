package day38;

public class PalindromeLinkedList {
	
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
		head.next.next.next.next = new ListNode(30); 
		head.next.next.next.next.next = new ListNode(20); 
		head.next.next.next.next.next.next = new ListNode(10); 
		
		System.out.println("Original List is :: ");
		ListNode duplicate = head;
		while (duplicate != null) {
			System.out.print(duplicate.val + ", ");
			duplicate = duplicate.next;
		}
		
		System.out.println(" \n Is Palindrome :: " + isPalindrome(head));
	}
	
	private static boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
            ListNode duplicate = head;
        ListNode reverse = new ListNode(duplicate.val);
        duplicate = duplicate.next;
        while (duplicate != null) {
            reverse = new ListNode(duplicate.val, reverse);
            duplicate = duplicate.next;
        }
        while (head != null) {
            if (head.val != reverse.val)
                return false;
            head = head.next;
            reverse = reverse.next;
        }
        return true;
    }

}
