package leetcode.T600_T700;

import java.util.PriorityQueue;
import java.util.TreeMap;

public class T703 {

    class KthLargest {

        private PriorityQueue<Integer> minHeap;
        private int heapSize;

        public KthLargest(int k, int[] nums) {
            this.minHeap = new PriorityQueue<>(k);
            this.heapSize = k;
            for (int num : nums) {
                addToHeap(num);
            }
        }

        private void addToHeap(int num) {
            if (minHeap.size() >= heapSize && num > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(num);
            } else if (minHeap.size() < heapSize) {
                minHeap.add(num);
            }
        }

        public int add(int val) {
            addToHeap(val);
            return minHeap.peek();
        }
    }


}
