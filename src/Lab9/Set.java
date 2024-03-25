package Lab9;

public interface Set {

    /**
     * Add an element to the set
     *
     * @param data the element to add to the set
     */
    public void add(int data);


    /**
     * Delete an element from the set at a specific index and returns the delete
     * item this has been an improved version of the delete method
     *
     * @param item the index to delete the element from
     * @throws SetItemNotFoundException if the index is invalid
     */
    public int remove(int item) throws SetItemNotFoundException;

    public boolean contains(int item);

    public int size();
    public boolean isEmpty();
    public void clear();
}
