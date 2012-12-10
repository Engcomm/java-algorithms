package uk.co.chrisloy.sandpit;

public class HashTable<K, V> {
	
	private static class Entry {
		
		final Object key;
		final Object value;
		final int hash;
		
		Entry next;
		
		Entry(Object key, Object value) {
			this.key = key;
			this.value = value;
			this.hash = key.hashCode();
			this.next = null;
		}
	}
	
	private Entry[] arr;

	public HashTable(int capacity) {
		this.arr = new Entry[capacity];
	}
	
	public void insert(K key, V value) {
		Entry e = new Entry(key, value);
		int i = getArrayPos(e.hash);
		e.next = arr[i];
		arr[i] = e;
	}
	
	@SuppressWarnings("unchecked")
	public V search(K key) {
		int i = getArrayPos(key.hashCode());
		Entry e = arr[i];
		while(e != null) {
			if(e.key == key || e.key.equals(key)) {
				return (V)e.value;
			}
			e = e.next;
		}
		return null;
	}
	
	private int getArrayPos(int hash) {
		return hash % arr.length;
	}
}
