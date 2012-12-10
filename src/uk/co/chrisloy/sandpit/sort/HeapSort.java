package uk.co.chrisloy.sandpit.sort;

import uk.co.chrisloy.sandpit.MaxArrayBinaryHeap;

public class HeapSort<T extends Comparable<T>> implements Sort<T> {
	
	@Override
	public void sort(T[] arr) {
		new MaxArrayBinaryHeap<T>(arr).sort();
	}
}
