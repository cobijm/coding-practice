package linkedlist;

import java.util.HashSet;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
        ListNode node = head;
        HashSet<ListNode> hash = new HashSet<>();
        while(node != null) {
            if(hash.contains(node)) {
                return true;
            } else {
                hash.add(node);
            }
            node = node.next;
        }
        return false;
    }
}
