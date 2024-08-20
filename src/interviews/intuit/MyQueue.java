package interviews.intuit;

import java.util.Stack;

public class MyQueue {
	Stack<Integer> pushStack;
	Stack<Integer> popStack;

	public static void main(String args[]) {
		MyQueue myQueue = new MyQueue();
		myQueue.push(1); // queue is: [1]
		myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
		myQueue.peek(); // return 1
		System.out.println(myQueue.pop()); // return 1, queue is [2]
		myQueue.empty(); // return false
	}

	public MyQueue() {
		pushStack = new Stack<>();
		popStack = new Stack<>();
	}

	public void push(int x) {
		pushStack.add(x);
	}

	public int pop() {
		if (popStack.isEmpty()) {
			populatePopStack();
		}
		return popStack.pop();
	}

	public int peek() {
		if (popStack.isEmpty()) {
			populatePopStack();
		}
		return popStack.peek();
	}

	public boolean empty() {
		if (pushStack.isEmpty() && popStack.isEmpty())
			return true;
		return false;
	}

	private void populatePopStack() {
		// pop from pushStack and push to popStack-> reverse the order
		while (!pushStack.isEmpty()) {
			popStack.add(pushStack.pop());
		}
	}
}
