package uk.co.chrisloy.sandpit.sort;

/**
 * Can I remember?
 * 
 * @author chrisloy
 *
 */
public class MergeSort2<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] arr) {
        mergeSort(arr, 0, arr.length);
    }
    
    /**
     * From inclusive, to exclusive
     * 
     * @param ts
     * @param i
     * @param j
     */
    private void mergeSort(T[] ts, int i, int j) {
        int mid = i + j / 2;
        mergeSort(ts, i, mid);
        mergeSort(ts, mid, j);
        merge(ts, i, mid, j);
    }
    
    /**
     * From inclusive, to exclusive
     * 
     * @param i1
     * @param i2
     * @param j1
     * @param j2
     */
    private void merge(T[] ts, int i, int mid, int j) {
        int a = i;
        int b = mid;
        while(a < mid && b < j) {
            if(ts[a].compareTo(ts[b]) > 0) {
                
            }
        }
    }
}
