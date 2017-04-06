import java.util.Scanner;

public class Mainjrtt1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int count = 1;

		for (int i = 1; i <= s.length() / 2; i++) {
			for (int j = 2 * i; j <= s.length(); j = j + i) {

				if (match(s, j - 2 * i, j - i, j - i, j)) {
					count++;
				} else {
					count = 1;
					break;
				}
			}
			if (count != 1)
				break;
		}
		System.out.println(count);
	}

	private static boolean match(String s, int as, int ae, int bs, int be) {
		boolean flag = false;
		for (int i = as, j = bs; i < ae && j < bs; i++, j++) {
			if (s.charAt(i) == s.charAt(j))
				flag = true;
			else {
				flag = false;
			}
		}
		return flag;
	}

}
interface INN{
	static final int br =3;
		
}