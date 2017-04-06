
public class Main111 {

	public static void main(String[] args) {

		Inter in = new Sub();
		in.f8();
		Inter.f9();
		in.f10();
		System.out.println(in.a);
		System.out.println(in.b);
		System.out.println(in.c);
		Sub sub = new Sub();
		sub.f8();
		sub.f9();
		sub.f10();
		System.out.println(sub.a);
		System.out.println(sub.b);
		System.out.println(sub.c);
	}
}

interface Inter {
	final int a = 0;
	static int b = 1;
	public int c = 2;

	abstract void f8();

	static void f9() {
		System.out.println("static f9");
	};

	default void f10() {
		System.out.println("default f10");
	};
}

abstract class AB {
	final int a = 0;
	static int b = 1;
	public int c = 2;
	protected int b1 = 1;
	public int c1 = 2;
	int d1 = 3;

	abstract void f8();

	static void f9() {
		System.out.println("static f9");
	};

	void f10() {
		System.out.println("default f10");
	};
}

class Sub implements Inter {

	@Override
	public void f8() {
		System.out.println("Sub f8");
	}

	static void f9() {
		System.out.println("Sub f9");
	}

	@Override
	public void f10() {
		System.out.println("Sub f10");
	}

}
