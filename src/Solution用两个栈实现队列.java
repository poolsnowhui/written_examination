import java.util.Stack;

public class Solution用两个栈实现队列 {
	/**
	 * 题目描述
	 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
	 */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
    	if(!stack2.isEmpty())
    	 return stack2.pop();
    	else{
    		while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());//s2獲取s1的所有值
			}
    		return stack2.pop();
    	}
    }
}
