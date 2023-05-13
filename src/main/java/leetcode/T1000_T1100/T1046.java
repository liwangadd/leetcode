package leetcode.T1000_T1100;

import java.util.PriorityQueue;
import java.util.Queue;

public class T1046 {

    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>((e1, e2) -> e2 - e1);
        for (int stone : stones) {
            queue.add(stone);
        }
        while (queue.size() > 1) {
            int num1 = queue.poll();
            int num2 = queue.poll();
            if (num1 != num2) {
                queue.add(Math.abs(num1 - num2));
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }

}
