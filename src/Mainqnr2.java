import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Mainqnr2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = sc.nextLine().split(" ");
		int[] n = new int[s.length - 1];
		for (int i = 0; i < s.length - 1; i++) {
			n[i] = Integer.valueOf(s[i]);
		}
		int N = Integer.valueOf(s[s.length - 1]);
		System.out.println(jiuDian(n, N));

	}

	private static int jiuDian(int[] n, int N) {
		Arrays.sort(n);
		if (N < n[0])
			return -1;
		int count = 0;
		int temp = 0;
		int tempj = 0;
		Stack<Integer> s = new Stack<>();
		for (int i = n.length - 1; i >= 0; i--) {

			if (n[i] <= N) {// 比N小的房费
				for (int j = i; j >= 0; j--) {
					if (N >= n[j]) {
						s.push(n[j]);
						N = N - n[j];
						count++;
						j++;
						if (N == 0)
							return count;
					} else {// N<n[j]
						temp = s.pop();
						N = N + temp;
						count--;
						if (j == 0) {
							temp = s.pop();
							N = N + temp;
							count--;
							break;
						}
					}

				}

			}

		}
		return -1;
	}

}
