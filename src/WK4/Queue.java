package WK4;

public class Queue {
    private int[] elements;
    private int size;
    private int capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        elements = new int[capacity];
        size = 0;
    }


    public void add(int element) {
        if (size == capacity) {
            System.out.println("Queue is full. Cannot add elements.");
            return;
        }
        elements[size++] = element;
    }


    public int remove() {
        if (size == 0) {
            System.out.println("Queue is empty. Cannot remove elements.");
            return -1; // show queue is empty
        }
        int removedElement = elements[0];
        // Shift left
        for (int i = 0; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return removedElement;
    }

    //  check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

}




