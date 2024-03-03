package day19;

public class MergeSortedLinkedList {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(4);
		ListNode l4 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		
		ListNode list1 = l1;
		
		
		ListNode l11 = new ListNode(1);
		ListNode l22 = new ListNode(4);
		ListNode l33= new ListNode(7);
		ListNode l44 = new ListNode(8);
		l11.next = l22;
		l22.next = l33;
		l33.next = l44;
		
		ListNode list2 = l11;
		
		ListNode l111 = new ListNode(1);
		ListNode l222 = new ListNode(6);
		ListNode l333= new ListNode(9);
		ListNode l444 = new ListNode(13);
		ListNode l555 = new ListNode(15);
		l111.next = l222;
		l222.next = l333;
		l333.next = l444;
		l444.next = l555;
		
		ListNode list3 = l111;
		
		ListNode[] finalList = {list1, list2, list3};
		
		ListNode[] dummyLists = finalList;
		
		//System.out.println("List before sorted :: ");
		
//		for (int i = 0; i < dummyLists.length; i++) {
//			while (dummyLists[i] != null) {
//				System.out.print(dummyLists[i].val + ", ");
//				dummyLists[i] = dummyLists[i].next;
//			}
//			System.out.println();
//		}
		
		dummyLists = finalList;
		
		System.out.println("After sorting.....");
		
		ListNode finalSortedList = mergeKLists(dummyLists);
		while (finalSortedList != null) {
			System.out.print(finalSortedList.val + ", ");
			finalSortedList = finalSortedList.next;
		}
		
		
		
	}
	
	private static ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		return mergeKListsHelper(lists, 0, lists.length - 1);
	}

	private static ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
		if (start == end) {
			return lists[start];
		}
		if (start + 1 == end) {
			return merge(lists[start], lists[end]);
		}
		int mid = start + (end - start) / 2;
		ListNode left = mergeKListsHelper(lists, start, mid);
		ListNode right = mergeKListsHelper(lists, mid + 1, end);
		return merge(left, right);
	}

	private static ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				curr.next = l1;
				l1 = l1.next;
			} else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}

		curr.next = (l1 != null) ? l1 : l2;

		return dummy.next;
	}

}
