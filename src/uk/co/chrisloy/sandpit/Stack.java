package uk.co.chrisloy.sandpit;

public interface Stack<T> {

	public abstract boolean isEmpty();

	public abstract void push(T value);

	/**
	 * Returns null if empty.
	 * 
	 * @return
	 */
	public abstract T pop();

}