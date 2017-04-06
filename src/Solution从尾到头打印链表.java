import java.util.ArrayList;

/**
 * public class ListNode { int val; ListNode next = null;
 *
 * ListNode(int val) { this.val = val; } }
 *
 */
public class Solution从尾到头打印链表 {

	/**
	 * 题目描述 输入一个链表，从尾到头打印链表每个节点的值。 输入描述: 输入为链表的表头 输出描述: 输出为需要打印的“新链表”的表头
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

		ListNode left=listNode,mid = null,right;
		if (listNode != null){
			mid = listNode.next;
			listNode.next = null;
		}

		for (; mid != null; left = mid, mid = right) {
			right = mid.next;
			mid.next = left;
			listNode = mid;
		}
		
		ArrayList<Integer> newArray = new ArrayList<>();
		for (ListNode p = listNode; p != null; p = p.next) {
			newArray.add(p.val);
		}

		return newArray;

	}

}

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}
