package Lab7;
//test
/**
 * This interface represents a queue data structure. It contains all the key methods that a queue should support.
 */
public interface Queue {
	
	/**
	 * Add an element to tail of the queue	
	 * @param data the element to add to the queue
	 */
	public void add(int data);
	
	/**
	 * Remove an element from the head of the queue
	 * @return the element removed from the head of the queue
	 * @throws QueueEmptyException if the queue is empty
	 */
	public int remove() throws QueueEmptyException;
	
	/**
	 * Provides a view of the element at the head of the queue without removing it
	 * @return the element at the head of the queue
	 * @throws QueueEmptyException if the queue is empty
	 */
	public int peek() throws QueueEmptyException;
	
	/**
	 * Returns the number of elements in the queue
	 * @return the number of elements in the queue
	 */
	public int size();
	
	/**
	 * Returns true if the queue is empty
	 * @return true if the queue is empty
	 */
	public boolean isEmpty();
	
	/**
	 * Clears the queue
	 */
	public void clear();

}
