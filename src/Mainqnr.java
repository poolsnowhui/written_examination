import java.util.Arrays;
import java.util.Scanner;

public class Mainqnr {
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
		for (int i = n.length - 1; i >= 0; i--) {
			temp = N;
			if (n[i] == N)
				return 1;
			if (n[i] < N) {// 比N小的房费
				N = N - n[i];
				count++;
				for (int j = i; j >= 0; j--) {
					if (N > n[j]) {
						N = N - n[j];
						count++;
						j++;
					} else if (N == n[j]) {
						N = N - n[j];
						count++;
						break;
					} else {// N<n[j]

					}
				}
				if (N == 0)
					return count;
				N = temp;
				count = 0;
			}

		}
		return -1;
	}

}
