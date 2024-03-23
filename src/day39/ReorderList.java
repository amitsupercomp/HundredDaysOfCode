package day39;

import day38.PalindromeLinkedList.ListNode;

public class ReorderList {

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
		
		System.out.println("\n Reorder List :: ");
		ListNode res = reorderList(head);
		while (res != null) {
			System.out.print(res.val + ", ");
			res = res.next;
		}
		
		
	}
	
	private static ListNode reorderList(ListNode head) {
	       if(head.next == null)return null;
	       ListNode slow = head, fast = head, prevSlow = slow;
	        //get hold of mid of linked list
	        while(fast != null &&  fast.next != null){
	            prevSlow = slow;
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        prevSlow.next = null;
	        ListNode firstHlfHead = head;
	        ListNode secondHlfHead = reverse(slow);
	        while(firstHlfHead != null && secondHlfHead != null){
	            
	            ListNode nextFirstHlfNode = firstHlfHead.next;
	            firstHlfHead.next = secondHlfHead;
	            firstHlfHead = nextFirstHlfNode;
	            ListNode nextSecondHlfNode = secondHlfHead.next; 
	            secondHlfHead.next = (nextFirstHlfNode != null) ? nextFirstHlfNode : nextSecondHlfNode;
	            secondHlfHead = nextSecondHlfNode;
	        }
	        return head;
	    }

	    private static ListNode reverse(ListNode head){
	        ListNode curr = head, prev = null;
	        while(curr != null){
	            ListNode nextNode = curr.next;
	            curr.next = prev;
	            prev = curr;
	            curr = nextNode;
	        }
	        return prev;
	    }
}
