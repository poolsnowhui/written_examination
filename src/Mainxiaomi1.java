import java.util.Scanner;

public class Mainxiaomi1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		TreeNode root = new TreeNode(0);
		for (int i = 0; i < n-1; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			TreeNode.construct(root, r, c);
		}
		System.out.println(TreeNode.getMaxHeight(root));
		sc.close();
	}
}

class TreeNode {
	int value;
	TreeNode left ;
	TreeNode right ;

	public TreeNode(int value) {
		this.value = value;
	}
	public static int getMaxHeight(TreeNode root){
		if(root==null){
			return 0;
		}else{
			int left = getMaxHeight(root.left);
			int right = getMaxHeight(root.right);
			return 1+Math.max(left, right);
		}
	}
	public static void construct(TreeNode head,int root,int chid){
		TreeNode cur = find(head,root);
		if(cur.left==null){
			cur.left = new TreeNode(chid);
		}else{
			cur.right = new TreeNode(chid);
		}
	}
	private static TreeNode find(TreeNode head,int root) {
		if(head==null){
			return null;
		}else if(head.value==root){
			return head;
		}else {
			TreeNode l = find(head.left, root);
			TreeNode r = find(head.right, root);
			if(l!=null) return l;
			else return r;
		}
		
	}
}