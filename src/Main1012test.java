/**
 * 
 * @author CXH
 *
 */
public class Main1012test {

	public void add(Byte b){
		b=b++;
	}
	public void test(){
		Byte a =127;
		Byte b = 127;
		add(++a);
		System.out.print(a+" ");
		add(b);
		System.out.print(b+"");
	}
	public static void main(String[] args) {
		new Main1012test().test();

	}

}
