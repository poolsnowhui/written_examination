public class SolutionTreeNode2 {
	public void Mirror(TreeNode2 root) {
		if(root==null) return;
		TreeNode2 temp = root.left;
		root.left = root.right;
		root.right = temp;
		Mirror(root.left);
		Mirror(root.right);
	}
}

class TreeNode2 {
	int val = 0;
	TreeNode2 left = null;
	TreeNode2 right = null;

	public TreeNode2(int val) {
		this.val = val;
	}

}
