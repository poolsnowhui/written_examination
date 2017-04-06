package recursion;

public class LCS {

	
	public static void main(String[] args) {
		char[] a ={'d','a','t','a'};
		char[] b ={'i','a','t','a'};
		System.out.println(lcs(a, a.length-1, b, b.length-1));
	}
	/**
	 * 最长公共子串
	 * @param a
	 * @param an
	 * @param b
	 * @param bn
	 * @return
	 */
	public static String lcs(char[]a,int an,char[]b,int bn){
		if(an==-1||bn==-1)
			return "";
		if(a[an]==b[bn]){
			return lcs(a, an-1, b, bn-1)+a[an];
		}else{
			String s1 =  lcs(a, an-1, b, bn);
			String s2 =  lcs(a, an, b, bn-1);
			return s1.length()>s2.length()?s1:s2;
		}
	}
}
