
public class Solution二进制中1的个数 {

	/**
	 * 题目描述 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution二进制中1的个数().NumberOf1(-1));
	}

	public int NumberOf1(int n) {
		int count = 0;
		int j = 1;
		for (int i = 0; i < 32; i++, j <<= 1)

			if ((n & j) != 0)
				count++;

		return count;
	}
}
