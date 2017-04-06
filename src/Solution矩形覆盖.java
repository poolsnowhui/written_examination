
public class Solution矩形覆盖 {
/**
 * 题目描述
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，
 * 总共有多少种方法？
 * @param args
 */
public static void main(String[] args) {
	
}
    public int RectCover(int target) {
    	if(target==0) return 0;
    	int a=0,b=1,c=0;
    	while(target-->-1){
    		a=b;
    		b=c;
    		c=a+b;
    	}
    	return c;

    }
}
