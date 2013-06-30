package uk.co.chrisloy.sandpit.sort;

/**
 * Very simple sorting algorithm which iterates repeatedly over an array,
 * dragging the highest value to the top each time (or letting it "bubble
 * up") and then iterating again up to one array position less.
 * 
 * Has O(n^2) performance which is very slow, and really is only here for
 * interest.
 * 
 * @author Chris Loy
 *
 * @param <T>
 */
public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] arr) {
        int j = arr.length;
        while(j > 0) {
            for(int i=0; i<j-1; i++) {
                if(arr[i].compareTo(arr[i+1]) > 0) {
                    T low = arr[i+1];
                    T high = arr[i];
                    arr[i] = low;
                    arr[i+1] = high;
                }
            }
            j--;
        }
    }
}
