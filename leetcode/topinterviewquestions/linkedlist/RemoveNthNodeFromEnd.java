package linkedlist;

public class RemoveNthNodeFromEnd {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		int len = 0;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode first = head;
		while (first != null) {
			len++;
			first = first.next;
		}
		first = dummy;

		len = len - n;
		
		while(len > 0) {
			len--;
			first = first.next;
		}
		first.next = first.next.next;
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode test = new ListNode(1);
		test.next = new ListNode(2);
		//test.next.next = new ListNode(3);
		//test.next.next.next = new ListNode(4);
		//test.next.next.next.next = new ListNode(5);
		System.out.println(removeNthFromEnd(test, 2));
	}

}
