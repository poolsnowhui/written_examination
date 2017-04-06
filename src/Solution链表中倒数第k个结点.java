public class Solution链表中倒数第k个结点 {
	/**
	 * 题目描述 输入一个链表，输出该链表中倒数第k个结点。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public ListNode5 FindKthToTail(ListNode5 head, int k) {
		ListNode5 h=head,p=head;
		if(head==null) return null;

		for (int i = 0; i < k; i++) {
			if(p!=null) p=p.next;
			else return null;
		}
		while (p!=null) {
			p=p.next;
			h=h.next;
		}
		return h;
	}
}

class ListNode5 {
	int val;
	ListNode5 next = null;

	ListNode5(int val) {
		this.val = val;
	}
}
