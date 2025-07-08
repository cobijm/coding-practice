package linkedLists;

/*
 * 2.5 Sum Lists
 * You have two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1's digit is at the head of the list. 
 * Write a function that adds the two numbers and returns the sum as a linked list. 
 * 
 * EXAMPLE
 * Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). Which is 617 + 295 = 912.
 * 
 * Output: (2 -> 1 -> 9). Which is 912.
 */
public class SumLists {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode sumLists(ListNode l1, ListNode l2) {
		int l1sum = sum(l1); // 4321
		int l2sum = sum(l2); // 4213
		int total = l1sum + l2sum; // 8534
		ListNode curr = new ListNode(total % 10); // 4 -> null
		ListNode result = curr;
		total = total / 10; // 853

		//while there are still numbers that need to be converted to a node
		while (total != 0) {
			//new node is the last number
			ListNode newNode = new ListNode(total % 10);
			curr.next = newNode;
			curr = newNode;
			//remove last number and go again
			total = total / 10;
		}
		return result;
	}

	/*
	 * Returns the sum of elements in a Linked List
	 */
	public int sum(ListNode node) {
		int sum = 0;
		int power = 0;
		while (node != null) {
			sum += (node.val * Math.pow(10, power));
			power++;
			node = node.next;
		}
		return sum;
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
		SumLists x = new SumLists();
		ListNode test = x.new ListNode(1);
		test.next = x.new ListNode(2);
		test.next.next = x.new ListNode(3);
		test.next.next.next = x.new ListNode(4);

		ListNode test1 = x.new ListNode(3);
		test1.next = x.new ListNode(1);
		test1.next.next = x.new ListNode(2);
		test1.next.next.next = x.new ListNode(4);

		System.out.println("First: " + toStr(test));
		System.out.println("Second: " + toStr(test1));
		System.out.println("Added: " + toStr(x.sumLists(test, test1)));

	}

}
