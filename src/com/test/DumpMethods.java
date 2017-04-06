package com.test;

import java.util.Arrays;

public class DumpMethods {
	public static void main(String[] args) {
		// try {
		// Class c = Class.forName(args[0]);
		// Method m[] = c.getDeclaredMethods();
		// for (int i = 0; i < m.length; i++) {
		// System.out.println(m[i].toString());
		// }
		// Method m2[] = c.getMethods();
		// for (int i = 0; i < m2.length; i++) {
		// System.out.println(m2[i].toString());
		// }
		// } catch (ClassNotFoundException e) {
		// e.printStackTrace();
		// }
		Integer[] a = { 1, 2, 3, 4, 5 };
		swap(a, 0, 4);
		System.out.println(Arrays.asList(a));
		Character[] a2 = { 48, 49, 50, 51, 52 };
		swap(a2, 0, 4);
		System.out.println(Arrays.asList(a2));
		Long[] a3 = { 1l, 2l, 3l, 4l, 5l };
		swap(a3, 0, 4);
		System.out.println(Arrays.asList(a3));
		if (a3[0] instanceof java.lang.Long) {
			System.out.println("a3 is " + a3[0].getClass().getName());
		}
	}

	/**
	 * 通用交换方法
	 * 
	 * @param o
	 * @param a
	 * @param b
	 */
	public static <E> void swap(E[] o, int a, int b) {
		E temp = o[a];
		o[a] = o[b];
		o[b] = temp;
	}
}
