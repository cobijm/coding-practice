package linkedlist;

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }
        if(l1 == null && l2 != null) {
            return l2;
        }
        if(l1 != null && l2 == null) {
            return l1;
        }
        
        ListNode node = null;
        if(l1.val >= l2.val) {
            node = l2;
            l2 = l2.next;
        } else {
            node = l1;
            l1 = l1.next;
        }
        
        ListNode head = node;
        
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        if(l1 != null) {
            node.next = l1;
        } else {
            node.next = l2;
        }
        return head;
    }
}
