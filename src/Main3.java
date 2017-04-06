import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String [] arrStr = str.split(",");
		int [] arrInt = new int[arrStr.length];
		for (int i = 0; i < arrInt.length; i++) {
			arrInt[i] = Integer.valueOf(arrStr[i]);
		}
		System.out.println(maxLirun(arrInt));
		sc.close();
	}
	
	private static int maxLirun(int[] arrInt) {
		int maxP =0;
		for (int i = 0; i < arrInt.length; i++) {
			for (int j = i; j < arrInt.length; j++) {
				if(arrInt[j]-arrInt[i]>maxP){
					maxP = arrInt[j]- arrInt[i];
				}
			}
		}
		return maxP;
		
	}

}
