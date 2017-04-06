import java.util.Arrays;
import java.util.Scanner;

public class MainIndeed4 {

	public static String str(int all, String num) {
		String str = "";
		for (int i = 1; i <= all - num.length(); i++) {
			str += "0";
		}
		return str + num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 9; // 一个多少位最好小点,太大了运行慢
		String num = "";
		for (int i = 1; i <= n; i++) {
			num += "9";
		}
		for (int i = 1; i <= new Integer(num); i++) {
			System.out.println(str(n, i + ""));
		}
		
		
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();

		System.out.println(solution(s));

	}

	private static int solution(String s) {
		int[] ys = new int[s.length()];
		for (int i = 0; i < ys.length; i++) {
			ys[i] =i%10;
		}//01234567890123

		
		int countw = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '?') {
				countw++;
			}
		}
		int counts = 0;
		if (s.length() <= 10) {
			counts = s.length() - countw;
		}
		int sum = 1;
		for (int i = 0; i < countw; i++) {
			sum *= (10 - counts - i);
		}
		return sum;
	}

	private static boolean zDistict(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		for (int i = 1; i < c.length; i++) {
			if (c[i - 1] == c[i])
				return false;
		}
		return true;
	}
}
