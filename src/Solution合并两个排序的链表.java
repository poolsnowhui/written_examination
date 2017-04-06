
public class Solution合并两个排序的链表 {
	/**
	 * 题目描述 输入两个单调递增的链表，输出两个链表合成后的链表， 当然我们需要合成后的链表满足单调不减规则。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public ListNode5 Merge(ListNode5 list1, ListNode5 list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;
		ListNode5 h = null, c = h;

		for ( ; list1 != null && list2 != null;) {
			if (list1.val < list2.val) {
				if (h == null) {
					h = c = list1;
				} else {
					c.next = list1;
					c = c.next;
				}
				list1 = list1.next;
			} else {
				if (h == null) {
					h = c = list2;
				} else {
					c.next = list2;
					c = c.next;
				}
				list2 = list2.next;
			}
		}
		if (list1 != null)
			c.next = list1;
		if (list2 != null)
			c.next = list2;

		return h;
	}
}