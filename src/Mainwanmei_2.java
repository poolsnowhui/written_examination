import java.util.Scanner;

public class Mainwanmei_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			luSheng(m, n);
		}
	}

	private static void luSheng(int m, int n) {//孪生质数
		boolean flag = false;
		if (m <= n && m >= 100 && n <= 999) {
			for (int i = m; i <= n; i++) {
				if (isPrime(i) && (i + 2) <= n && isPrime(i + 2)) {//i和i+2是质数，输出
					System.out.print(i + " " + (i + 2) + " ");
					flag = true;
				}
			}
			if (flag == false) {
				System.out.println("no");
			} else {
				System.out.println();
			}
		} else {
			return;
		}
	}

	static boolean isPrime(int n) {
		if (n < 2) {
			// 小于2的数即不是合数也不是素数
			return false;
		}
		int aPrimeList[] = { 2, 3, 5, 7, 11, 17, 19, 23, 
				29, 31, 41, 43, 47, 53, 59, 67, 
				71, 73, 79, 83, 89, 97 };
		int nListNum = aPrimeList.length;
		for (int i = 0; i < nListNum; ++i) {
			// 按照素数表中的数对当前素数进行判断
			if (1 != montgmery(aPrimeList[i], n - 1, n)) // 蒙格马利算法
			{
				return false;
			}
		}
		return true;
	}

	static int montgmery(int num, int index, int mod)// 蒙格马利法
												
	{
		int tmp = 1;// 保存奇数是剩下的那个数
		num %= mod; // 假设(2^7)%3 2%3
		while (index > 1) {
			if ((index & 1) == 1) // 按位与 ，除最低位不变其他位置0 ，如果为1 说明是奇数，否则偶数
			{
				tmp = (tmp * num) % mod;// 假设(2^7)%3 第一次为 1%3=1 (1%3)(2%3)%3=2%3
										// 第二次 为((2%3)*(4%3))%3=8%3
			}
			num = (num * num) % mod;// (2%3)(2%3)%3=4%3 (4%3)(4%3)%3=16%3
			index /= 2;
		}
		int result = (num * tmp) % mod; // (16%3)(8%3)%3=(2^7)%3
		return result;
	}
}
