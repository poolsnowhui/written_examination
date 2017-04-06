import java.util.ArrayList;

public class Solution蛇形矩阵 {

	public ArrayList<Integer> printMatrix(int[][] matrix) {
		int N = matrix[matrix.length - 1][matrix[0].length - 1];
		int row = matrix.length, col = matrix[0].length;
		int s = -1, x = row, z = -1, y = col;
		int fx = 1;// 1右，2下，3左，4上
		ArrayList<Integer> al = new ArrayList<>();
		int i = 0, j = 0;
		for (int k = 0; k < N; k++) {
			al.add(matrix[i][j]);
			if (s + 1 == x - 1 && z + 1 == y + 1)
				break;
			switch (fx) {
			case 1:
				if (j < y - 1)
					j++;
				else {
					fx = 2;
					s++;
					i++;
				}
				break;
			case 2:
				if (i < x - 1)
					i++;
				else {
					fx = 3;
					y--;
					j--;
				}
				break;
			case 3:
				if (j > z + 1)
					j--;
				else {
					fx = 4;
					x--;
					i--;
				}
				break;
			case 4:
				if (i > s + 1)
					i--;
				else {
					fx = 1;
					z++;
					j++;
				}
				break;

			default:
				break;
			}
		}
		for (int k = 0; k < al.size(); k++) {
			System.out.print(al.get(k));
			if (k != al.size() - 1) {
				System.out.print(",");
			} else {
				System.out.println();
			}
		}
		return al;
	}

}
