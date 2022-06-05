package leetcode;


public class AddTwoNumbers {
	
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	 
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        int l1sum = sum(l1); //342
	        int l2sum = sum(l2); //465
	        int total = l1sum + l2sum; //807
	        ListNode curr = new ListNode(total % 10); // 7 -> null
	        ListNode result = curr;
	        total = total / 10; //80
	        
	        while(total != 0) {
	            ListNode newNode = new ListNode(total % 10);   
	            curr.next = newNode;
	            curr = newNode;
	            total = total / 10;
	        }
	        return result;
	    }
	    
	    public int sum(ListNode node) {
	        int sum = 0;
	        int power = 0;
	        while(node != null) {
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
		// TODO Auto-generated method stub
		AddTwoNumbers x = new AddTwoNumbers();
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
		System.out.println("Added: " + toStr(x.addTwoNumbers(test, test1)));
	}

}
