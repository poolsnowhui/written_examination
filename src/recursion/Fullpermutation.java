package recursion;

import java.util.Scanner;

public class Fullpermutation {

	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = null;
		try {

			sc = new Scanner(System.in);
			String str = "";
			while (true) {
				str = sc.nextLine();
				char[] c = str.toCharArray();
				fullPermutation2(c);
				count = 0;
			}
		} catch (Exception e) {

		} finally {
			sc.close();
		}
	}

	public static void fullPermutation2(char[] arrChar) {
		display(arrChar);
		while (hasNext(arrChar)) {// 遍历有后继
			next(arrChar);// 找到后继然后打印
			display(arrChar);
		}
	}

	private static void next(char[] arrChar) {
		int top = 0;
		int m = arrChar.length - 1;
		// 找到峰值
		for (int i = m; i > 0; i--) {
			if (arrChar[i] > arrChar[i - 1]) {
				top = i;
				break;
			}
		}
		// 找到要交换的数
		int mm = top;
		int cz = 0;
		for (int i = top + 1; i < arrChar.length; i++) {
			if (arrChar[i] - arrChar[top - 1] > 0) {
				int temp = arrChar[i] - arrChar[top - 1];
				if (cz == 0) {
					cz = temp;
				}
				if (temp <= cz) {
					cz = temp;
					mm = i;
				}
			} // 大于某个数的最小值
		}
		swap(arrChar, top - 1, mm);
		// display(arrChar);
		// 颠倒后面的数
		for (int i = 0; i <= (top + m) / 2 - top; i++) {
			swap(arrChar, i + top, m - i);
			// display(arrChar);
		}
	}

	private static void swap(char[] arrChar, int a, int b) {
		char temp = arrChar[a];
		arrChar[a] = arrChar[b];
		arrChar[b] = temp;
	}

	private static boolean hasNext(char[] arrChar) {
		int m = arrChar.length - 1;
		for (int i = m; i > 0; i--) {
			if (arrChar[i] > arrChar[i - 1])
				return true;// 后面的数大于前面的数
		}
		return false;
	}

	public static void fullPermutation(char[] arrChar, int newSize) {
		if (newSize == 1) {
			return;
		}
		for (int i = 0; i < newSize; i++) {
			fullPermutation(arrChar, newSize - 1);
			if (newSize == 2) {
				display(arrChar);
			}
			rotate(arrChar, newSize);
		}
	}

	private static void rotate(char[] arrChar, int newSize) {

		char temp = arrChar[arrChar.length - newSize];
		int i = 0;
		for (i = arrChar.length - newSize; i < arrChar.length - 1; i++) {
			arrChar[i] = arrChar[i + 1];
		}
		arrChar[i] = temp;

	}

	private static void display(char[] arrChar) {
		for (int i = 0; i < arrChar.length; i++) {
			System.out.print(arrChar[i]);
		}
		count++;
		if (count % 10 == 0) {
			System.out.println(" " + count);
		} else {
			System.out.print(" ");
		}
	}

}
