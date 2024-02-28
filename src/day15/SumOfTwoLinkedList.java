package day15;

import java.awt.HeadlessException;

public class SumOfTwoLinkedList {

	static ListNode list1 = null;
	static ListNode list2 = null;
	
//	public SumOfTwoLinkedList() {
//		list1 = new ListNode();
//		list2 = new ListNode();
//	}
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) {
			this.val = val; 
		}
		ListNode(int val, ListNode next) {
			this.val = val; this.next = next;
		}
	}
	
	private static ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
         ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return dummyHead.next;
        
    }
	
	public static void traverse(ListNode head) {
		if (head == null) {
			System.out.println("Null");
			return;
		}
		while (head != null) {
			System.out.print(head.val + ", ");
			head = head.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		
		ListNode first1 = new ListNode(9);
		ListNode first2 = new ListNode(9);
		ListNode first3 = new ListNode(9);
		ListNode first4 = new ListNode(9);
		ListNode first5 = new ListNode(10);
		first1.next = first2;
		first2.next = first3;
		first3.next = first4;
		first4.next = first5;
		list1 = first1;
		
		ListNode sec1 = new ListNode(9);
		ListNode sec2 = new ListNode(9);
		ListNode sec3 = new ListNode(9);
		ListNode sec4 = new ListNode(9);
		ListNode sec5 = new ListNode(10);
		ListNode sec6 = new ListNode(9);
		ListNode sec7 = new ListNode(9);
		sec1.next = sec2;
		sec2.next = sec3;
		sec3.next = sec4;
		sec4.next = sec5;
		sec5.next = sec6;
		sec6.next = sec7;
		list2 = sec1;
		
		System.out.println("Sum of Linked Lists :: ");
		traverse(addTwoNumbers(list1, list2));
	}

}
