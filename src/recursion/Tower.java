package recursion;

public class Tower {

	public static void main(String[] args) {
		doPower(10, 'A', 'B', 'C');
	}
	
	/**
	 * 汉诺塔问题
	 * @param N
	 * @param from
	 * @param mid
	 * @param to
	 */
	public static void doPower(int N,char from ,char mid,char to){
		if(N==1){
			System.out.println("doPower "+"from"+from+"to"+to);
			return ;
		}else {
			doPower(N-1, from, to, mid);
			System.out.println("doPower "+"from"+from+"to"+to);
			doPower(N-1, mid, from, to);
		}
	}
}
