import java.util.ArrayList;
import java.util.Arrays;

public class Solutionbaidu3 {
	public static void main(String[] args) {
		Solutionbaidu3 s = new Solutionbaidu3();
		int[][] co = new int[][] { { 1, 2 }, { 1, 3 }, { 2, 4 }, { 2, 5 }, { 3, 6 }, { 3, 7 }, { 6, 8 } };
		s.collectApples(8, 4, new int[] { 2, 3, 4, 6, }, co);
	}

	int collectApples(int N, int K, int[] applesAtNodes, int[][] connectedNodes) {

		int temp = connectedNodes[0][0];
		LinkNode root = new LinkNode(0, 1);
		Tree tree = new Tree(root);
		ArrayList<Integer> arInt = new ArrayList<>();
		for (int i = 0; i < connectedNodes.length; i++) {
			if (connectedNodes[i][0] == temp) {
				arInt.add(connectedNodes[i][1]);
			} else {
				int[] index = new int[arInt.size()];
				for (int j = 0; j < arInt.size(); j++) {
					index[j] = arInt.get(j);
				}
				tree.addChild(index, root);
				temp = connectedNodes[i][0];
				arInt = new ArrayList<>();
				arInt.add(connectedNodes[i][1]);
			}
		}

		for (int i = 0; i < applesAtNodes.length; i++) {
			tree.find(root, applesAtNodes[i]).value = 1;
		}

		int[] max = tree.findMaxApple(root);
		int maxApple = max[0] + max[1];
		return maxApple;
	}
}

class LinkNode {
	int value;
	int index;
	LinkNode[] child;

	public LinkNode(int value, int index) {
		super();
		this.value = value;
		this.index = index;
	}

}

class Tree {
	LinkNode root;

	public Tree() {

	}

	public Tree(LinkNode root) {
		this.root = root;
	}

	public void addChild(int[] value, int[] index, LinkNode root) {
		for (int i = 0; i < index.length; i++) {
			root.child[i] = new LinkNode(value[i], index[i]);
		}
	}

	public void addChild(int[] index, LinkNode root) {
		for (int i = 0; i < index.length; i++) {
			root.child[i] = new LinkNode(0, index[i]);
		}
	}

	public LinkNode find(LinkNode root, int index) {
		LinkNode key;
		if (root == null)
			return null;
		if (root.index == index)
			return root;
		for (int i = 0; i < root.child.length; i++) {
			key = find(root.child[i], index);
			if (key != null) {
				return key;
			}
		}
		return null;
	}

	public int[] findMaxApple(LinkNode root) {
		if (root.child == null)
			return new int[] { 0, 0 };
		int max[] = new int[root.child.length];
		for (int i = 0; i < root.child.length; i++) {
			int temp[] = findMaxApple(root.child[i]);
			max[i] = Math.max(temp[0], temp[1]);
		}
		Arrays.sort(max);
		return new int[] { max[root.child.length - 2], max[root.child.length - 1] };
	}
}
