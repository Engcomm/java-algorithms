package uk.co.chrisloy.sandpit;

public interface Queue<T> {

	public abstract void enqueue(T t);

	public abstract T dequeue();

	public abstract boolean isEmpty();

}