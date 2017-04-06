import java.util.Scanner;

public class Main1_1{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			StringBuffer sb = new StringBuffer(sc.nextLine());
			int times = 0;

			for (int i = 0; i < sb.length() - times; i++) {
				if (Character.isLowerCase(sb.charAt(i)))
					continue;
				sb.append(sb.charAt(i));
				sb.delete(i, i + 1);
				times++;
				i--;
			}
			System.out.println(sb);
		}
		sc.close();
	}
}