import java.util.ArrayList;
import java.util.Scanner;

public class Mainwanmei1_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			luanShengSuShu(m, n);
		}
	}

	// 输出所有的素数
	private static void luanShengSuShu(int m, int n) {
		if (m <= n && m >= 100 && n <= 999) {
			boolean flag =false;
			int i, j;
			ArrayList<Integer> arInt = new ArrayList<>();
			for (i = m; i <= n; i++) {
				for (j = 2; j < i; j++) {
					if (i % j == 0)
						break;
				}
				if (j >= i)
					arInt.add(i);
			}
			for (int k = 0; k < arInt.size(); k++) {
//				System.out.println(arInt.get(k));
				if ((k + 1) < arInt.size() && (arInt.get(k + 1) - arInt.get(k) == 2)) {
					System.out.print(arInt.get(k) + " " + arInt.get(k + 1) + " ");
					flag = true;
					k++;
				}
			}
			if(flag==false){
				System.out.println("no");
			}else{
				System.out.println();
			}
		}
	}

}
