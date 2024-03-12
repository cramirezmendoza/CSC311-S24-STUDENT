package Lab7;

public class LinkedQueue implements Queue{
    private int[] nums;
    private int capacity;
    private int left;
    private int right;

    public LinkedQueue(int size){
        nums = new int[size];
        capacity = 0;
        left = 0;
        right = -1;
    }
    @Override
    public void add(int data) {
        if(capacity == nums.length){
            right = (right + 1) % nums.length;
            nums[right] = data;
            capacity++;
        }

    }

    @Override
    public int remove() throws QueueEmptyException {
        return 0;
    }

    @Override
    public int peek() throws QueueEmptyException {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }
}
