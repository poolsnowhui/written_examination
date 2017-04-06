import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Mainss {
	public static final String ZIMU[] = { "ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT",
			"NINE" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		String s[] = new String[T];
		for (int i = 0; i < T; i++) {
			s[i] = sc.nextLine();
		}
		for (int i = 0; i < s.length; i++) {
			minFenShen(s[i]);
		}
	}

	private static void minFenShen(String s) {
		int n[] = fenShen(s);
		if(n==null)return;
		int haoMa[] = new int[n.length];
		for (int i = 0; i < n.length; i++) {
			haoMa[i] = (n[i] + 10 - 8) % 10;
		}
		Arrays.sort(haoMa);
		for (int i = 0; i < haoMa.length; i++) {
			System.out.print(haoMa[i]);
		}
		System.out.println();

	}

	private static int[] fenShen(String s) {
		ArrayList<Integer> arInt = new ArrayList<>();
		boolean flag = false;
		String temp = "";

		for (int i = 0; i < ZIMU.length; i++) {
			temp = s;
			for (int j = 0; j < ZIMU[i].length(); j++) {
				if (!s.contains(String.valueOf((ZIMU[i].charAt(j))))) {
					flag = false;
					break;
				} else {
					flag = true;
					temp = temp.replaceFirst(String.valueOf(ZIMU[i].charAt(j)), "");
				}
			}
			if (flag) {
				arInt.add(i);
				s = temp;
				i--;
			} else {

			}
		}
		if(s.length()==0){
			
		int[] n = new int[arInt.size()];
		for (int i = 0; i < arInt.size(); i++) {
			n[i] = arInt.get(i);
		}
		return n;
		}else{
			return null;
		}

	}
}
