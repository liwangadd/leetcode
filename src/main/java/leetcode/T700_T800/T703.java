package leetcode.T700_T800;

import java.util.PriorityQueue;
import java.util.Queue;

public class T703 {

    class KthLargest {

        private Queue<Integer> minHeap;
        private int heapSize;

        public KthLargest(int k, int[] nums) {
            this.heapSize = k;
            this.minHeap = new PriorityQueue<>();
            for (int num : nums) {
                addHeap(num);
            }
        }

        public int add(int val) {
            addHeap(val);
            return minHeap.peek();
        }

        private void addHeap(int num) {
            minHeap.add(num);
            while (minHeap.size() > heapSize) {
                minHeap.poll();
            }
        }
    }


}
