package linkedLists;

/*
 * 2.6 
 * Implement a function to check if a linked list is a palindrome.
 */
public class Palindrome {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public static boolean palindrome(ListNode head) {
		if(reverse(head) == head) {
			return true;
		}
		return false;
	}
	
	public static ListNode reverse(ListNode node) {
		
		if (node == null) {
			return node;
		}
		// reached end, base case
		if(node.next == null) {
			return node;
		}
		
		ListNode reversed = reverse(node.next);
		
		node.next.next = node;
		node.next = null;
		return reversed;
		
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
		Palindrome x = new Palindrome();
		
		ListNode test = x.new ListNode(0);
		test.next = x.new ListNode(0);
//		test.next.next = x.new ListNode(3);
//		test.next.next.next = x.new ListNode(3);
//		test.next.next.next.next = x.new ListNode(2);
//		test.next.next.next.next.next = x.new ListNode(1);
		
		System.out.println("Original: " + toStr(test));
		System.out.println("Reversed: " + toStr(reverse(test)));
		System.out.println(palindrome(test));
	}

}
