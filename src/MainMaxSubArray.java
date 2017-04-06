import java.util.Scanner;
/**
 * 求最大子串和
 * @author CXH
 *
 */
public class MainMaxSubArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s[] = new int[] { -2, 1, -3, 4, -1, 2, 1, 5, 4 };
		int N = sc.nextInt();
		s = new int[N];
		for (int i = 0; i < s.length; i++) {
			s[i] = sc.nextInt();
		}
		
		System.out.println(maxSubArray(s));
	}

	private static int maxSubArray(int[] s) {
		int curMax = 0, Max = 0;
		for (int i = 0; i < s.length; i++) {
			curMax += s[i];
			if (curMax > 0) {
				if (curMax > Max) {
					Max = curMax;// 当前子串和比Max大时覆盖
				}
			} else {
				curMax = 0;

			}
		}
		return Max;

	}
}
