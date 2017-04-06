import java.util.Scanner;

public class Mainwanmeilink {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		if (sc.hasNextInt()) {
			int size = sc.nextInt();
			int[] value = new int[size];
			for (int i = 0; i < size; i++) {
				value[i] = sc.nextInt();
			}
			SingLink list = new SingLink(value);

				int add = sc.nextInt();
				int addValue = sc.nextInt();

				list.addIndex(add, addValue);

				int del = sc.nextInt();
				list.delete(del);


			list.displayList();
		}
	}
}

class Link {
	int value;
	Link next;

	public Link(int value) {
		this.value = value;
	}

	public void display() {
		System.out.print(this.value);
	}
}

class SingLink {
	Link head;

	// 构造单链表
	public SingLink() {
		head = null;
	}

	public SingLink(int[] value) {
		if (value == null) {
			System.out.println("error");
			return;

		}
		if (head == null) {
			Link node = new Link(value[0]);
			head = node;
		}
		for (int i = 1; i < value.length; i++) {
			Link node = new Link(value[0]);
			node.next = head;
			head = node;
		}

	}

	public boolean isEmpty() {
		return (head == null);
	}

	public void displayList() {
		Link cur = head;
		while (cur != null) {
			cur.display();
			System.out.println(" ");
			cur = cur.next;
		}
		System.out.println();
	}

	public void addTail(int value) {
		if (head == null) {
			Link node = new Link(value);
			head = node;
			return;
		} else {

			Link cur = head;
			for (; cur.next != null;) {
				cur = cur.next;
			}
			Link node = new Link(value);
			cur.next = node;
		}
	}

	public void addIndex(int key, int value) {
		if (head == null && key == 0) {
			Link node = new Link(value);
			head = node;
			return;
		}
		if (key != 0) {
			System.out.println("error");
			return;
		} else {

			Link cur = head;
			Link pre = head;
			for (int i = 0; i < key; i++) {
				if (cur.next != null) {
					pre = cur;
					cur = cur.next;
				} else {
					System.out.println("error");
					return;
				}
			}
			Link node = new Link(value);
			pre.next = node;
			node.next = cur;
		}
	}

	public Link delete(int key) {
		if (head == null) {
			System.out.println("error");
			return null;
		} else {

			Link cur = head;
			Link pre = head;
			for (int i = 0; i < key; i++) {
				if (cur.next != null) {
					pre = cur;
					cur = cur.next;
				} else {
					System.out.println("error");
				}
			}
			if (cur == head) {
				head = cur.next;
			} else {
				pre.next = cur.next;
			}
			return cur;
		}
	}
}
