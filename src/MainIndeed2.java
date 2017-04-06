import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MainIndeed2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		List<Entry<String, Integer>> al = solution(s);
		for (Entry<String, Integer> entry : al) {
			System.out.println(entry.getKey());
		}
	}

	public static List<Entry<String, Integer>> solution(String s) {
		Map<String, Integer> map = new HashMap<>();
		char[] t = new char[2];
		for (int i = 1; i < s.length(); i++) {
			t[0] = s.charAt(i - 1);
			t[1] = s.charAt(i);
			String temp = new String(t);
			if (!map.containsKey(temp)) {
				map.put(temp, 1);
			} else {
				map.put(temp, map.get(temp) + 1);
			}
		}


		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		// for (int i = 0; i < list.size(); i++) {
		// System.out.println(list.get(i).toString());
		// }
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				if (o1.getValue() < o2.getValue()) {
					return 1;
				} else if (o1.getValue() == o2.getValue() && o1.getKey().compareTo(o2.getKey()) > 0) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		return list;

	}
}
