package uk.co.chrisloy.sandpit.sort;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import uk.co.chrisloy.sandpit.sort.HeapSort;
import uk.co.chrisloy.sandpit.sort.QuickSort;
import uk.co.chrisloy.sandpit.sort.Sort;

public class SortTest {
	
	private List<Integer> l;
	
	private class TrustedSort implements Sort<Integer> {

		@Override
		public void sort(Integer[] arr) {
			l = new ArrayList<Integer>(arr.length);
			for(Integer i : arr) {
				l.add(i);
			}
			long t3 = System.currentTimeMillis();
			Collections.sort(l);
			long t4 = System.currentTimeMillis();
			System.out.println("Time: " + (t4 - t3) + "ms for Collections.sort");
		}
	}
	
	@Test
	public void test() {
		new TrustedSort().sort(getArray());
		examine(new QuickSort<Integer>());
		examine(new HeapSort<Integer>());
		examine(new MergeSort<Integer>());
		//examine(new BubbleSort<Integer>()); too slow!
	}
	
	private void examine(Sort<Integer> sort) {
		Integer[] arr = getArray();
		long t1 = System.currentTimeMillis();
		sort.sort(arr);
		long t2 = System.currentTimeMillis();
		System.out.println("Time: " + (t2 - t1) + "ms for " + sort);
		for(int i=0; i<arr.length; i++) {
			assertTrue(l.get(i).equals(arr[i]));
		}
	}
	
	private Integer[] getArray() {
		int size = 100000;
		Random random = new Random(123);
		Integer[] arr = new Integer[size];
		for(int i=0; i<arr.length; i++) {
			arr[i] = random.nextInt(size);
		}
		return arr;
	}
}
