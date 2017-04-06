import java.util.Scanner;

public class Maincp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int bc[][] = new int[M][2];
		for (int i = 0; i < M; i++) {
			bc[i][0] = sc.nextInt();
			bc[i][1] = sc.nextInt();
		}
		cp(N,bc);
	}

	private static void cp(int n, int[][] bc) {
		int re[][] = new int[n+1][2];
		for (int i = 1; i <= n; i++) {
			re[i][0] = i;
		}
		for (int i = 0; i < bc.length; i++) {
			if(re[bc[i][0]][1] == 0) {
				re[bc[i][0]][1] = bc[i][1];
				fz(re,bc[i][0],bc[i][1]);
			}else{
				if(re[bc[i][0]][0]==re[bc[i][0]][1])
				fz(re,bc[i][0],bc[i][1]);
			}
		}
		for (int i = 1; i < re.length; i++) {
			System.out.print(re[i][0]);
			System.out.println(" "+re[i][1]);
		}
		// TODO Auto-generated method stub
		
	}

	private static void fz(int[][] re, int i,int j) {
		for (int k = 1; k < re.length; k++) {
			if(re[k][1]==0){
				int temp = re[k][0];
				re[k][0] = re[i][0];
				re[i][0] =temp;//交换
				re[i][1] =j;
				break;
			}else{
				if(re[k][1]==j) continue;
			}
		}
		
	}

}
