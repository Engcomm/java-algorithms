package uk.co.chrisloy.sandpit;

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

	@SuppressWarnings("unchecked")
	@Override
	public T pop() {
		if(isEmpty()) {
			return null;
		} else {
			return (T)arr[top--];
		}
	}
}
