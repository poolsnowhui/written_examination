public class Main1010 {
	public static void main(String[] args) {

		int[] a = { 1, 1, 1, 0, 0 };
		int r = 0;
		for (int i = 0; i < a.length; i++) {
			r += a[i] * Math.pow(2, i);
		}
		System.out.println(r);
		r = r - 7;
		System.out.println(r);
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			b[i] = r % (int) (Math.pow(2, i + 1)) / (int) (Math.pow(2, i));
		}
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}
}
