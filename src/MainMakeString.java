import java.util.Scanner;

public class MainMakeString {
	/**
	 * You are given a string S. This string consists of the 10 characters a, b,
	 * ..., j.You choose a subset of the characters a, b, ..., j, and construct
	 * a new string by removing all the characters from S that are not in the
	 * chosen subset.For example, when S is abcab and the subset is a and b, you
	 * construct abab. When S is abcab and the subset is a and c, you construct
	 * aca. Consider all the strings that can be obtained in this way and
	 * contain at least K characters. Among them, find the lexicographically
	 * smallest one.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int K = sc.nextInt();
		System.out.println(makeString(s, K));
	}

	private static String makeString(String s, int k) {
		if(k==0){
			return "";
					
		}
		char[] c = new char[k];

		int sp =0;
		int min = 0;
		for (int i = 0; i < k; ) {
			if(s.charAt(sp)<s.charAt(min)){
				min = sp;
			}
			sp++;
			if(k-i>s.length()-sp){
				c[i] = s.charAt(min);
				i++;
				min =min+1;
				sp = min;
			}
		}

		// TODO Auto-generated method stub
		return new String(c);
	}
}
