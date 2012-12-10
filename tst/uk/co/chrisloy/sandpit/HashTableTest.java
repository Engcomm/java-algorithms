package uk.co.chrisloy.sandpit;

import static org.junit.Assert.*;

import org.junit.Test;

public class HashTableTest {

	@Test
	public void test() {
		examine(new HashTable<Object, Object>(3));
	}
	
	private void examine(HashTable<Object, Object> ht) {
		ht.insert(34, "ThirtyFour");
		ht.insert(34, "New");
		ht.insert("POW", "ZAP");
		assertTrue(ht.search(34).equals("New"));
		assertTrue(ht.search("POW").equals("ZAP"));
		assertTrue(ht.search(26) == null);
		
	}
}
