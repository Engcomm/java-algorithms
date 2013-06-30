package uk.co.chrisloy.sandpit;

import java.util.Arrays;

/**
 * Simple array-based hash table implementation. Each key stored in the
 * table will have it's hashCode method called, and used to calculate the
 * array index position where it will be stored. Collisions are handled
 * by using a linked list.
 * 
 * @author Chris Loy
 *
 * @param <K> Type of the key objects, which should have a well-defined hashCode.
 * @param <V> Type of value stored. Use Void and pass in null if mapping not needed.
 */
public class HashTable<K, V> {
	
    /**
     * Class encapsulating key-value pair, and enabling
     * the linked-list storage of collisions. The key's
     * hash is also cached here.
     * 
     * @author Chris Loy
     */
	public static class Entry<K, V> {
		
		final K key;
		final V value;
		final int hash;
		
		Entry<K, V> next;
		
		Entry(K key, V value) {
			this.key = key;
			this.value = value;
			this.hash = key.hashCode();
			this.next = null;
		}

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
        
        @Override
        public String toString() {
            return key + ":" + value;
        }
	}
	
	private Entry<K, V>[] arr;
	private int size;

	@SuppressWarnings("unchecked")
    public HashTable(int capacity) {
		this.arr = new Entry[capacity];
		this.size = 0;
	}
	
	public void insert(K key, V value) {
		Entry<K, V> e = new Entry<K, V>(key, value);
		int i = getArrayPos(e.hash);
		e.next = arr[i];
		arr[i] = e;
		size++;
	}
	
	public V search(K key) {
		int i = getArrayPos(key.hashCode());
		Entry<K, V> e = arr[i];
		while(e != null) {
			if(e.key == key || e.key.equals(key)) {
				return e.value;
			}
			e = e.next;
		}
		return null;
	}
	
	public boolean containsKey(K key) {
	    return search(key) != null;
	}
	
	private int getArrayPos(int hash) {
		return hash % arr.length;
	}
	
	public Entry<K, V>[] getEntries() {
	    return arr;
	}
	
	public int size() {
	    return size;
	}
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("HashTable:");
	    sb.append(Arrays.toString(arr));
	    return sb.toString();
	}
}
