package leetcode;

public class GetIntersectionNode {
	 // Definition for singly-linked list.
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        ListNode currB = headB;
	        while(headA != null) {
	            while(currB != null) {
	                if(currB == headA) {
	                    return currB;
	                }
	                currB = currB.next;
	            }
	            currB = headB;
	        }
		    return currB;
	    }

	
	    public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
