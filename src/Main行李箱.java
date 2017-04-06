import java.util.Arrays;
import java.util.Scanner;

public class Main行李箱 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		sc.nextLine();
		String b[] = sc.nextLine().split(" ");
		int a[] = new int[b.length];
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.valueOf(b[i]);
		}
		Arrays.sort(a);
		System.out.println(maxHeight(m,a));
	}

	private static int maxHeight(int m,int[] a) {
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			if(m>a[i]){
				int temp  = a[i]+maxHeight(m-a[i], Arrays.copyOfRange(a, i+1, a.length));
				if(max<temp) {
					max =temp;
				}
			}else if(m==a[i]){//刚好匹配
				return m;
			}else{
				return -1;//不匹配
			}
		}
		return max;
	}
}
