public interface BlockingQueue<E> {
	public void put(E e) throws InterruptedException;

	public E take() throws InterruptedException;
}

class Queue<E> implements BlockingQueue<E> {
	private int maxSize;
	private Object[] queArray;
	private int front;
	private int rear;
	private int nItems;

	public Queue(int s) {// 构造队列
		maxSize = s;
		queArray = new Object[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	private void insert(E j) {// 进队列
		if (rear == maxSize - 1)
			rear = -1;
		queArray[++rear] = j;
		nItems++;
	}

	private E remove() {// 出队列
		@SuppressWarnings("unchecked")
		E temp = (E) queArray[front];
		queArray[front] = null;
		if (++front == maxSize)
			front = 0;
		nItems--;
		return temp;
	}

	public boolean isEmpty() {// 判断是否为空
		return (nItems == 0);
	}

	// --------------------------------------------------------------
	public boolean isFull() {// 判断是否为满
		return (nItems == maxSize);
	}

	@Override
	public void put(E e) throws InterruptedException {
		while (isFull()) {// 为满时等待
			wait();
		}
		notifyAll();
		synchronized (queArray) {
			insert(e);// 不为满时，异步进队列
		}

	}

	@Override
	public E take() throws InterruptedException {
		while (isEmpty()) {// 为满时等待
			wait();
		}
		notifyAll();
		E e;
		synchronized (queArray) {
			e = remove();// 不为空时，异步出队列
		}
		return e;
	}

	public static void main(String[] args) {
	}

}
