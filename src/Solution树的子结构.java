import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution树的子结构 {
	/**
	 * 题目描述
	 * 输入两棵二叉树A，B，判断B是不是A的子结构。
	 * （ps：我们约定空树不是任意一个树的子结构）
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		RoundingMode mode = RoundingMode.CEILING;
		BigDecimal b1 = new BigDecimal(-11);
		BigDecimal b2 = new BigDecimal(2);
		System.out.println(b1.divide(b2,mode));
	}

    public boolean HasSubtree(TreeNode4 root1,TreeNode4 root2) {
    	if(root2==null) return false;
    	if(root1.val==root2.val
    			&&root1.left==null
    			&&root1.right==null
    			&&root2.left==null
    			&&root2.right==null
    			){
    		return true;
    	}
		return false;
    }
}