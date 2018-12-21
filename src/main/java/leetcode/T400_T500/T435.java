package leetcode.T400_T500;

import java.util.Arrays;

public class T435 {

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1.end != o2.end) {
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        });

        int res = 1;
        Interval pre = intervals[0];
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i].start >= pre.end) {
                pre = intervals[i];
                ++res;
            }
        }
        return intervals.length - res;
    }

}
