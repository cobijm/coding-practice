package random;

public class MyLinkedList {

	/** Initialize your data structure here. */
	Node head;

	public class Node {
		int val;
		Node next;

		Node(int x) {
			val = x;
			next = null;
		}
	}

	private int size = 0;

	/**
	 * Get the value of the index-th node in the linked list. If the index is
	 * invalid, return -1.
	 */
	public int get(int index) {
		if (head == null) {
			return -1;
		}
		// if index is negative
		Node temp = head;
		if (index < 0) {
			return -1;
		}
		int count = 0;
		// while you haven't reached index
		while (count < index) {
			if (temp.next == null) {
				return -1;
			}
			temp = temp.next;
			count++;
		}
		// return value at index
		return temp.val;
	}

	/**
	 * Add a node of value val before the first element of the linked list. After
	 * the insertion, the new node will be the first node of the linked list.
	 */
	public void addAtHead(int val) {
		Node newNode = new Node(val);
		newNode.next = head;
		head = newNode;
		size++;
	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		Node newNode = new Node(val);
		if (size == 0) {
			head = newNode;
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
		size++;
	}

	/**
	 * Add a node of value val before the index-th node in the linked list. If index
	 * equals to the length of linked list, the node will be appended to the end of
	 * linked list. If index is greater than the length, the node will not be
	 * inserted.
	 */
	public void addAtIndex(int index, int val) {
		if (index == size) {
			addAtTail(val);
			return;
		}
		if (index > size) {
			return;
		}
		int count = 1;
		Node temp = head;
		// get to index
		while (count < index) {
			// if index > length of linked list, don't insert
			if (temp.next == null) {
				return;
			}

			temp = temp.next;
			count++;
		}
		Node newNode = new Node(val);
		newNode.next = temp.next;
		temp.next = newNode;
		size++;
	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		if (index < 0) {
			return;
		}
		int count = 0;
		Node prev = null;
		Node temp = head;
		while (count < index) {
			// if index > length of linked list, don't insert
			if (temp.next == null) {
				return;
			}
			prev = temp;
			temp = temp.next;
			count++;
		}
		prev.next = temp.next;
		size--;
	}

	public String toString() {
		String result = "[";
		Node temp = head;
		while (temp != null) {
			result += temp.val;
			temp = temp.next;
			if (temp != null) {
				result += ", ";
			}
		}
		return result + "]";
	}

	public static String toStr(Node node) {
		String result = "[";
		while (node != null) {
			result += node.val;
			node = node.next;
			if (node != null) {
				result += ", ";
			}
		}
		return result + "]";
	}

	/**
	 * Your MyLinkedList object will be instantiated and called as such:
	 * MyLinkedList obj = new MyLinkedList(); int param_1 = obj.get(index);
	 * obj.addAtHead(val); obj.addAtTail(val); obj.addAtIndex(index,val);
	 * obj.deleteAtIndex(index);
	 */
	public static void main(String[] args) {
		MyLinkedList test = new MyLinkedList();

//		-----TEST CASE 1-------
//		test.addAtHead(1);
//		System.out.println("After addAtHead(1): " + test.toString());
//
//		test.addAtTail(3);
//		System.out.println("After addAtTail(3): " + test.toString());
//
//		test.addAtIndex(1, 2);
//		System.out.println("After addAtIndex(1, 2): " + test.toString());
//
//		System.out.println("test.get(1): " + test.get(1));
//		test.deleteAtIndex(1);
//		System.out.println("After deleteAtIndex(1): " + test.toString());		
//		System.out.println("test.get(1): " + test.get(1));

		System.out.println("test.get(0): " + test.get(0));
		test.addAtIndex(1, 2);
		System.out.println("After addAtIndex(1, 2): " + test.toString());
		System.out.println("test.get(0): " + test.get(0));
		System.out.println("test.get(1): " + test.get(1));
		test.addAtIndex(0, 1);
		System.out.println("After addAtIndex(0, 1): " + test.toString());
		System.out.println("test.get(0): " + test.get(0));
		System.out.println("test.get(1): " + test.get(1));
		
	}

}
