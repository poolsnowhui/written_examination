import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x, n;
		x = sc.nextInt();
		n = sc.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = sc.nextInt();
		}
		System.out.println(ef(ar, x));
		sc.close();

	}

	private static int ef(int[] ar, int x) {
		int low = 0, high = ar.length - 1;
		int mid = (low + high) / 2;
		while (low <= high) {
			mid = low + high;
			if (ar[mid] == x) {
				return mid;
			} else if (ar[mid] > x) {
				high = mid - 1;
			} else if (ar[mid] < x) {
				low = mid + 1;
			}
		}
		return -1 - low;
	}

}
