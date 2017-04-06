import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			panDuan(n,m);
		}

	}

	private static void panDuan(int n, int m) {
		ArrayList<Integer> nSp = spl(n);
		int [] arrN = new int[nSp.size()];
		for (int i = 0; i < nSp.size(); i++) {
			arrN[i]= nSp.get(i);
		}
		Arrays.sort(arrN);
		for (int i = 0; i < arrN.length; i++) {
			if(arrN[i]!=0){
				swap(arrN,i,0);
				break;
			}
		}
		int sum=0;
		for (int i = 0; i < arrN.length; i++) {
			sum += arrN[i]*(int)Math.pow(10, arrN.length-i-1);
		}
		if(sum==m){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}

	private static void swap(int[] arrN, int i, int j) {
		int temp = arrN[i];
		arrN[i] = arrN[j];
		arrN[j] = temp;
		
	}

	private static ArrayList<Integer> spl(int n) {
		int[] nsp = new int[9];
		for (int i = 0; i < nsp.length; i++) {
			nsp[i] = n/(int)(Math.pow(10, i))%10;
		}
		ArrayList<Integer> alInt = new ArrayList<>();
		boolean flag =false;
		for (int i = nsp.length-1; i >=0; i--) {
			if(nsp[i]!=0){
				alInt.add(nsp[i]);
				flag = true;
			}else if(flag==true){
				alInt.add(nsp[i]);
			}else{
				
			}
		}
		return alInt;
	}

}
