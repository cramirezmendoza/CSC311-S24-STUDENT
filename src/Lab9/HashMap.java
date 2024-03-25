package Lab9;

public class HashMap implements Map{

    //Intitial bucket size
    private static final int DEFAULT_BUCKET_SIZE = 16;

    //default load factor
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    //Buckets
    MapNode buckets[];
    double loadFactor;


    public HashMap() {
        loadFactor = DEFAULT_LOAD_FACTOR;
        buckets = new MapNode[DEFAULT_BUCKET_SIZE];
    }

    public HashMap(int maxItems) {
        this(maxItems, DEFAULT_LOAD_FACTOR);
    }

    public HashMap(int maxItems, double loadFactor) {
        buckets = new MapNode[(int)((double)maxItems/loadFactor)];
    }



    private int computeBucket(String key) {
        int hash = key.hashCode();

        //evaluate a value between 0 and 15
        int index = hash % buckets.length;
        return index;
    }
    /**
     * Rehashing the HashMap's contents to a new array of buckets with twice the capacity
     * When the map's current size reaches or beyond the threshold determined by multiplying the
     * load factor by the current capacity, an automated call to this function is made.
     * Rehashing makes sure the distribution stays effective even as the number of
     * items increases by re-inserting each key-value pair into the new bucket array based on
     * its key's hashcode. Since the HashMap class is supposed to call this function internally
     */
    private void rehash() {

        // Only rehash when the size threshold is exceeded
        if (size() >= buckets.length * loadFactor) {
            MapNode[] oldBuckets = buckets;
            buckets = new MapNode[oldBuckets.length * 2]; // Double the number of buckets

            // Re-insert each key-value pair into the new buckets
            for (MapNode oldBucket : oldBuckets) {
                MapNode current = oldBucket;
                while (current != null) {
                    MapNode next = current.next;
                    // Insert current into the new bucket
                    int index = computeBucket(current.key);
                    current.next = buckets[index];
                    buckets[index] = current;
                    current = next; // Move to the next node
                }
            }
        }

    }



    public void put(String key, String value) {
        rehash();
        MapNode newNode = new MapNode(key, value);

        int bucket= computeBucket(key);
        MapNode head = buckets[bucket];


        if (head == null) {
            head = newNode;
            buckets[bucket] = head;
            return;
        }

        MapNode current = head;

        while (current.next != null) {
            current = current.next;

            //Ensure there is no duplicate key
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
        }
        current.next = newNode;
    }

    @Override
    public String get(String key) {
        int bucket= computeBucket(key);
        MapNode head = buckets[bucket];
        //return null if the map is empty
        if (head == null) {
            return null;
        }

        //if map is not empty then start from head
        // and keep moving to the next node until the key is found
        MapNode current = head;

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }
    /**
     * gives back a string representation of the map with a list of key-value pairs surrounded in curly braces,
     * separated by commas. The {@code toString()} representations of the keys and values serve as their
     * representations. To construct the string, this method iterates over each bucket and each entry within
     * those buckets. The string that is returned will be "{}" if the map is empty.
     * @return a string that contains every key-value pair in the map.
     */
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        boolean first = true;

        // Iterate over each bucket
        for (MapNode bucket : buckets) {
            // Iterate over each node in the bucket
            for (MapNode current = bucket; current != null; current = current.next) {
                if (!first) {
                    result.append(", ");
                } else {
                    first = false;
                }
                result.append(current.key).append(": ").append(current.value);
            }
        }

