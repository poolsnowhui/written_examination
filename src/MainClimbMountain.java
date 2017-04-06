import java.util.Scanner;

public class MainClimbMountain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		int[] b = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			b[i] = sc.nextInt();
		}
		System.out.println(mountainSeqNum(a, b));
	}

	private static long mountainSeqNum(int[] a, int[] b) {

		int c[] = new int[a.length];
		int pre = 0;// 上一座
		int zl[] = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			if (a[i] > pre) {
				c[i] = a[i];
				pre = a[i];
			} else {
				zl[i] = pre;
			}
		}
		int behind = 0;// 反序上一座
		for (int i = b.length - 1; i >= 0; i--) {
			if (b[i] > behind) {
				if (c[i] == 0) {
					c[i] = b[i];
					behind = b[i];
					zl[i] = 0;
				} else {
					// 存在值
					if (c[i] != b[i]) {// 不等于当前值
						return 0;
					}
				}
			} else {
				if (c[i] == 0) {
					if (zl[i] > behind) {
						zl[i] = behind;
					}
				} else {
					// 存在值时
					if (c[i] > b[i]) {
						return 0;
					}
				}
			}
		}
		long sum = 1;
		for (int i = 0; i < zl.length; i++) {
			if (zl[i] != 0) {
				sum = sum * zl[i];
				if (sum >= 1000000007) {
					sum %= 1000000007;
				}

			}
		}
		return sum;
	}
}
