package linkedLists;

/* 2.2 Return Kth to Last
 * Implement an algorithm to find the kth to last element of a single linked list.
 */

public class ReturnKthToLast {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static int KthToLast(ListNode head, int k) {
		ListNode kNode = head;
		ListNode runner = head;
		int counter = 0;

		while (counter < k) {
			runner = runner.next;
			counter++;
		}
		while (runner != null) {
			runner = runner.next;
			kNode = kNode.next;
		}
		return kNode.val;
	}

	public static String toStr(ListNode node) {
		String result = "[";
		while (node != null) {
			result += node.val;
			node = node.next;
			if (node != null) {
				result += ", ";
			}
		}
		return result += "]";
	}

	public static void main(String[] args) {
		ReturnKthToLast x = new ReturnKthToLast();
		
		ListNode test = x.new ListNode(1);
		test.next = x.new ListNode(2);
		test.next.next = x.new ListNode(3);
//		test.next.next.next = x.new ListNode(4);
//		test.next.next.next.next = x.new ListNode(5);
//		test.next.next.next.next.next = x.new ListNode(6);
		System.out.println("List: " + toStr(test));
		System.out.println("Value at " + 3 + " to Last: " + KthToLast(test, 3));
	}

}
