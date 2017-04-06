import java.util.Scanner;

public class Main行列式 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		sc.nextLine();
		int A[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				A[i][j] = sc.nextInt();
			}
		} // A
		sc.nextLine();
		int B[][] = new int[M][K];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < K; j++) {
				B[i][j] = sc.nextInt();
			}
		} // B
		product(A, B);

	}

	private static void product(int[][] a, int[][] b) {
		for (int ai = 0; ai < a.length; ai++) {
			for (int bj = 0; bj < b[0].length; bj++) {
				int sum = 0;
				for (int aj = 0; aj < a[0].length; aj++) {
					sum += a[ai][aj] * b[aj][bj];
				}
				System.out.print(sum + " ");
			}
			System.out.println();
		}
	}
}
