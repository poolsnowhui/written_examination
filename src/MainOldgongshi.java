import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class MainOldgongshi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int A[] = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		evaluate(A, K);

	}

	private static void evaluate(int[] a, int k) {
		Arrays.sort(a);
		int value = 0;
		Stack<Integer> s = new Stack<>();
		int tempyu[] = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			s.push(a[i]);
		}
		for (int i = 0; i < a.length; i++) {
			Integer temp = s.pop();
			if(k/temp<=1) {
				tempyu[i] = temp;
				s.push(temp);
				break;
			}
			tempyu[i] = k%temp;
		}
		
		
	}

}
