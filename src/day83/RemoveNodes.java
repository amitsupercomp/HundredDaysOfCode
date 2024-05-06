package day83;

public class RemoveNodes {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(5); 
		head.next = new ListNode(2); 
		head.next.next = new ListNode(13); 
		head.next.next.next = new ListNode(3); 
		head.next.next.next.next = new ListNode(8); 
		ListNode result = removeNodes(head);
		System.out.println("Output :: ");
		while (result != null) {
			System.out.print(result.val + ", ");
			result = result.next;
		}
	}

	private static ListNode removeNodes(ListNode head) {
		head=rev(head);
		ListNode dummy=new ListNode();
		ListNode temp=dummy;

		int max=-1;
		while(head!=null){
			if(head.val>=max){
				max=head.val;
				dummy.next=head;
				dummy=dummy.next;
				// dummy.next=null;
				//max=head.val;
			}
			head=head.next;
		}
		dummy.next=null;
		return rev(temp.next);


	}
	private static ListNode rev(ListNode head){
		if(head==null || head.next==null){
			return head;
		}
		// ListNode dummy=new ListNode();
		ListNode prev=null;
		ListNode curr=head;
		while(curr!=null){
			ListNode next_node=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next_node;     
		}
		return prev;

	}

}
