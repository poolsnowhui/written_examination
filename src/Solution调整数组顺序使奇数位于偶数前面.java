
public class Solution调整数组顺序使奇数位于偶数前面 {

	/**
	 * 题目描述 输入一个整数数组，实现一个函数来调整该数组中数字的顺序， 使得所有的奇数位于数组的前半部分，
	 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数， 偶数和偶数之间的相对位置不变。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		new Solution调整数组顺序使奇数位于偶数前面().reOrderArray(array);
		for (int i : array) {
			System.out.print(i + ",");
		}
		System.out.println();
	}

	public void reOrderArray(int[] array) {
		int i = 0, j = 0;
		boolean flag = false;
		for (; i < array.length && j < array.length;) {
			if (flag) {// 找到第一个奇数后交换
				for (int k = j; k > i; k--) {
					swap(array, k, k - 1);
				}
				i++;
				j++;
				flag = false;
			} else {

				if ((array[j] & 1) == 1) {
					flag = true;// 找到第一个奇数
				} else {
					j++;
				}
			}
		}
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
