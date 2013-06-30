package uk.co.chrisloy.sandpit;

/**
 * Array-based implementation of a last-in-first-out stack.
 * 
 * @author Chris Loy
 *
 * @param <T>
 */
public class ArrayStack<T> implements Stack<T> {
	
	private final Object[] arr;
	private int top;
	
	public ArrayStack(int capacity) {
		this.arr = new Object[capacity];
		this.top = -1;
	}
	
	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public void push(T value) {
		arr[++top] = value;
	}
	
	@Override
	public boolean contains(T value) {
	    for (Object o : arr) {
	        if (value.equals(o)) {
	            return true;
	        }
	    }
	    return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T pop() {
		if(isEmpty()) {
			return null;
		} else {
			return (T)arr[top--];
		}
	}
	
	@SuppressWarnings("unchecked")
    @Override
    public T peek() {
	    return (T)arr[top];
	}
}
