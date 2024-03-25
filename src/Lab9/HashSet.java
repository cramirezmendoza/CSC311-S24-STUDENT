package Lab9;

public class HashSet implements Set{

    private static final int DEFAULT_SET_SIZE = 16;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    Node[] hashBuckets=new Node[16];

    public HashSet() {
        hashBuckets = new Node[(int)((double)DEFAULT_SET_SIZE/DEFAULT_LOAD_FACTOR)];
    }


    public HashSet(int size) {
        hashBuckets = new Node[(int)((double)size/DEFAULT_LOAD_FACTOR)];
    }

    public HashSet(int size, double loadFactor) {
        hashBuckets = new Node[(int) ((double) size / loadFactor)];
    }


    @Override
    public void add(int item) {
        rehash();
        //Create new node
        Node newNode = new Node(item);
        //Compute bucket (0 to length-1 of buckets array)
        int bucket = computeBucket(item);

        //if the position is empty then add the new node
        Node head = hashBuckets[bucket];
        if (head == null) {
            hashBuckets[bucket] = newNode;
            return;
        }
        //traverse the list and add the new node at the end
        Node current=head;

        while (current != null) {
            //check for duplicates
            System.out.println("Current: "+current.data);
            if (current.data == item) {
                return;
            }
            current = current.next;
        }
        current.next = newNode;


    }

    /**
     * Determines the bucket index for an item using the current number of buckets.
     * The method uses the item's hashcode and the length of the `hashBuckets` array
     * to compute the index, ensuring it is within the bounds of the array.
     *
     * @param item The item for which the bucket index should be determined.
     * @return The bucket index for the item.
     */
    private void rehash() {
        if (size() >= hashBuckets.length * DEFAULT_LOAD_FACTOR) {
            Node[] newBuckets = new Node[hashBuckets.length * 2];

            for (Node oldBucket : hashBuckets) {
                Node current = oldBucket;
                while (current != null) {
                    Node next = current.next; // Save the next node before modifying the current node's next reference

                    // Directly compute the new index based on the new bucket size
                    int newIndex = Math.abs(current.data) % newBuckets.length;

                    // Insert current node into the new bucket at the beginning of the list
                    current.next = newBuckets[newIndex];
                    newBuckets[newIndex] = current;

                    current = next; // Proceed to the next node in the old bucket list
                }
            }

            hashBuckets = newBuckets; // Update hashBuckets with the new array
        }

    }

    private int computeBucket(Integer item) {
        int hash = item.hashCode();
        int index = hash % hashBuckets.length;
        return index;
    }

    /**
    * removes the given item from the collection. The item's value is returned and it
    * is removed from the set if it is present. A {@code SetItemNotFoundException} happens
    * if the item is not present in the set. In order to find the item in the linked list at
    *  that bucket, this approach first determines the bucket index where it should be.
    * The node is eliminated from the list if it is located. In order to exclude the deleted node,
    *  the removal method modifies the list's links.
    * @param item The object to be taken out of the group.
    * @return The object that was taken out.
    * @throws SetItemNotFoundException Should the item not be in the set,
     */

    @Override
    public int remove(int item) throws SetItemNotFoundException {
        int bucketIndex = computeBucket(item);
        Node head = hashBuckets[bucketIndex];
        Node prev = null;

        while (head != null) {
            if (head.data == item) {
                if (prev != null) {
                    prev.next = head.next; // Remove the item from the middle or end of the list
                } else {
                    hashBuckets[bucketIndex] = head.next; // Remove the item from the beginning of the list
                }
                return item;
            }
            prev = head;
            head = head.next;
        }

        // If we reach this point, the item was not found
        throw new SetItemNotFoundException("Item not found: " + item);
    }
    /**
    * removes the given item from the collection. To find and get rid of the item,
    * this method computes the bucket for the item and iterates across the linked
    * list at that bucket index.  If the item is located, it is eliminated, and the
    * procedure returns the removed item. The head of the list changes to the following node
    * if the item is at the start of the list. The item is removed by changing the previous node's
    *  next reference if it is at the middle or end of the list.
    * A SetItemNotFoundException is raised if the item cannot be located.
    *
    * @param item The object that needs to be taken out.
    * @return The object that was taken out.
    * @throws SetItemNotFoundException Should the item not be in the set
     */
    @Override
    public boolean contains(int item) {
        int bucketIndex = computeBucket(item);
        Node head = hashBuckets[bucketIndex];

        while (head != null) {
            if (head.data == item) {
                return true; // Item found
            }
            head = head.next;
        }

        return false; // Item not found
    }

    @Override
    public int size() {

        int count = 0;
        for (int i = 0; i < hashBuckets.length; i++) {
            Node current = hashBuckets[i];
            while (current != null) {
                count++;
                current = current.next;
            }
        }
        return count;

    }
    /**
    * determines whether the set is empty.
    * If there are no items in the set, it is regarded as empty.
    * @return {@code false} otherwise, {@code true} if the set contains no entries.
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
    /**
    * eliminates every item in this set.
    * By reinitializing the array of buckets, the method basically resets the size
    * of the set to zero and removes all items from it.
     */
    @Override
    public void clear() {
        hashBuckets = new Node[hashBuckets.length];

    }

    public String toString() {
        String result = "{";
        for (int i = 0; i < hashBuckets.length; i++) {
            Node current = hashBuckets[i];
            while (current != null) {
                result += current.data + " ";
                current = current.next;
            }
        }
        return result += "}";
    }

}
