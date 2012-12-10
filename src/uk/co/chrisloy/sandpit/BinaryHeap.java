package uk.co.chrisloy.sandpit;

public interface BinaryHeap<T extends Comparable<T>> {
	
	/**
	 * Sorts the heap from lowest-to-highest. In so
	 * doing it destroys the binary heap.
	 */
	public void sort();
}
