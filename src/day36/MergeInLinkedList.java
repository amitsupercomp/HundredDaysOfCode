package day36;

public class MergeInLinkedList {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}
		ListNode(int val) {
			this.val = val;
		}
		ListNode(int val, ListNode next) { 
			this.val = val; 
			this.next = next; 
		}
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(9, l1);
		ListNode l3 = new ListNode(6, l2);
		ListNode l4 = new ListNode(13, l3);
		ListNode l5 = new ListNode(1, l4);
		ListNode l6 = new ListNode(10, l5);

		int a = 3, b = 4;

		ListNode l21 = new ListNode(1000002);
		ListNode l22 = new ListNode(1000001, l21);
		ListNode l23 = new ListNode(1000000, l22);

		System.out.println("After merging :: ");

		ListNode resListNode = mergeInBetween(l6, a, b, l23);

		while (resListNode != null) {
			System.out.println(resListNode.val);
			resListNode = resListNode.next;
		}
	}

	private static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
		ListNode duplicate = list1;
		int index = 0;
		while (index < a - 1) {
			duplicate = duplicate.next;
			index++;
		}
		ListNode first = duplicate;
		while (index < b + 1) {
			duplicate = duplicate.next;
			index++;
		}
		ListNode last = duplicate;
		first.next = list2;
		while (list2.next != null) {
			list2 = list2.next;
		}
		list2.next = last;
		return list1;
	}

}
