package design;

import java.util.Stack;

public class MinStack {
	int min = Integer.MAX_VALUE;
	Stack<Integer> minStack;

	/** initialize your data structure here. */
	public MinStack() {
		minStack = new Stack<Integer>();
	}

	/*
	 * Push element onto Stack
	 */
	public void push(int x) {
		if (x <= min) {
			minStack.push(min);
			min = x;
		}
		minStack.push(x);
	}

	/*
	 * Removes the element at the top of the stack
	 */
	public void pop() {
		if (minStack.pop() == min) {
			min = minStack.pop();
		}
	}

	/**
	 * Get the top element
	 * 
	 * @return the top element
	 */
	public int top() {
		return minStack.peek();
	}

	/**
	 * Retrieve the minimum element in the stack
	 * 
	 * @return
	 */
	public int getMin() {
		return min;
	}

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());   //--> Returns -3.
		minStack.pop();
		System.out.println(minStack.top());      //--> Returns 0.
		System.out.println(minStack.getMin());   //--> Returns -2.
	}
}
