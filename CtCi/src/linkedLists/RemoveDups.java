package linkedLists;

import java.util.HashSet;

/*
 * 2.1
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class RemoveDups {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public void removeDupsIter(ListNode node) {
		ListNode compare = node;
		while (compare != null) {
			ListNode curr = compare;
			while (curr.next != null) {
				if (curr.next.val == compare.val) {
					curr.next = curr.next.next;
				} else {
					curr = curr.next;
				}
			}
			compare = compare.next;
		}
	}

	public void removeDupsHash(ListNode node) {
		//hash table to store values already seen
		HashSet<Integer> set = new HashSet<Integer>();
		ListNode prev = null;

		//iterate through linked list
		while (node != null) {
			//if value at node is already in hash table, unlink the node
			if (set.contains(node.val)) {
				prev.next = node.next;
				//if not, add the value to the hash table
			} else {
				set.add(node.val);
				prev = node;
			}
			node = node.next;
		}
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
		RemoveDups x = new RemoveDups();

		ListNode test = x.new ListNode(1);
		test.next = x.new ListNode(2);
		test.next.next = x.new ListNode(3);
		test.next.next.next = x.new ListNode(4);
		test.next.next.next.next = x.new ListNode(3);
		test.next.next.next.next.next = x.new ListNode(2);
		test.next.next.next.next.next.next = x.new ListNode(3);
		test.next.next.next.next.next.next.next = x.new ListNode(7);
		test.next.next.next.next.next.next.next.next = x.new ListNode(2);

		System.out.println("Original: 	    " + toStr(test));
		x.removeDupsHash(test);
		System.out.println("Duplicates Removed: " + toStr(test));
	}
}
