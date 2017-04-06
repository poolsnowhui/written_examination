package recursion;

public class Factorial {

	public static void main(String[] args) {
		System.out.println(factorial(5));
		System.out.println(factorial2(5));
	}
	public static int factorial(int n){
		if(n==1) return 1;
		else return n*factorial(n-1);
	}
	public static int factorial2(int n){
		int sum =1;
		for (int i = 1; i <=n; i++) {
			sum *= i;
		}
			return sum;
	}

}
