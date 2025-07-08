package linkedLists;

import java.util.HashSet;

/* 2.7 Intersection
 * Given two (singly) linked lists, determine if the two lists intersect. Return the
 * intersecting node. Node that the intersection is defined based on reference, not value.
 * That is, if the kth node of the first linked list is the exact same node (by reference) 
 * as the jth node of the second linked list, then they are intersecting.
 */
public class Intersection {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	//INCOMPLETE
	public ListNode intersection(ListNode headA, ListNode headB) {
		ListNode currB = headB;
		while(headA != null) {
			while(currB != null) {
				if(headA == currB) {
					return currB;
				}
				currB = currB.next;
			}
			headB = headB.next;
			currB = headB;
		}
		return null;
	}
	
	public static ListNode intersectionHash(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        //traverse through A, and add all nodes to hash set
		while(headA != null) {
			set.add(headA);
			headA = headA.next;
		}
		//traverse through B and if hashset contains the node, return that node
		while(headB != null) {
			if(set.contains(headB)) {
				return headB;
			}
			headB = headB.next;
		}
		return null;
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
		Intersection x = new Intersection();
		
		ListNode test = x.new ListNode(1);
		test.next = x.new ListNode(2);
		test.next.next = x.new ListNode(3);
		test.next.next.next = x.new ListNode(4);
		test.next.next.next.next = x.new ListNode(5);
		test.next.next.next.next.next = x.new ListNode(6);
		
		ListNode test2 = x.new ListNode(8);
		test2.next = x.new ListNode(5);
		test2.next.next = x.new ListNode(3);
		test2.next.next.next = test.next.next.next;
		
		System.out.println("A: " + toStr(test));
		System.out.println("B: " + toStr(test2));
		System.out.println("Intersection: " + toStr(intersectionHash(test, test2)));
		
	}

}
