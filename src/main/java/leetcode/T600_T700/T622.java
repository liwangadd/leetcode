package leetcode.T600_T700;

public class T622 {

    private int[] queue;
    private int startIndex, endIndex;
    private int size;

    public T622(int k) {
        queue = new int[k];
        this.startIndex = -1;
        this.endIndex = 0;
        this.size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        startIndex = (startIndex + 1) % queue.length;
        queue[startIndex] = value;
        ++size;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        endIndex = (endIndex + 1) % queue.length;
        --size;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return queue[endIndex];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return queue[startIndex];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public static void main(String[] args) {
        T622 queue = new T622(3);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);

    }

}
