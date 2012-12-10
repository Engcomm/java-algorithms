package uk.co.chrisloy.sandpit.sort;

public interface Sort<T extends Comparable<T>> {
	
	public void sort(T[] arr);
}
