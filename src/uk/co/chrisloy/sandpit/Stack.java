package uk.co.chrisloy.sandpit;

public interface Stack<T> {

	public boolean isEmpty();

	public void push(T value);

	/**
	 * Returns null if empty.
	 * 
	 * @return
	 */
	public T pop();
	
	public T peek();
	
	public boolean contains(T value);

}