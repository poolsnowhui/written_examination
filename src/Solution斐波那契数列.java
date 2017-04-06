
public class Solution斐波那契数列 {
	/**
	 * 题目描述
	 * 大家都知道斐波那契数列，
	 * 现在要求输入一个整数n，
	 * 请你输出斐波那契数列的第n项。n<=39
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution斐波那契数列().Fibonacci(2));
	}
    public int Fibonacci(int n) {
    	int a=0,b=1,c=0;
    	while(n-->0){
    		a=b;
    		b=c;
    		c=b+a;
    	}
    	return c;
    }
}
