package uk.co.chrisloy.sandpit;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTest {

	@Test
	public void test() {
		examine(new LinkedQueue<String>());
	}
	
	public void examine(Queue<String> queue) {
		assertTrue(queue.isEmpty());
		queue.enqueue("Tom");
		assertFalse(queue.isEmpty());
		queue.enqueue("Dick");
		queue.enqueue("Harry");
		queue.enqueue("Dick");
		queue.enqueue("Dick");
		assertTrue(queue.dequeue().equals("Tom"));
		assertTrue(queue.dequeue().equals("Dick"));
		assertTrue(queue.dequeue().equals("Harry"));
		assertTrue(queue.dequeue().equals("Dick"));
		assertFalse(queue.isEmpty());
		assertTrue(queue.dequeue().equals("Dick"));
		assertTrue(queue.isEmpty());
	}
}
