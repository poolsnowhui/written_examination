
public class DependTree {

	Node head;// 依赖树根节点
	Lib[] packArray;// 库数组
	int nCount = 0;// 长度

	public DependTree(int MaxSize) {
		packArray = new Lib[MaxSize];
	}

	public static void main(String[] args) {

	}

	// 遍历，并合并相同库
	public void bianli(Node root) {
		if (root != null) {
			put(root);// 引入库
			for (int i = 0; i < root.child.length; i++) {
				bianli(root.child[i]);// 遍历剩余的库
			}
		}
	}

	public void put(Node node) {
		if (nCount == 0) {// 为空时直接放入
			packArray[0] = node.lib;
			nCount++;
		}
		for (int i = 0; i < nCount; i++) {
			if (node.lib.packNameEqual(packArray[i])) {// 有相同库名时
				if (node.lib.depth >= packArray[i].depth) {// 深度小的替换深度大的
					return;
				} else {
					packArray[i] = node.lib;
					return;
				}
			}
		}
		packArray[nCount++] = node.lib;// 放到最后一个

	}

	public int get_node_layer(Node node, Lib lib, int L) {
		int i = -1;
		if (node != null) {
			if (node.lib.packNameEqual(lib))
				return L;
			for (int j = 0; j < node.child.length; j++) {
				if ((i = get_node_layer(node.child[j], lib, L + 1)) != -1) {
					return i;
				}
			}

		}
		return i;
	}
}

class Node {// 依赖树结点
	Lib lib;// 库
	Node[] child;// 依赖子结点

}

class Lib {// 库
	String packName;// 库名
	String version;// 版本
	int depth;// 深度
	// 库名相等时返回true

	public boolean packNameEqual(Lib lib) {
		return packName.equals(lib.packName);
	}

	public Lib(String packName, String version) {
		super();
		this.packName = packName;
		this.version = version;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
}
