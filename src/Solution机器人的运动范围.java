
public class Solution机器人的运动范围 {

	/**
	 * 地上有一个m行和n列的方格。一个机器人从坐 标0,0的格子开始移动，每一次只能向左，右， 上，下四个方向移动一格，但是不能进入行坐标
	 * 和列坐标的数位之和大于k的格子。 例如，当k为 18时，机器人能够进入方格（35,37），因为3+5 +3+7 =
	 * 18。但是，它不能进入方格（35,38）， 因为3+5+3+8 = 19。请问该机器人能够达到多少 个格子？
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new Solution机器人的运动范围().movingCount(4, 4, 4);

	}

	public int movingCount(int threshold, int rows, int cols) {
		boolean flag[][] = new boolean[rows][cols];
		int count = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (check(threshold, flag, rows, cols, i, j)) {
					flag[i][j] = true;
					count++;
					System.out.println(count);
				}
			}
		}
		System.out.println(count);
		return count;
	}

	private boolean check(int threshold, boolean[][] flag, int rows, int cols, int i, int j) {
		if (!flag[i][j] && (getNum(i) + getNum(j)) <= threshold) {
			if ((i == 0 && j == 0) || (i - 1 >= 0 && flag[i - 1][j]) || (j - 1 >= 0 && flag[i][j - 1])) {// 上面或者左边连通了
				return true;
			}
		}
		return false;
	}

	/**
	 * 位数和
	 * 
	 * @param n
	 * @return
	 */
	private int getNum(int n) {
		int sum = 0;
		while (n > 0) {
			sum += n % 10;
			n = n / 10;
		}
		return sum;
	}

}
