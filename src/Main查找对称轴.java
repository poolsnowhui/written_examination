import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main查找对称轴 {
	static int max = 0, min = 0;
	static ArrayList<Integer[]> ali = new ArrayList<>();
	static HashMap<Integer, HashSet<Integer>> hashmap = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer xy[] = new Integer[2];
		xy[0] = sc.nextInt();
		xy[1] = sc.nextInt();
		ali.add(xy);

		HashSet<Integer> set = new HashSet<>();
		set.add(xy[0]);
		hashmap.put(xy[1], set);

		while (sc.hasNextInt()) {
			Integer xy2[] = new Integer[2];
			xy2[0] = sc.nextInt();
			xy2[1] = sc.nextInt();
			ali.add(xy2);
			System.out.println(dC(ali));
		}
		sc.close();

	}

	private static boolean dC(ArrayList<Integer[]> ali2) {

		for (int i = 0; i < ali2.size(); i++) {
			max = Math.max(ali2.get(i)[0], max);
			min = Math.min(ali2.get(i)[0], min);
			if (!hashmap.containsKey(ali2.get(i)[1])) {
				HashSet<Integer> set = new HashSet<>();
				set.add(ali2.get(i)[0]);
				hashmap.put(ali2.get(i)[1], set);
			} else {
				hashmap.get(ali2.get(i)[1]).add(ali2.get(i)[0]);
			}
		}
		for (int i = 0; i < ali2.size(); i++) {
			if (!hashmap.containsKey(ali2.get(i)[1])
					|| !hashmap.get(ali2.get(i)[1]).contains(max + min - ali2.get(i)[0])) {
				return false;
			}
		}
		return true;
		// TODO Auto-generated method stub
	}

}
