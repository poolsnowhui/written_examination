import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MainWorksWR {//04ed6b36-509a-453b-a14c-dd4bb16d3b1f
	//5ab9ab7d-57e2-40fb-be81-f1e76fd305c2

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		Room[] rooms = new Room[N];
		sc.nextLine();
		for (int i = 0; i < N; i++) {
			rooms[i] = new Room(i, sc.nextInt());
		}
		sc.nextLine();
		// for (int i = 0; i < N; i++) {
		// System.out.println(rooms[i].value);
		// }
		int x, y;
		for (int i = 0; i < N - 1; i++) {
			x = sc.nextInt() - 1;
			y = sc.nextInt() - 1;
			rooms[x].addNeighbor(rooms[y]);// 互相增加邻居
		}
		// for (int i = 0; i < N; i++) {
		// System.out.println(rooms[i]);
		// }
		Arrays.sort(rooms);// 按关键字total排序，比重最大的排前面
		System.out.println(maxSatisfaction(rooms, M));// 找出最大房间满意度
	}

	private static int maxSatisfaction(Room[] rooms, int m) {
		boolean end = false;
		int maxTotal = 0;

		for (int ii = 0; ii < rooms.length; ii++) {

			Room[] sheXiaRooms = new Room[rooms.length];
			for (int i = 0; i < sheXiaRooms.length; i++) {
				sheXiaRooms[i] = new Room(rooms[i]);
			} // 拷贝当前rooms
			Room temp = sheXiaRooms[ii];
			sheXiaRooms[ii] = sheXiaRooms[0];
			sheXiaRooms[0] = temp;
			int total = 0;
			List<Room> arRoom = new ArrayList<>();// 已排room
			List<Room> arSheXiaRoom = new ArrayList<>();// 剩余room
			HashMap<Integer, Integer> map = new HashMap<>();// 已排room及其关联的邻居

			for (int k = 0; k < m; k++) {// 找前m个房间

				// Room temp = new Room(sheXiaRooms[0]);
				// arRoom.add(temp);
				// 放置邻居到hashmap
				// map.put(rooms[k], rooms[k].value);
				map.put(sheXiaRooms[0].position, sheXiaRooms[0].value);
				for (int i = 0; i < sheXiaRooms[0].doors; i++) {
					if (sheXiaRooms[0].neighbor[i] != null) {
						map.put(sheXiaRooms[0].neighbor[i].position, sheXiaRooms[0].neighbor[i].value);
					}
				} // 放置hashmap里作为已经统计的

				// 1-rooms.length-1做减room
				for (int i = 1; i < sheXiaRooms.length; i++) {
					if (map.containsKey(sheXiaRooms[i].position)) {// 当前room在已经统计的房间时，移除
						// 移除
					} else {
						for (int j = 0; j < sheXiaRooms[i].neighbor.length; j++) {
							if (sheXiaRooms[i].neighbor[j] != null
									&& map.containsKey(sheXiaRooms[i].neighbor[j].position)) {// 有邻居且邻居在已经统计的房间时，该room将邻居去除
								sheXiaRooms[i].reMoveNeighbor(j);// 去除第j个邻居
							}
						}
						arSheXiaRoom.add(sheXiaRooms[i]);// 否则加入到剩余待排序列
					}
				} // for找剩余房间不含在已经统计房间内

				if (arSheXiaRoom.size() == 0) {
					end = true;// 结束，当前方案包含所有节点
					break;
					// break结束，无剩余房间
				} else {
					sheXiaRooms = (Room[]) arSheXiaRoom.toArray(new Room[arSheXiaRoom.size()]);// ArrayList转数组
					Arrays.sort(sheXiaRooms);
					arSheXiaRoom = new ArrayList<>();
				}

			} // 直到第m个房间或已无剩余房间。

			Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) it.next();
				total += entry.getValue();

			}
			if (maxTotal < total) {
				maxTotal = total;
			}
			if (end) {
				return maxTotal;
			}
		}

		return maxTotal;
	}

}

class Room implements Comparable<Room> {
	public int position;// 位置
	public int value;// 所在位置比重 1<=比重<=10 为0时该邻居不存在
	public Room[] neighbor;// 邻居位置比重，为0时该邻居不存在
	public int total;// 当前有效的邻居位置比重和
	public int doors = 3;// 门最大数量

	public Room(int position, int value) {// 只增加邻居的比重
		super();

		this.position = position;
		this.value = value;
		this.neighbor = new Room[doors];
		this.total = value;
	}

	public Room(Room room) {// 拷贝构造

		this.position = room.position;
		this.value = room.value;
		this.neighbor = room.neighbor;
		this.total = room.total;
	}

	public void reMoveNeighbor(int j) {
		if (neighbor == null) {
			return;
		} else {
			total -= neighbor[j].value;// 减去邻居比重和
			neighbor[j] = null;//
		}
	}

	public void addNeighbor(Room n) {
		if (neighbor == null) {
			neighbor = new Room[doors];
		} else {
			for (int i = 0; i < doors; i++) {
				if (neighbor[i] == n) {// 已有该邻居
					return;
				} else if (neighbor[i] == null) {// 邻居节点不满
					neighbor[i] = n;// 增加邻居节点
					total += n.value;// 增加邻居比重和

					n.addNeighbor(this);// 增加邻居节点的邻居
					return;
				}

			}
			System.err.println("邻居节点已满");
		}
	}

	public String toObject() {
		return super.toString();
	}

	@Override
	public String toString() {
		String neightborString = "";
		for (int i = 0; i < doors; i++) {
			if (neighbor[i] != null) {
				neightborString += neighbor[i].toObject();
			}
		}
		return toObject() + "[position=" + position + "[value=" + value + ",  total=" + total + ", doors=" + doors
				+ ", neighbor=" + neightborString + "]";
	}

	@Override
	public int compareTo(Room o) {
		if (this.total == o.total)
			return 0;
		else
			return this.total < o.total ? 1 : -1;// 比重大的放前面，降序
	}

}
