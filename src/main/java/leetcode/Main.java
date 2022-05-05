package leetcode;

import java.nio.file.FileStore;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    private Queue<Integer> firstQueue;

    private Queue<Integer> secondQueue;

    public Main() {
        this.firstQueue = new LinkedList<>();
        this.secondQueue = new LinkedList<>();
    }

    public void push(int x) {
        if (!firstQueue.isEmpty()) {
            firstQueue.offer(x);
        } else {
            secondQueue.offer(x);
        }
    }

    public int pop() {
        if (!firstQueue.isEmpty()) {
            while (firstQueue.size() > 1) {
                secondQueue.offer(firstQueue.poll());
            }
            return firstQueue.poll();
        } else {
            while (secondQueue.size() > 1) {
                firstQueue.offer(secondQueue.poll());
            }
            return secondQueue.poll();
        }
    }

    public int top() {
        int ele = pop();
        push(ele);
        return ele;
    }

    public boolean empty() {
        return firstQueue.isEmpty() && secondQueue.isEmpty();
    }
}
