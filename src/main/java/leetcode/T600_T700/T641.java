package leetcode.T600_T700;

import java.awt.image.Kernel;

public class T641 {

    private int[] queue;
    private int start = 0, end = 0, size = 0;

    public T641(int k) {
        this.queue = new int[k];
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        if (!isEmpty()) {
            start = start == 0 ? queue.length - 1 : start - 1;
        }
        queue[start] = value;
        ++size;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        if (!isEmpty()) {
            end = end == queue.length - 1 ? 0 : end + 1;
        }
        queue[end] = value;
        ++size;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        if (size > 1) {
            start = start == queue.length - 1 ? 0 : start + 1;
        }
        --size;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        if (size > 1) {
            end = end == 0 ? queue.length - 1 : end - 1;
        }
        --size;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return queue[start];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return queue[end];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public static void main(String[] args) {
        T641 deque = new T641(3);
        deque.insertLast(1);
        deque.insertLast(2);
        deque.insertFront(3);
        deque.insertFront(4);
        System.out.println(deque.getRear());
        System.out.println(deque.isFull());
        deque.deleteLast();
        deque.insertFront(4);
        System.out.println(deque.getFront());
    }

}
