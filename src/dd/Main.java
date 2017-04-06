package dd;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();// 正整数
		int count = 0;// 计数器

		int n = 2;
		while (n < num / 2 + 1) {// 遍历一半的质数
			boolean isPrime = false;
			for (int i = 2; i < n; i++) {
				if (n % i == 0) {
					isPrime = true;
					break;
				}
			}
			if (isPrime == false) {// n是质数
				if (isSushu(num - n)) {// 判断num-n是否是质数，
					count++;// 是的话计数
				}
			}
			n++;
		}
		System.out.println(count);
		sc.close();
	}

	// 判断质数
	public static boolean isSushu(int num) {

		boolean flag = false;

		if (num <= 1) {
			return false;
		} else {
			for (int i = 2; i < num; i++) {
				if (num % i == 0) {
					flag = true;
				}
			}

			if (flag) {
				return false;
			} else {
				return true;
			}

		}
	}
}
