public class Solution数组中的逆序对 {
	/**
	 * 题目描述 在数组中的两个数字，如果前面一个数字大于后面的数字， 则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
	 * 并将P对1000000007取模的结果输出。 即输出P%1000000007 输入描述: 题目保证输入的数组中没有的相同的数字 数据范围：
	 * 对于%50的数据,size<=10^4 对于%75的数据,size<=10^5 对于%100的数据,size<=2*10^5 输入例子:
	 * 1,2,3,4,5,6,7,0 输出例子: 7
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		int[] array = { 364, 637, 341, 406, 747, 995, 234, 971, 571, 219, 993, 407, 416, 366, 315, 301, 601, 650, 418,
				355, 460, 505, 360, 965, 516, 648, 727, 667, 465, 849, 455, 181, 486, 149, 588, 233, 144, 174, 557, 67,
				746, 550, 474, 162, 268, 142, 463, 221, 882, 576, 604, 739, 288, 569, 256, 936, 275, 401, 497, 82, 935,
				983, 583, 523, 697, 478, 147, 795, 380, 973, 958, 115, 773, 870, 259, 655, 446, 863, 735, 784, 3, 671,
				433, 630, 425, 930, 64, 266, 235, 187, 284, 665, 874, 80, 45, 848, 38, 811, 267, 575 };
		System.out.println(new Solution数组中的逆序对().InversePairs(array));
		for (int i : array) {
			System.out.print(i + ",");
		}
		System.out.println();
	}

	public int InversePairs(int[] array) {
		int[] copy = new int[array.length];
		int low = 0;
		int high = array.length - 1;
		int count = mergeSort(array, copy, low, high);
		return count;
	}

	private int mergeSort(int[] array, int[] copy, int low, int high) {
		if (low == high)
			return 0;
		int mid = (low + high) / 2;
		int count = 0;
		// 左
		int leftCount = mergeSort(array, copy, low, mid);
		// 右
		int rightCount = mergeSort(array, copy, mid + 1, high);
		int i = mid, j = high;
		int local = high;
		while (i >= low && j > mid) {
			if (array[i] > array[j]) {
				count += j - mid;
				if (count >= 1000000007)
					count %= 1000000007;
				copy[local--] = array[i--];
			} else {
				copy[local--] = array[j--];
			}
		}
		for (; i >= low;) {
			copy[local--] = array[i--];
		}
		for (; j > mid;) {
			copy[local--] = array[j--];
		}
		for (int k = low; k <= high; k++) {
			array[k] = copy[k];
		}
		return (leftCount + rightCount + count) % 1000000007;

	}

}