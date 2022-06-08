package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class T1353 {

    public int maxEvents(int[][] events) {
        Queue<Integer> queue = new PriorityQueue<>();
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        int i = 0, res = 0, d = 0, n = events.length;
        while (!queue.isEmpty() || i < n) {
            if (queue.isEmpty())
                d = events[i][0];
            while (i < n && events[i][0] <= d)
                queue.offer(events[i++][1]);
            queue.poll();
            ++res;
            ++d;
            while (!queue.isEmpty() && queue.peek() < d)
                queue.poll();
        }
        return res;
    }

}
