package Lab7;



/**
 * This is an interface for Stack data structure. It contains all the key methods that a stack should support.
 */
public interface Stack {

    /**
     * Adds an element to the top of the stack
     * @param data
     */
    public void push(int data);

    /**
     * Removes an element from the top of the stack
     *
     * @return the element removed from the top of the stack
     * @throws StackEmptyException if the stack is empty
     */
    public int pop() throws StackEmptyException;

    /**
     * Provides a view of the element at the top of the stack without removing it
     *
     * @return the element at the top of the stack
     * @throws StackEmptyException if the stack is empty
     */
    public int peek() throws StackEmptyException;

    /**
     * Returns the number of elements in the stack
     *
     * @return the number of elements in the stack
     */
    public int size();

    /**
     * Returns true if the stack is empty
     *
     * @return true if the stack is empty
     */
    public boolean isEmpty();

    /**
     * Clears the stack
     */
    public void clear();

}

