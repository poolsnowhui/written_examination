package com.array;

class Deque {
	private int maxSize;
	private long queArray[];
	private int left;
	private int right;
	private int nItems;

	public Deque(int s) {// constructor
		maxSize = s;
		queArray = new long[maxSize];
		left = 0;
		right = -1;
		nItems = 0;
	}// end constructor
		// ----------------------------------

	public void insertLeft(long value) {
		if (left == 0)
			left = maxSize;
		queArray[--left] = value;
		nItems++;
	}// end insertLeft
		// ----------------------------

	public void insertRight(long value) {
		if (right == maxSize - 1)
			right = -1;
		queArray[++right] = value;
		nItems++;
	}// end insertRight
		// --------------------------

	public long removeLeft() {
		long value = queArray[left++];
		if (left == maxSize)
			left = 0;
		nItems--;
		return value;
	}// end removeLeft
		// --------------------------

	public long removeRight() {
		long value = queArray[right--];
		if (right == -1)
			right = maxSize - 1;
		nItems--;
		return value;
	}// end removeRight
		// ----------------------

	public boolean isEmpty() {
		if (nItems == 0)
			return true;
		return false;
	}// end isEmpty
		// ------------------------------

	public boolean isFull() {
		return (nItems == maxSize);
	}// end isFull
		// -------------------------------

}

class StackC extends Deque {

	public StackC(int s) {// constructor
		super(s);
	}// end constructor
		// ------------------------

	public void push(long value) {
		insertRight(value);
	}// end push
		// ---------

	public long pop() {
		return removeRight();
	}// end pop
		// -------------------------

	public long peek() {

		long value = removeRight();
		insertRight(value);
		return value;
	}// end peek
		// --------------------------

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return super.isEmpty();
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return super.isFull();
	}

}

class DequeApp {
	public static void main(String[] args) {
//		Deque d = new Deque(5);
//		d.insertRight(11);
//		d.insertRight(22);
//		d.insertRight(33);
//		d.insertLeft(33);
//		d.removeLeft();
//		d.insertLeft(22);
//		d.removeRight();
//		d.insertLeft(11);
//
//		while (!d.isEmpty()) {
//
//			System.out.println(d.removeLeft());
//		}

		StackC stack = new StackC(5);
		stack.push(11);
		stack.push(11);
		stack.push(22);
		stack.push(11);
		stack.push(11);
		System.out.println(stack.isFull());
		System.out.println(stack.isFull());
		System.out.println("pop+" + stack.pop());
		System.out.println("pop+" + stack.pop());
		System.out.println("peek+" + stack.peek());
		System.out.println("isEmpty+" + stack.isEmpty());
		System.out.println("isFull+" + stack.isFull());
	}
}
