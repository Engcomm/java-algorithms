package uk.co.chrisloy.sandpit.sort;

/**
 * Sorting algorithm which implements standard merge-sort. This is
 * built on the notion of divide-and-conquer, recursively breaking
 * the array into smaller sub arrays, sorting those and then returning
 * up the call stack to merge at each level until finally two arrays
 * at the very top level are merged into the original array.
 * 
 * 
 * @author chris.loy
 *
 * @param <T> The type of element to be sorted.
 */
public class MergeSort<T extends Comparable<T>> implements Sort<T> {
	
	private T[] arr;
	
	@Override
	public void sort(T[] arr) {
		this.arr = arr;
		mergeSort(0, arr.length-1);
	}
	
	private void mergeSort(int p, int r) {
		if(p < r) {
			int q = (p + r) / 2;
			mergeSort(p, q);
			mergeSort(q + 1, r);
			merge(p, q, r);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void merge(int p, int q, int r) {
		final int n1 = q - p + 1;
		final int n2 = r - q;
		final Object[] left = new Object[n1 + 1];
		final Object[] right = new Object[n2 + 1];
		for(int i=0; i<n1; i++) {
			left[i] = arr[p + i];
		}
		for(int j=0; j<n2; j++) {
			right[j] = arr[q + j + 1]; // 0
		}
		
		// Set null as a "sentinel" card at the end
		// of each array, to indicate that the array
		// is depleted when iterating. We can then
		// sort nulls to be last.
		left[n1] = null;
		right[n2] = null;
		
		int i = 0;
		int j = 0;
		for (int k=p; k <= r; k++) {
			T li = (T)left[i];
			T rj = (T)right[j];
			if (before(li, rj)) {
				arr[k] = li;
				i++;
			} else {
				arr[k] = rj;
				j++;
			}
		}
	}
	
	/**
	 * Returns true if a comes before b. Nulls are considered
	 * to always come last.
	 * @param a
	 * @param b
	 * @return
	 */
	private boolean before(T a, T b) {
		if(a == null) {
			return b == null;
		} else if (b == null) {
			return true;
		} else {
			return a.compareTo(b) <= 0;
		}
	}
}
