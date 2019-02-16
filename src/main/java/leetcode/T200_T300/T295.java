package leetcode.T200_T300;

import java.util.Comparator;
import java.util.PriorityQueue;

public class T295 {

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    /**
     * initialize your data structure here.
     */
    public T295() {
        minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    public void addNum(int num) {
        minHeap.add(num);
        maxHeap.add(minHeap.poll());
        if (minHeap.size() < maxHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (((maxHeap.size() + minHeap.size()) & 1) == 0) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            return minHeap.peek();
        }
    }
}
