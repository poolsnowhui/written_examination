import java.util.Arrays;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution重建二叉树 {
	/**
	 * 题目描述 输入某二叉树的前序遍历和中序遍历的结果， 请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
	 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}， 则重建二叉树并返回。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
		TreeNode4 root = new Solution重建二叉树().reConstructBinaryTree(pre, in);
		TreeNode4.hou(root);
	}

	public TreeNode4 reConstructBinaryTree(int[] pre, int[] in) {
		if (pre.length == 0)
			return null;
		TreeNode4 root = new TreeNode4(pre[0]);

		int i = 0;
		for (; i < in.length; i++) {
			if (pre[0] == in[i])
				break;
		}
		root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), 
				Arrays.copyOfRange(in, 0, i));
		root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length),
				Arrays.copyOfRange(in, i + 1, in.length));

		return root;

	}
}

class TreeNode4 {
	int val;
	TreeNode4 left;
	TreeNode4 right;

	TreeNode4(int x) {
		val = x;
	}

	public static void hou(TreeNode4 root) {
		if (root == null)
			return;
		if (root.left != null)
			hou(root.left);
		if (root.right != null)
			hou(root.right);
		System.out.println(root.val);
	}

}