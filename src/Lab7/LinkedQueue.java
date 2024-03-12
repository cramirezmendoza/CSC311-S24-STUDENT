package Lab7;

import Lab7.common.com.usman.csudh.csc311.datastructures.Queue;
import Lab7.common.com.usman.csudh.csc311.datastructures.QueueEmptyException;

public class LinkedQueue implements Queue {
    // front of queue
    private Node head = null;
    // end of queue
    private Node tail = null;
    // number of items in queue
    private int size = 0;

    @Override
    public void add(int data) {
        Node addNode = new Node(data);
        // if the queue is empty, have both head and tail point to the addNode
        if(tail == null){
            head = tail = addNode;
        } else {
            // else link the addNode to the tail node and update it to the addNode
            tail.next = addNode;
            tail = addNode;
        }
        // account for new size and increase it
        size++;
    }

    @Override
    public int remove() throws QueueEmptyException {
        if(isEmpty()) throw new QueueEmptyException("Queue is Empty");
        // get node at the front
        int data = head.data;
        // move the head to the next node, i.e. removing first node
        head = head.next;
        // in case we removed the only node and made the queue empty, make the tail null
        if(head == null){
            tail = null;
        }
        // decrease the size
        size --;
        // return data from removed node
        return data;
    }

    @Override
    public int peek() throws QueueEmptyException {
        if(isEmpty()) throw new QueueEmptyException("Queue is Empty");
        // return the head without changing anything
        return head.data;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

}
