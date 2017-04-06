import java.util.Scanner;

public class Main3602 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[][] cha = new char[3][3];
		while (sc.hasNext()) {
			String[] a = new String[3];
			for (int i = 0; i < 3; i++) {
				a[i] = sc.nextLine();
			}
			boolean flag = false;
			for (int i = 0; i < cha.length; i++) {
				for (int j = 0; j < a.length; j++) {
					cha[i][j] = a[i].charAt(j);
					if(cha[i][j]==' '){
						flag = false;
					}else{
						flag =true;
					}
				}
			}
			panDun(cha);
		}
	}

	private static void panDun(char[][] cha) {
		if(cha==null||cha.length==0){
			System.out.println("NO");
			return;
		}
		
		boolean flag = false;
		for (int i = 0; i < cha.length; i++) {
			for (int j = 0; j < i; j++) {
				if (cha[i][j] != cha[2 - i][2 - j]) {
					System.out.println("NO");
					return;
				} 
				if(cha[i][j]==' '){
					flag=false;
				}else{
					flag=true;
				}
			}
		}
		if(flag){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
			
	}
}
