package recursion;

public class Fib {
	//原始fib
	public static int fib1(int n){
		return n<2?n:fib1(n-1)+fib1(n-2);
	}
	public static int fib2(int n){
		int f =0,g=1;//fib(0),fib(1)
		if(n==0) return 0;
		while(0<--n){
			g = g+f;
			f = g-f;
		}
		return g;
	}
	public static void main(String[] args) {
		System.out.println(fib1(12));
		System.out.println(fib2(12));
	}
}
