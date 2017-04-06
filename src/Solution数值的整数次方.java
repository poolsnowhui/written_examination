public class Solution数值的整数次方 {
	/**
	 * 题目描述 给定一个double类型的浮点数base和int类型的整数exponent。 求base的exponent次方。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public double Power(double base, int exponent) {
		if(exponent<0){
			return 1/Power(base, 0-exponent);
		}
		int sum=1;
		while (exponent-->0) {
			sum *=base;
		}
		return sum;
	}
}