
public class Base {

	private String baseName = "base";

	public Base() {
		callName();
	}

	public void callName() {
		System.out.println(baseName);

	}

	static class Sub extends Base {
		private String baseName = "sub";

		@Override
		public void callName() {
			System.out.println(baseName);
		}
	}

	public static void main(String[] args) {
		Base b = new Sub();
		System.out.println(b.baseName);
	}

}
