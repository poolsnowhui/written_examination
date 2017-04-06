package com.array;

//insertSort.java
//demonstrates insertion sort
//to run this program: C>java InsertSortApp
//--------------------------------------------------------------
class ArrayIns {
	private long[] a; // ref to array a
	private int nElems; // number of data items
	// --------------------------------------------------------------

	public ArrayIns(int max) // constructor
	{
		a = new long[max]; // create the array
		nElems = 0; // no items yet
	}

	// --------------------------------------------------------------
	public void insert(long value) // put element into array
	{
		a[nElems] = value; // insert it
		nElems++; // increment size
	}

	// --------------------------------------------------------------
	public void display() // displays array contents
	{
		for (int j = 0; j < nElems; j++) // for each element,
			System.out.print(a[j] + " "); // display it
		System.out.println("");
	}

	// --------------------------------------------------------------
	public void insertionSort() {
		int in, out;

		for (out = 1; out < nElems; out++) // out is dividing line
		{
			long temp = a[out]; // remove marked item
			in = out; // start shifts at out
			while (in > 0 && a[in - 1] >= temp) // until one is smaller,
			{
				a[in] = a[in - 1]; // shift item to right
				--in; // go left one position
			}
			a[in] = temp; // insert marked item
		} // end for
	} // end insertionSort()
		// --------------------------------------------------------------

	public long median() {

		int min = 0;
		int i = 0;
		for (i = 0; i < (nElems + 1) / 2; i++) {
			min = i;
			for (int j = i + 1; j < nElems; j++) {
				if (a[min] > a[j]) {
					min = j;
				}
			}
			swap(i, min);
		}
		return a[i - 1];
	}// end median
		// -----------------------------------------

	public void noDup() {
		int size = nElems;
		for(int in=0,out=1;out<nElems;out++){
			if(a[out-1]==a[out]){
				size--;
			}else{
				a[in+1] = a[out];
				in++;
			}
		}
		nElems = size;
	}// end noDup
	// ------------------------------------

	private void swap(int one, int two) {
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
} // end class ArrayIns
	////////////////////////////////////////////////////////////////

class InsertSortApp {
	public static void main(String[] args) {
		int maxSize = 100; // array size
		ArrayIns arr; // reference to array
		arr = new ArrayIns(maxSize); // create the array

		arr.insert(77); // insert 10 items
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(88);
		arr.insert(11);
		arr.insert(11);
		arr.insert(00);
		arr.insert(00);
		arr.insert(00);
		arr.insert(66);

		arr.display(); // display items
//
//		System.out.println(arr.median());
//
//		arr.display(); // display them again
		arr.insertionSort();
		arr.display();
		arr.noDup();
		arr.display();
	} // end main()
} // end class InsertSortApp
