
public class TransposeMultbaidu {
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public static int[][] transposeMultMatrix(int initialValue, int rows, int columns) {

		int[][] result = new int[rows][columns];
		int max = Math.max(rows, columns);
		int[][] result2 = new int[max][max];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				result[i][j] = initialValue++;
			}
		}
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < max; j++) {
				for (int k = 0; k < result[0].length; k++) {
					result2[i][j] += result[i][k] * result[k][j];
				}
			}
		}
		return result2;
	}
	public static void main(String[] args) {
		int [][] r = transposeMultMatrix(3, 4, 2);
		for (int i = 0; i < r.length; i++) {
			for (int j = 0; j < r[0].length; j++) {
				System.out.println(r[i][j]);
			}
		}
	}
	// METHOD SIGNATURE ENDS
}