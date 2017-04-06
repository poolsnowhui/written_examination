//import java.util.Scanner;
//
//public class TSPDynamic {
//	String[] V;// 顶点生成的子集，这里把每一个子集用一个字符串表示
//	int[][] c;// 顶点间距离
//	int[][] d;// 存放迭代结果//
//	int N; // 城市个数
//	String[][] path;// 用于存放每种选择下经过的城市
//	static int IFINITE = 99999;// 无穷大距离 表示城市自己到达自己时，距离无穷大，不作为考虑因素
//
//	// 构造函数
//	public TSPDynamic() {
//		initialC();
//		initialV1();
//	}
//
//	// 初始化数组c[]，即顶点间距离
//	public void initialC() {
//		Scanner in = new Scanner(System.in);
//
//		System.out.println("请输入城市个数： （注意根据实际情况城市个数不可小于1！）");
//		N = in.nextInt();
//		if (N <= 1)
//
//		{
//			System.out.println("不符合要求，请认真核对！");
//			System.exit(0);// 输入错误，结束！
//		}
//		//
//		System.out.println("请输入城市相邻城市间距离（城市从0开始编号，且出发城市为第0个城市！）： ");
//
//		c = new int[N][N];
//		// 为c分配空间
//		for (int i = 0; i < N; i++)
//			for (int j = 0; j < N; j++) {
//				c[i][j] = in.nextInt(); // 输入时，按城市编号从小到大，如若两城市间没有公路相连，则距离为无穷大。本城市与本城市间距离也为无穷大。
//
//			}
//
//	}
//
//	// 初始化顶点生成的子集的对外调用函数
//	public void initialV1() {
//		V = new String[(int) Math.pow(2, N - 1)];// 为V分配空间
//		initialV(0, 0);
//	}
//
//	// 具体的初始化顶点生成的子集
//	// 本程序使用递归调用方法初始化V，并按照数字大小顺序排序。。另，子集使用字符型形式存放的
//	// 我们是按照子集中元素个数从小到大逐个添加的，后面的子集是前面对应子集加上一个元素组成的，故用递归
//	public void initialV(int m, int len) {// m代表下一个即将初始化的V数组的元素的下标；len是最后一个初始化的元素的长度
//											//
//		if (m > (int) Math.pow(2, N - 1) - 1)
//			return;// 如果全部顶点已初始化完成，则返回。
//
//		if (m == 0)
//			V[m++] = "";// 初始化出发顶点，即V[0]
//		else {
//			int i = m - 1;
//			while (i >= 0 && V[i].length() == len)// 找与最后一个初始化的V[m-1]子集内元素个数相同的集合，把指针i指向满足条件的集合
//				i--;
//
//			i++;// 把指针i指向满足条件的第一个集合
//			while (i < m) {
//				int ch;// 用于表示下一个即将加入子集的数字
//				if (i == 0)
//					ch = 0;// 如果i指向V中第一个元素
//				else {
//					String chStr = "" + V[i].charAt(V[i].length() - 1);// 找出V[i]中最后一个数字
//					ch = Integer.parseInt(chStr);// 转换成整型
//				}
//				// 比ch大而又比N-1(因为这里顶点是从0开始的)小的数字应该加在子集中
//				while (ch < N - 1)
//					V[m++] = V[i] + (++ch);
//				i++;// 对已存在的自己逐个扫描添加
//			}
//		}
//
//		initialV(m, V[m - 1].length());// 递归调用
//	}
//
//	// 判断自己V[j]中是否存在指定元素，即行号i
//	boolean exclude(int i, int j) {
//
//		String str = "" + i;// 把i转换成字符串
//		if (V[j].contains(str)) {
//			System.out.println(i + "i");
//			return false;
//		}
//		// 如若存在，则返回false
//		else
//			return true;
//	}
//
//	// 获得子集V[j]中除指定元素k外的元素，用字符串形式表示
//	public String getSubString(int k, int j) {
//		//
//		if (V[j].length() == 1)
//			return "";// 如果子集中只有一个元素，则返回空串
//		else {
//			if (k == 0)
//				return V[j].substring(1, V[j].length());// 如果k是第一个元素，则返回其后面的元素
//			else if (k == V[j].length() - 1)
//				return V[j].substring(0, V[j].length() - 1);// 如果k是最后一个元素，则返回其前面的元素
//															//
//			else
//				//
//				return
//				//
//				(V[j].substring(0, k) + V[j].substring(k + 1, V[j].length()));// 返回除k外的元素
//
//		}
//
//	}
//
//	// 找出V[]中与str相同元素的下标号,即找出上一个子集
//	public int stringEqual(String str) {
//		// //
//		if (str.equals(""))
//			return 0;
//		int i = 0;
//		while (i < V.length)
//
//		{
//			if (V[i].equals(str))
//				return i;
//			i++;
//		}
//		return -1;// 如若没找到，则返回错误符号-1
//
//	}
//
//	// 求最小距离
//	public int min(int i, int j) {
//		int k = 0;// 用于记录V[j]中元素个数
//		String vStr = "" + V[j].charAt(k);// 铭记V[j].charAt(k)得到的是字符型，转换成整形后是字母对应的ASC码！！！！
//		int v = Integer.parseInt(vStr);// 把位置k处的字符转换成整形
//		String str = getSubString(k, j);// 获得V[j]中除位置k处外的字符串
//		//
//		System.out.println("min" + str + stringEqual(str) + v);
//		if (stringEqual(str) == -1)
//			System.exit(0);
//
//		int min = c[i][v] + d[v][stringEqual(str)];// 先把最小的距离赋值给从V[j]中第一个顶点出发的距离
//													// //
//		System.out.println(min); // stringEqual(str)表示返回与上面获得的字符串相同的V中元素的下标，即找上一个子集
//		path[i][j] = path[v][stringEqual(str)] + i;
//		k++;
//		// 寻找最小距离
//		while (k < V[j].length()) {
//			vStr = "" + V[j].charAt(k);
//			v = Integer.parseInt(vStr);
//			str = getSubString(k, j);
//			if (min > c[i][v] + d[v][stringEqual(str)]) {
//				min = c[i][v] + d[v][stringEqual(str)];
//				path[i][j] = path[v][stringEqual(str)] + i;
//			}
//			k++;
//		}
//		V[j].substring(beginIndex, endIndex);
//		System.out.println(path[i][j]);
//		return min;// 返回最小值
//	}
//
//	// 处理函数
//	public void dynamic() {
//		d = new int[N][(int) Math.pow(2, N - 1)];// 分配空间
//		path = new String[N][(int) Math.pow(2, N - 1)];
//		for (int i = 1; i < N; i++) {// 初始化第一列
//			d[i][0] = c[i][0];
//			path[i][0] = "0" + i;// 初始化第一个元素，即为出发城市顶点 //
//			System.out.print(d[i][0] + " ");
//		}
//		// 初始化后面的元素
//		int j = 1;
//		for (; j < (int) Math.pow(2, N - 1) - 1; j++)
//			for (int i = 1; i < N; i++) {
//				if (exclude(i, j)) // 判断V子集中是否包含当前顶点，即V[j]中是否包含i
//				{
//					System.out.println("done！" + i + " " + j);
//					d[i][j] = min(i, j);// 寻找最小距离
//				}
//			}
//		d[0][j] = min(0, j);// 初始化组后一列
//	}
//
//	// 输出中间结果，各个数组，用于调试程序
//	public void print() {
//		for (int i = 0; i < (int) Math.pow(2, N - 1); i++)
//			System.out.print(V[i] + " "); //
//		for (int i = 0; i < c.length;)
//			System.out.println();
//		for (int i = 0; i < N; i++)
//
//		{
//			for (int j = 0; j < N; j++)
//				System.out.print(c[i][j] + " ");
//			System.out.println();
//		}
//		for (int i = 0; i < N; i++)
//
//		{
//			for (int j = 0; j < (int) Math.pow(2, N - 1); j++)
//				System.out.print(d[i][j] + " ");
//			System.out.println();
//
//		}
//
//	}
//
//	// 输出最短路径
//	public void printShortestPath() { // 输出所经城市
//		System.out.print("经过城市：");
//		String str = path[0][(int) Math.pow(2, N - 1) - 1]; //
//		System.out.println(str);
//		System.out.print(str.charAt(str.length() - 1));
//		for (int i = str.length() - 2; i >= 0; i--) {
//			System.out.print("->" + str.charAt(i));
//		}
//		System.out.println("会有最短路径");
//		System.out.println("最短路径为：" + d[0][(int) Math.pow(2, N - 1) - 1]);
//	}
//
//	// 主函数
//	public static void main(String[] args) {
//		TSPDynamic TSP = new TSPDynamic();
//		TSP.dynamic();// 求最短路径 //
//		TSP.print();
//		TSP.printShortestPath();// 输出最短路径
//	}
//
//}
//// 测试数据 /*99999 3 6 7 5 99999 2 3 6 4 99999 2 3 7 5 99999
