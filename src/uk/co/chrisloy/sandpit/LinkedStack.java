package uk.co.chrisloy.sandpit;

/**
 * Stack implementation which uses object references between
 * contained Nodes to represent the stack. No limit to upper
 * size.
 * 
 * @author Chris Loy
 *
 * @param <T>
 */
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
	
	@Override
	public boolean isEmpty() {
		return top == null;
	}
	
	@Override
	public void push(T value) {
		this.top = new Node(value, top);
	}
	
	@Override
	public boolean contains(T value) {
	    Node curr = top;
	    while(curr != null) {
	        if(curr.equals(value)) {
	            return true;
	        }
	        curr = curr.next;
	    }
	    return false;
	}
	
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
	
	@Override
	public T peek() {
	    return top.value;
	}
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack:[");
        Node curr = top;
        while(curr != null) {
            sb.append(curr.value);
            if(curr.next != null) {
                sb.append(", ");
            }
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
