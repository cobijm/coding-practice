package linkedLists;

/* 2.3 Delete Middle Node
 * Implement an algorithm to delete a node in the middle (i.e., any node but the first
 * and the last node, not necessarily the exact middle) of a singly linked list, given
 * only access to that middle node.
 * 
 * EXAMPLE
 * Input:  a -> b -> c -> d -> e -> f
 * 				     ^
 * Result: a -> b -> d -> e -> f
 */
public class DeleteMiddleNode {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void deleteMiddleNode(ListNode midNode) {
		midNode.val = midNode.next.val;
		midNode.next = midNode.next.next;
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
		DeleteMiddleNode x = new DeleteMiddleNode();
		
		ListNode test = x.new ListNode(1);
		test.next = x.new ListNode(2);
		test.next.next = x.new ListNode(3);
		test.next.next.next = x.new ListNode(4);
		test.next.next.next.next = x.new ListNode(5);
		test.next.next.next.next.next = x.new ListNode(6);
		System.out.println("Original: 	    " + toStr(test));
		deleteMiddleNode(test.next.next);
		System.out.println("Deleted middle node: " + toStr(test));
	}

}
