import java.util.ArrayList;

public class Solution滑动窗口最大值 {

	/*
	 * 题目描述 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
	 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一 共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
	 * 针对数组 {2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}，
	 * {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1} ，
	 * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
	 */
	public static void main(String[] args) {
		int num[] = { 2, 3, 4, 2, 6, 2, 5, 1 };
		int size = 3;
		new Solution滑动窗口最大值().maxInWindows(num, size);

	}

	public ArrayList<Integer> maxInWindows(int[] num, int size) {

		ArrayList<Integer> alInt = new ArrayList<>();
		if (size == 0) {
			return alInt;
		}
		for (int i = 0, e = size; i < num.length && e <= num.length; i++, e++) {
			// i-e中最大值
			int max = i;
			for (int j = i; j < e; j++) {
				if (num[j] > num[max])
					max = j;
			}
			alInt.add(num[max]);
		}
		for (int i = 0; i < alInt.size(); i++) {
			System.out.println(alInt.get(i));
		}
		return alInt;

	}

}
