package uk.co.chrisloy.sandpit;

/**
 * First-in-first-out queue implementation which uses references
 * between adjacent nodes in the queue to provide structure. No
 * limit to upper size.
 * 
 * @author Chris Loy
 *
 * @param <T>
 */
public class LinkedQueue<T> implements Queue<T> {
	
	private class Node {
		
		final T value;
		Node next;
		
		Node(T value) {
			this.value = value;
		}
	}
	
	private Node head;
	private Node tail;
	
	public LinkedQueue() {
		this.head = null;
		this.tail = null;
	}
	
	@Override
	public void enqueue(T t) {
		Node node = new Node(t);
		if(tail != null) {
			tail.next = node;
		}
		if(head == null) {
			head = node;
		}
		tail = node;
	}
	
	@Override
	public T dequeue() {
		if(head == null) {
			return null;
		} else {
			T r = head.value;
			head = head.next;
			if(head == null) {
				tail = null;
			}
			return r;
		}
	}
	
	@Override
	public boolean isEmpty() {
		return head == null;
	}
}
