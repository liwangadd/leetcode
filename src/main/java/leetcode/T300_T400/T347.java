package leetcode.T300_T400;

import java.util.*;

public class T347 {

    public class Node {
        int num;
        int freq;

        public Node(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new LinkedList<>();
        if (nums == null || nums.length == 0) return res;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(k, Comparator.comparingInt(o -> o.freq));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue());
            if (priorityQueue.size() == k) {
                if (priorityQueue.peek().freq < node.freq) {
                    priorityQueue.poll();
                    priorityQueue.add(node);
                }
            } else {
                priorityQueue.add(node);
            }
        }
        for (Node node : priorityQueue) {
            res.add(node.num);
        }
        return res;
    }

}
