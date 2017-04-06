package com.array;

class Link {
	public int intData;
	public double longData;
	public Link next;

	public Link(int intData, double longData) {
		this.intData = intData;
		this.longData = longData;
	}

	public void displayLink() {
		System.out.print("{" + intData + "," + longData + "}");
	}
}

class LinkList {
	private Link first;

	public LinkList() {
	}

	public void insertFirst(int intData, double longData) {
		Link link = new Link(intData, longData);
		link.next = first;
		first = link;
	}// end insertFirst
		// ----------------------------

	public Link deleteFirst() {
		Link temp = first;
		first = first.next;
		return temp;
	}// deleteFirst
		// ------------------------

	public boolean isEmpty() {
		return (first == null);
	}// end isEmpty
		// ----------------------------

	public void displayList() {
		for (Link curr = first; curr != null; curr = curr.next) {
			curr.displayLink();
		}
		System.out.println("");
	}
}

class LinkListApp {
	public static void main(String[] args) {
		LinkList theList = new LinkList(); // make new list

		theList.insertFirst(22, 2.99); // insert four items
		theList.insertFirst(44, 4.99);
		theList.insertFirst(66, 6.99);
		theList.insertFirst(88, 8.99);

		theList.displayList(); // display list

		while (!theList.isEmpty()) // until it's empty,
		{
			Link aLink = theList.deleteFirst(); // delete link
			System.out.print("Deleted "); // display it
			aLink.displayLink();
			System.out.println("");
		}
		theList.displayList(); // display list
	} // end main()
}
