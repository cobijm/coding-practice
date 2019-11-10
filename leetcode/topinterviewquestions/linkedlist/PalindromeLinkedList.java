package linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class PalindromeLinkedList {

	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		ArrayList<Integer> values = new ArrayList<>();
		ListNode runner = head;
		ListNode secondHalf = head;
		boolean isOdd = false;
		while (runner != null) {
			if (runner.next == null) {
				isOdd = true;
				break;
			}
			values.add(secondHalf.val);
			secondHalf = secondHalf.next;
			runner = runner.next.next;
		}
		System.out.println(Arrays.toString(values.toArray()));
		Collections.reverse(values);
		System.out.println(Arrays.toString(values.toArray()));
		if (isOdd) {
			secondHalf = secondHalf.next;
		}
		int index = 0;
		while (secondHalf != null) {
			if (secondHalf.val != values.get(index)) {
				return false;
			}
			secondHalf = secondHalf.next;
			index++;
		}
		return true;
	}
	
	public static boolean isPalindromeStack(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		Stack<Integer> firstHalf = new Stack<>();
		ListNode runner = head;
		ListNode secondHalf = head;
		boolean isOdd = false;
		while (runner != null) {
			if (runner.next == null) {
				isOdd = true;
				break;
			}
			firstHalf.push(secondHalf.val);
			secondHalf = secondHalf.next;
			runner = runner.next.next;
		}
		if (isOdd) {
			secondHalf = secondHalf.next;
		}
		while (secondHalf != null) {
			if (secondHalf.val != firstHalf.peek()) {
				return false;
			}
			firstHalf.pop();
			secondHalf = secondHalf.next;
		}
		return true;
	}

	public static void main(String[] args) {
		ListNode test = new ListNode(1);
		test.next = new ListNode(2);
		test.next.next = new ListNode(2);
		test.next.next.next = new ListNode(1);
		System.out.println(isPalindromeStack(test));

	}

}
