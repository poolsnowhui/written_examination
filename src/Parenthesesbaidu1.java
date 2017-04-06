import java.util.Stack;

public class Parenthesesbaidu1 {
	public static int balancedParentheses(String str){
		Stack<Character> s = new Stack<>();
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)=='('){
				s.push(str.charAt(i));;//左括号入栈
			}else if(str.charAt(i)==')'){
				if(!s.isEmpty()){//栈为非空，出栈
					s.pop();
					count++;
				}else{//栈为空，不平衡
					return -1;
				}
			}
		}
		if(s.isEmpty()){//栈为空，平衡
			return count;
		}else{
			return -1;
		}
	}
//	public static void main(String[] args) {
//		System.out.println(balancedParentheses("()()(())()"));
//	}
}
