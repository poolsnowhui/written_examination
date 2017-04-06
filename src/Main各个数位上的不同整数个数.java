import java.util.Scanner;

public class Main各个数位上的不同整数个数 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(geShu(n));
	}

	private static long geShu(int n) {
		if (n > 10)
			n = 10;
		long d = (long) Math.pow(10, n);
		String s;
		long count = 0;
		for (long i = 0; i < d; i++) {
			s = i + "";
			if (isSimple(s)) {
				count++;
			}
		}

		return d - count;
	}

	public static boolean isSimple(String s) {
		char[] a = s.toCharArray();
		int[] b = new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
		for (int i = 0; i < a.length; i++) {
			if (b[a[i] - '0'] == -1) {
				b[a[i] - '0'] = a[i] - '0';
			} else {
				return true;
			}
		}
		return false;
	}

}