        result.append("}");
        return result.toString();
    }

    @Override
    /**
     * If an entry for the given key exists in this map, it is removed. Using the key hash as a guide,
     * this method looks for the entry in the bucket. An entry is deleted from the map and its value is
     * returned if one with the matching key can be located. In case the entry cannot be located, the method
     * returns {@code null}.
     * Any other entries in the same bucket are unaffected and stay on the map even if the entry with the
     * designated key is located and deleted. If the key is present, this could shrink the map by one.
     * @param key The key that needs to have its mapping deleted from the map.
     * @return If the key existed in the map, the value corresponding to it.
     * if not, {@code null} indicates that there was no mapping for the key in the map.
     * The map may have directly mapped the key to {@code null}, in which case the result of
     * {@code null} does not imply that the map included no mapping for the key.
     */
    public String remove(String key) {
        int bucketIndex = computeBucket(key);
        MapNode head = buckets[bucketIndex];
        MapNode prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                if (prev != null) {
                    prev.next = head.next;
                } else {
                    buckets[bucketIndex] = head.next;
                }
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }

    @Override
    /**
     * determines whether there is a mapping for the given key in this map. In order to
     * identify a matching key, the method first checks the bucket index for the key
     * and then iterates across the linked list at that index. Using the hash-based structure to
     * reduce the amount of comparisons required, this methods uses a rapid approach to determine
     * whether a key is present in the map.
     * @param key The key that needs to be verified to be present in this map.
     * If this map has a mapping for the given key, @return {@code true}; if not, @return {@code false}.
     */
    public boolean containsKey(String key) {
        int bucketIndex = computeBucket(key);
        MapNode node = buckets[bucketIndex];
        while (node != null) {
            if (node.key.equals(key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    /**
     * Checks whether one or more keys on this map correspond to the given value.
     * This method iterates through all buckets and their corresponding linked lists in search of a
     * matched value because values are not hashed.
     * Due to the need to look through the full map, this operation may be less efficient than {@code containsKey}.
     * On the other hand, it comes in handy when you need to find out if a certain value is seen anywhere on the map.
     * @param value The value that has to be verified if it exists in this map.
     * If this map maps one or more keys to the given value, @return {@code true};
     * if not, @return {@code false}.
     */
    public boolean containsValue(String value) {

        for (MapNode bucket : buckets) {
            MapNode node = bucket;
            while (node != null) {
                if (node.value.equals(value)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    @Override
    public int size() {
        //Iterate through the buckets and count the number of nodes
        int count = 0;
        for (int i = 0; i < buckets.length; i++) {
            MapNode current = buckets[i];
            while (current != null) {
                count++;
                current = current.next;
            }
        }
        return count;
    }

    @Override
    /**
     * Checks if the map is empty. There are no key-value mappings in an empty map.
     * This method makes use of the {@code size} method to figure out whether the map is empty
     * if the total count of key-value pairs in the map is equal to zero.
     * If there are no key-value mappings in this map, @return {@code true};
     * if not, @return {@code false}.
     */
    public boolean isEmpty() {

        return size() == 0;
    }

    @Override
    /**
     * removes every mapping from that specific map.
     * When this call returns, the map will be empty. The map is essentially reset by this operation,
     * erasing all key-value pairs that have been stored.
     * All previous contents are removed and a new array of the same size is
     * initialized for the internal bucket array.
     * The map's size, however, has not changed.
     */
    public void clear() {
       buckets = new MapNode[buckets.length];
    }

    @Override
    /**
    * gives back an array containing every key in this map.
    * To get the keys, this method repeatedly goes through each bucket and each node within of those buckets.
    * The number of key-value mappings in the map and the size of the returned array match.
    * When you need to run operations based on the map's keys or iterate over keys, this method is clutch.
    * @return an array with every key in this map contained in it. Returns an empty array if the map is empty.
    */
    public String[] keys() {
        String[] keys = new String[size()];
        int index = 0;
        for (MapNode bucket : buckets) {
            for (MapNode node = bucket; node != null; node = node.next) {
                keys[index++] = node.key;
            }
        }
        return keys;
    }

    @Override
    /**
    * gives back an array containing every value found in this map.
    * This method collects values by repeatedly iterating through all
    * buckets and nodes within those buckets, much as the {@code keys} method.
    * The number of key-value mappings in the map is matched by the size of the returned array.
    * All the values in the map can be collected using this operation.
    * Similar to the keys, the values in the returned array do not always match to the keys' precise
    * order of insertion.
    * @return an array holding every value found in this map.
    * Returns an empty array if the map is empty.
    */
    public String[] values() {
        String[] values = new String[size()];
        int index = 0;
        for (MapNode bucket : buckets) {
            for (MapNode node = bucket; node != null; node = node.next) {
                values[index++] = node.value;
            }
        }
        return values;
    }

}
