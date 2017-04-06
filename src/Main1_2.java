import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main1_2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();

		sc.nextLine();
		
		String[] C = sc.nextLine().split(" ");

		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < C.length; i++) {
			sb.append(C[i]);
		}
		
		if (sb.toString().equals(""))
			return;
		
		Infix main = new Infix(C);
		
		ArrayList<String> output = main.doTrans();
		
		for (int i = 0; i < output.size(); i++) {
			System.out.print(output.get(i) + " ");
		}
		
		System.out.println();
	}
}

class Infix {
	private ArrayList<String> output;
	private String[] input;
	private Stack<String> stack;

	public Infix(String[] in) {
		output = new ArrayList<String>();
		input = in;
		stack = new Stack<>();
	}

	public ArrayList<String> doTrans() {
		for (int i = 0; i < input.length; i++) {
			String ch = input[i];
			// stack.display(ch);
			if (ch.equals("+") || ch.equals("-")) {
				getOper(ch, 1);
			} else if (ch.equals("*") || ch.equals("/")) {

				getOper(ch, 2);
			} else if (ch.equals("(")) {
				stack.push(ch);
			} else if (ch.equals(")")) {
				gotParen(ch);
			} else {
				output.add(ch);
			}
		} // end for
		while (!stack.isEmpty()) {
			// stack.display();
			output.add(stack.pop());
		}
		return output;
	}// end doTrans

	private void gotParen(String ch) {
		while (!stack.isEmpty()) {
			String chx = stack.pop();
			if (chx.equals("("))
				break;
			else {
				output.add(chx);
			} // endwhile
		} // endgotP

	}

	private void getOper(String op, int p) {
		while (!stack.isEmpty()) {
			String opTop = stack.pop();
			if (opTop.equals("(")) {
				stack.push(opTop);
				break;
			} else {
				int prec2;
				if (opTop.equals("+") || opTop.equals("-")) {
					prec2 = 1;
				} else {
					prec2 = 2;
				}
				if (prec2 < p) {
					stack.push(opTop);
					break;
				} else {
					output.add(opTop);
				}
			} // end while
		}
		stack.push(op);
	}
}
