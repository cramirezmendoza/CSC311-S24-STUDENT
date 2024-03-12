package Lab7;

import Lab7.common.com.usman.csudh.csc311.datastructures.Stack;
import Lab7.common.com.usman.csudh.csc311.datastructures.StackEmptyException;

public class LinkedStack implements Stack {
    // end is the top? or looking from left to right, the right is the top of the stack
    private Node end;
    // number of items in stack
    private int size;

    public LinkedStack(){
        this.end = null; //start with no items in stack
        this.size = 0; // start at 0
    }
    @Override
    public void push(int data) {
        Node pushNode = new Node(data);
        pushNode.next = end; // make the pushNode connect to the last node from the end
        end = pushNode; // change new end to be new pushNode
        size++; // adjust size

    }

    @Override
    public int pop() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty");
        }
        int data = end.data; // get item from the end node
        end = end.next; // get the end node to the next node, i.e. removing from right side
        size--; // adjust size
        return data; // return data from popped node
    }

    @Override
    public int peek() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty");
        }
        return end.data; // return the right side without changing anything
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return end == null;
    }

    @Override
    public void clear() {
        end = null;
        size = 0;
    }
}
