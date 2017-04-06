
public class Solution跳台阶 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution跳台阶().JumpFloor(3));
	}
    public int JumpFloor(int target) {
    	int a=1,b=0;
    	while(target-->-1){
    		b=b+a;
    		a=b-a;
    	}
    	return b;
    }

}
