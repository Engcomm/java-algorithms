package uk.co.chrisloy.sandpit;

/**
 * Interface defining a first-in-first-out queue.
 * 
 * @author Chris Loy
 *
 * @param <T>
 */
public interface Queue<T> {
    
    /**
     * Adds the given argument to the queue.
     */
	public abstract void enqueue(T t);
	
	/**
	 * Removes and returns the head of the queue, or null if
	 * the queue is empty.
	 */
	public abstract T dequeue();

	/**
	 * Returns a boolean indicating whether the queue
	 * is currently empty.
	 */
	public abstract boolean isEmpty();

}