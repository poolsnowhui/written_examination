import java.util.Scanner;

public class Main1_6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int x = sc.nextInt();
			tiaoYue(x);
		}
	}

	private static int tiaoYue(int x) {
		if(x==1) return 2;
		if(x==2) return 3;
		if(x%2==0)return tiaoYue(x/2)+x/2+1;//偶数
		if((x-1)%4==0) return x;//4的倍数加1
		else 
		return x;
	}
}
