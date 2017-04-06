public class X {
	private static int value;

	public class Y {
		public void s() {
			System.out.println("v" + value);
			System.out.println("v" + g());
			System.out.println("v" + X.g());
		}
	}

	public static int g() {
		return value;
	}

	public static void main(String[] args) {
		StringBuffer[] m = new StringBuffer[5];
		m[0].append("hello,world!");
		System.out.println("f" + m[0]);
	}
}
