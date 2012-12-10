package uk.co.chrisloy.sandpit;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackTest {

	@Test
	public void test() {
		examine(new LinkedStack<Integer>());
		examine(new ArrayStack<Integer>(128));
	}
	
	public void examine(Stack<Integer> s) {
		assertTrue(s.isEmpty());
		s.push(45);
		assertFalse(s.isEmpty());
		s.push(12);
		assertFalse(s.isEmpty());
		s.push(35);
		assertFalse(s.isEmpty());
		assertTrue(s.pop() == 35);
		assertFalse(s.isEmpty());
		assertTrue(s.pop() == 12);
		assertFalse(s.isEmpty());
		assertTrue(s.pop() == 45);
		assertTrue(s.isEmpty());
		assertTrue(s.pop() == null);
	}
}
