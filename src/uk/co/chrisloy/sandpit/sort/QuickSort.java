package uk.co.chrisloy.sandpit.sort;

/**
 * Implementation of a quicksort algorithm which sorts a generic
 * array of comparable elements into their natural order. It does
 * this by picking a "pivot" in the middle of the array, moving
 * all elements to the correct side of it, such that the pivot
 * is in the correct position at the end of the sort, and then
 * recursively sorting the "lower" and "higher" subsets on either
 * side in the same fashion.
 * 
 * @author chris.loy
 *
 * @param <T>
 */
public class QuickSort<T extends Comparable<T>> implements Sort<T> {
	
	private T[] arr;

	@Override
	public void sort(T[] arr) {
		this.arr = arr;
		quicksort(0, arr.length - 1);
	}
	
	private void quicksort(int left, int right) {
		
		if(left >= right) {
			return;
		}
		
		T pivot = arr[left + (right - left)/2];
		
		int i = left;
		int j = right;
		
		while (i <= j) {
			
			while(arr[i].compareTo(pivot) < 0) {
				i++;
			}
			
			while(arr[j].compareTo(pivot) > 0) {
				j--;
			}
			
			if(i <= j) {
				swap(i, j);
				i++;
				j--;
			}
		}
		quicksort(left, j);
		quicksort(i, right);
	}
	
	private void swap(int a, int b) {
		T x = arr[a];
		arr[a] = arr[b];
		arr[b] = x;
	}
}
