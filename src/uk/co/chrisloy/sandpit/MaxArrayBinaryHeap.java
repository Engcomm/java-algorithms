package uk.co.chrisloy.sandpit;

@SuppressWarnings("unchecked")
public class MaxArrayBinaryHeap<T extends Comparable<T>> implements BinaryHeap<T> {
	
	private Object[] arr;
	private int heapSize;
	
	public MaxArrayBinaryHeap(int size) {
		this.arr = new Object[size];
		this.heapSize = 0;
	}
	
	public MaxArrayBinaryHeap(T[] arr) {
		this.arr = arr;
		this.heapSize = arr.length;
		this.buildMaxHeap();
	}
	
	private void buildMaxHeap() {
		for(int i=arr.length/2; i>=0; i--) {
			maxHeapify(i);
		}
	}
	
	private int left(int i) {
		return 2*i+1;
	}
	
	private int right(int i) {
		return 2*i+2;
	}
	
	private T get(int i) {
		return (T)arr[i];
	}
	
	@Override
	public void sort() {
		for(int i=arr.length-1; i>0; i--) {
			swap(0, i);
			heapSize--;
			maxHeapify(0);
		}
	}
	
	private void maxHeapify(int i) {
		final int left = left(i);
		final int right = right(i);
		int largest;
		if(left < heapSize && get(left).compareTo(get(i)) > 0) {
			largest = left;
		} else {
			largest = i;
		}
		if(right < heapSize && get(right).compareTo(get(largest)) > 0) {
			largest = right;
		}
		if(largest != i) {
			swap(i, largest);
			maxHeapify(largest);
		}
	}
	
	private void swap(int a, int b) {
		Object tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
