
public class Solution替换空格 {

	/**
	 * 题目描述 请实现一个函数，将一个字符串中的空格替换成“%20”。 例如，当字符串为We Are Happy.
	 * 则经过替换之后的字符串为We%20Are%20Happy。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuffer str = new StringBuffer("We Are Happy");

		System.out.println(new Solution替换空格().replaceSpace(str));

	}

	public String replaceSpace(StringBuffer str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				str.deleteCharAt(i);
				str.insert(i, "%20");
			}
		}
		return str.toString();
	}

}
