package uk.co.chrisloy.sandpit;

public class LinkedStack<T> implements Stack<T> {
	
	private class Node {
		
		final T value;
		final Node next;
		
		Node(T value, Node next) {
			this.value = value;
			this.next = next;
		}
	}
	
	private Node top;
	
	public LinkedStack() {
		this.top = null;
	}
	
	/* (non-Javadoc)
	 * @see uk.co.chrisloy.sandpit.Stack#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return top == null;
	}
	
	/* (non-Javadoc)
	 * @see uk.co.chrisloy.sandpit.Stack#push(T)
	 */
	@Override
	public void push(T value) {
		this.top = new Node(value, top);
	}
	
	/* (non-Javadoc)
	 * @see uk.co.chrisloy.sandpit.Stack#pop()
	 */
	@Override
	public T pop() {
		if(top != null) {
			T r = top.value;
			top = top.next;
			return r;
		} else {
			return null;
		}
	}
}
