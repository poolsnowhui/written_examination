import java.util.Arrays;
import java.util.Scanner;

public class MainEatCake {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int T = sc.nextInt();
		int a[] = new int[T];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(eatSimpleCakes(K, T, a));

	}

	private static int eatSimpleCakes(int k, int t, int[] a) {
		Arrays.sort(a);
		for (int i = a.length - 1; i >= 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (a[i] == 0) {
					break;
				} else {
					if (a[i] >= a[j]) {
						a[i] = a[i] - a[j];
						a[j] = 0;
					} else {
						a[j] = a[j] - a[i];
						a[i] = 0;

					}
				}
			}
		}
		if (a[a.length - 1] == 0)
			return 0;
		else
			return a[a.length - 1] - 1;

	}

}
