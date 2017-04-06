import java.util.Scanner;

public class Main2 {

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
		int min=Math.min(arrInt[0], arrInt[1]);
		int lirun = Math.max(arrInt[0], arrInt[1])-min;
		for (int i = 2; i < arrInt.length; i++) {
			if(min>arrInt[i-1]){
				min =arrInt[i-1];
			}
			if(arrInt[i]-min>lirun){
				lirun = arrInt[i]-min;
			}
		}
		return lirun;
		
	}

}