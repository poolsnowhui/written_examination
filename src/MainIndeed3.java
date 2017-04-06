import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainIndeed3 {
	public static int total = 0;
	public static ArrayList<Integer[][]> als = new ArrayList<>();

	public static void swap(Integer[][] str, int i, int j) {
		Integer[] temp = new Integer[2];
		temp = str[i];
		str[i] = str[j];
		str[j] = temp;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int a[] = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}
		Integer b[][] = new Integer[M][2];
		for (int i = 0; i < M; i++) {
			b[i][0] = sc.nextInt();
			b[i][1] = sc.nextInt();
		}

		System.out.println(fz(a, b));

	}

	private static int fz(int[] a, Integer[][] b) {

		arrange(b, 0, b.length);
		for (int i = 0; i < als.size(); i++) {
			for (int j = 0; j < als.get(i).length; j++) {
				System.out.print(als.get(i)[j][0] + "," + als.get(i)[j][1] + " ");
			}
			System.out.println();
		}
		int maxQ = 0;
		for (int i = 0; i < als.size(); i++) {
			int[] acopy = Arrays.copyOf(a, a.length);

			for (int j = 0; j < als.get(i).length; j++) {
				swap(acopy, als.get(i)[j][0] - 1, als.get(i)[j][1] - 1);
			}
			int score = 0;
			for (int j = 0; j < acopy.length; j++) {
				score += (j + 1) * acopy[j];
			}
			if (maxQ < score) {
				maxQ = score;
			}
		}
		return maxQ;
	}

	private static void swap(int[] acopy, int i, int j) {
		int temp = acopy[i];
		acopy[i] = acopy[j];
		acopy[j] = temp;

	}

	private static void arrange(Integer[][] b, int st, int len) {
		Integer[][] s = new Integer[b.length][b[0].length];
		if (st == len - 1) {
			for (int i = 0; i < len; i++) {
				s[i] = b[i];
			}
			total++;
		} else {
			for (int i = st; i < len; i++) {
				swap(b, st, i);
				arrange(b, st + 1, len);
				swap(b, st, i);
			}
		}
		if (s[0][0] != null) {
			als.add(s);
		}
	}
}
