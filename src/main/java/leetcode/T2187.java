package leetcode;

import java.util.Arrays;

public class T2187 {

    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long start = time[0], end = (long) time[0] * totalTrips;
        while (start < end) {
            long mid = start + (end - start) / 2;
            if (satisfied(time, mid, totalTrips)) end = mid;
            else start = mid + 1;
        }
        return start;
    }

    private boolean satisfied(int[] times, long target, int totalTrips) {
        long sum = 0;
        for (int time : times) {
            sum += target / time;
        }
        return sum >= totalTrips;
    }

}
