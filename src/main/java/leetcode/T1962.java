package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class T1962 {

    public int minStoneSum(int[] piles, int k) {
        Queue<Integer> queue = new PriorityQueue<>((p1, p2) -> p2 - p1);
        for (int pile : piles) queue.add(pile);
        while (k-- > 0) {
            int num = queue.poll();
            queue.add(num - num / 2);
        }
        int res = 0;
        for (Integer num : queue) res += num;
        return res;
    }

}
