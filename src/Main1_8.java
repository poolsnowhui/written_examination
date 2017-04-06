import java.util.Scanner;

public class Main1_8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String fa = sc.nextLine();
			String tr = sc.nextLine();
			zhaoXiangTong(tr, fa);
			System.out.println("0 0 0");
		}
	}

	private static void zhaoXiangTong(String tr, String fa) {
		boolean flag = false;
		int same = 0;
		int j2=0;
		for (int i = 0; i < fa.length(); i++) {
			for (int j = j2; j < tr.length(); j++) {

				if (fa.charAt(i) == tr.charAt(j)) {
					if (flag == false) {
						System.out.print(i + " " + j + " ");
					}
					flag = true;
					same++;
					i++;
					if(j==tr.length()-1){
						if (flag == true) {
							System.out.println(same);
							same = 0;
							j2 = j;
						}
						return;
					}
				} else {
					if (flag == true) {
						System.out.println(same);
						same = 0;
						j2 = j;
					}
					flag = false;
				}
			}
		}
		if (flag == true) {
			System.out.println(same);
		}
	}

}
