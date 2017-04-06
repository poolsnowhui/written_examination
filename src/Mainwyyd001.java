
public class Mainwyyd001 {
	public static void main(String[] args) {
		String str1 = "hello";
		String str2 = "hell" + new String("o");
		System.out.println(str1 == str2);
		System.out.println(f(4, 5));
	}

	public static int f(int n, int m) {
		if (n <= 0 || m <= 0)
			return 0;
		if (n == 1)
			return m;
		if (m == 1)
			return n;
		return f(n - 1, m) + f(n, m - 1);
	}
}
