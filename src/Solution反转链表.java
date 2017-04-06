public class Solution反转链表 {
	
	/**
	 * 题目描述
	 * 输入一个链表，反转链表后，输出链表的所有元素。
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
    public ListNode5 ReverseList(ListNode5 head) {
    	if(head==null) return null;
    	ListNode5 left=head,mid=left.next,right;
    	left.next = null;
    	for (; mid!=null;left=mid,mid=right ) {
			right =mid.next;
			mid.next=left;
		}
    	return left;
    }
}