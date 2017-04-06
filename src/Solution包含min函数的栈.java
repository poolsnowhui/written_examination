import java.util.Stack;

public class Solution包含min函数的栈 {

	Stack<Integer> s = new Stack<>();
	Stack<Integer> minStack = new Stack<>();

	public void push(int node) {
		s.push(node);
		if (minStack.peek() > node) {
			minStack.push(node);
		} else {
			minStack.push(minStack.peek());
		}
	}

	public void pop() {
		s.pop();
		minStack.pop();
	}

	public int top() {
		return s.peek();
	}

	public int min() {
		return minStack.peek();
	}
}