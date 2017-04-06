class TNode {
	public int value;
	public TNode left;
	public TNode right;
}

public class BstMinSum {

	public static int minTreePath(TNode t) {
		return findShortestWay(t);

	}

	private static int findShortestWay(TNode root) {
		int l = 0;
		int r = 0;
		if (root == null) {
			return 0;
		} else if (root.left != null && root.right != null) {
			l = findShortestWay(root.left);
			r = findShortestWay(root.right);
			return root.value + Math.min(l, r);
		} else if (root.left == null) {
			return root.value + findShortestWay(root.right);
		} else{
			return root.value + findShortestWay(root.left);
		}

	}

	public static void main(String[] args) {
	}
}