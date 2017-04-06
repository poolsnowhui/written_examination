import java.lang.reflect.Field;
import java.math.BigDecimal;

public class Main1011反射 {

	public static void main(String[] args) throws Exception {
		char a = 0;
		byte b = 1;
		short c = 2;
		int d = 3;
		float e = 4;
		long f = 5;
		double g = 6;
		System.out.println(max(a, b));
		System.out.println(max(b, c));
		System.out.println(max(d, e));
		System.out.println(max(f, g));
		System.out.println(max(a, d));
		
		
	}

    public static int max(int a, int b) {
        return (a >= b) ? a : b;
    }
	public static double max(double o1, double o2) {
		return o1 > o2 ? o1 : o2;
	}

	public static Object max(String o1, Object o2)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

		String[] types = { "java.lang.Integer", "java.lang.Double", "java.lang.Float", "java.lang.Long",
				"java.lang.Short", "java.lang.Byte", "java.lang.Boolean", "java.lang.Character", "java.lang.String",
				"int", "double", "long", "short", "byte", "boolean", "char", "float" };
		Field f1 = o1.getClass().getDeclaredField("value");
		Field f2 = o2.getClass().getDeclaredField("value");
		f1.setAccessible(true);
		f2.setAccessible(true);
		BigDecimal b1 = null;
		BigDecimal b2 = null;
		for (String str : types) {
			if (f1.getType().getName().equals(str)) {
				System.out.println("字段：" + f1.getName() + " 类型为：" + f1.getType().getName() + " 值为：" + f1.get(o1));
				b1 = (BigDecimal) f1.get(o1);

			}
			if (f2.getType().getName().equals(str)) {

				System.out.println("字段：" + f2.getName() + " 类型为：" + f2.getType().getName() + " 值为：" + f2.get(o2));
				b2 = (BigDecimal) f2.get(o2);
			}
		}
		return b1.compareTo(b2) >= 0 ? b1 : b2;
	}

	public static void getFieldsValue(Object obj) throws NoSuchFieldException, SecurityException {
		Field f = obj.getClass().getDeclaredField("value");

		/**
		 * 基本类型、包装类型、String类型
		 */
		String[] types = { "java.lang.Integer", "java.lang.Double", "java.lang.Float", "java.lang.Long",
				"java.lang.Short", "java.lang.Byte", "java.lang.Boolean", "java.lang.Character", "java.lang.String",
				"int", "double", "long", "short", "byte", "boolean", "char", "float" };
		f.setAccessible(true);
		try {
			for (String str : types) {
				if (f.getType().getName().equals(str))
					System.out.println("字段：" + f.getName() + " 类型为：" + f.getType().getName() + " 值为：" + f.get(obj));
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

}
