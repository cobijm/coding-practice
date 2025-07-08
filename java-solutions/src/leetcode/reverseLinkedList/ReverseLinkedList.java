package reverseLinkedList;

public class ReverseLinkedList {

	// Definition for singly-linked list.
	ListNode head;

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode reverseList(ListNode head) {
		// if no list return null
		if (head == null) {
			return null;
		}
		// pointer to traverse original
		// 1 -> 2 -> 3 -> 4 -> 5
		//      ^
		ListNode node = head.next;

		// reversed link list
		// 1 -> 2 -> 3 -> 4 -> 5
		// ^
		ListNode reversed = head;

		// 1 -> NULL
		// ^
		reversed.next = null;

		while (node != null) {
			ListNode temp = node;
			node = node.next;

			temp.next = reversed;
			reversed = temp;
		}
		return reversed;
		// 5 -> 4 -> 3 -> 2 -> 1 -> NULL
	}

	public ListNode recursiveReverse(ListNode curr) {
		if (curr == null) {
			return curr;
		}
		// reached end, base case
		if (curr.next == null) {
			return curr;
		}
		// get to end of linked list
		ListNode reversed = recursiveReverse(curr.next);
		// going back recursive calls, do these until return statement
		curr.next.next = curr;
		curr.next = null;
		// return the previous recursive call
		return reversed;
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n) {
			return head;
		}
		if (head == null) {
			return head;
		}
		ListNode before = null;
		ListNode tail = null;
		ListNode prev = null;
		ListNode curr = head;
		int count = 1;

		// curr is at position m, prev is the pointer before m
		while (count < m) {
			prev = curr;
			curr = curr.next;
			count++;
		}
		tail = curr;
		before = prev;

		// start of the reversed linked list portion
		ListNode third = curr;
        if(m != 1 && n != 2) {
			count--;
		}
		while (count < n) {
			third = curr.next;
			curr.next = prev;
			prev = curr;
			curr = third;
			count++;
		}
		if(before == null) {
			third.next = prev;
			return third;
		}
		else {
			before.next = prev;
			tail.next = curr;
			return before;			
		}
	}
	
	public String toString(ListNode node) {
		String result = "";
		ListNode current = node;
		while (current.next != null) {
			result += current.val;
			if (current.next != null) {
				result += ", ";
			}
			current = current.next;
		}
		return "List: " + result;
	}

	public static String toStr(ListNode node) {
		String result = "[";
		while(node != null) {
			result += node.val;
			node = node.next;
			if(node != null) {
				result += ", ";
			}
		}
		return result += "]";
	}
	
	//test class
	public static void main(String[] args) {
//		ReverseLinkedList x = new ReverseLinkedList();
//		ListNode test = x.new ListNode(1);
//		test.next = x.new ListNode(2);
//		test.next.next = x.new ListNode(3);
//		test.next.next.next = x.new ListNode(4);
//		test.next.next.next.next = x.new ListNode(5);
//		test.next.next.next.next.next = null;
//		// 1 -> 2 -> 3 -> 4 -> 5 -> NULL
//
//		System.out.println("Original: " + toStr(test));
//		ListNode reversed = x.recursiveReverse(test);
//		System.out.println("Reversed: " + toStr(reversed));
//		System.out.print("[");
//		while(reversed != null) {
//			System.out.print(reversed.val);
//			reversed = reversed.next;
//			if(reversed != null) {
//				System.out.print(", ");
//			}
//		}
//		System.out.print("]");
		ReverseLinkedList x = new ReverseLinkedList();
		ListNode test = x.new ListNode(3);
		test.next = x.new ListNode(5);
//		test.next.next = x.new ListNode(3);
//		test.next.next.next = x.new ListNode(4);
//		test.next.next.next.next = x.new ListNode(5);
//		test.next.next.next.next.next = null;
		// 1 -> 2 -> 3 -> 4 -> 5 -> NULL

		System.out.println("Original: " + toStr(test));
		ListNode reversed = x.reverseBetween(test, 1, 2);
		System.out.println("Reversed: " + toStr(reversed));
	}
}
