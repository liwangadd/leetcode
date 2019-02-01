package leetcode.T200_T300;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class T253 {

    public static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return 0;
        intervals.sort(Comparator.comparingInt(o -> o.start));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int minRooms = 1;
        for (Interval interval : intervals) {
            while (!queue.isEmpty() && interval.start > queue.peek()) queue.poll();
            queue.add(interval.end);
            minRooms = Math.max(minRooms, queue.size());
        }
        return minRooms;
    }

}
