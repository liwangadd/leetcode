package leetcode.T1_T100;

import java.util.LinkedList;
import java.util.List;

public class T56 {

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

    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort((o1, o2) -> {
            if (o1.start != o2.start) return o1.start - o2.start;
            else return o1.end - o2.end;
        });

        List<Interval> res = new LinkedList<>();
        if (intervals.size() == 0) return res;
        Interval prev = new Interval(intervals.get(0).start, intervals.get(0).end);
        for (int i = 1; i < intervals.size(); ++i) {
            Interval current = intervals.get(i);
            if (current.start <= prev.end) {
                prev.end = Math.max(current.end, prev.end);
            } else {
                res.add(prev);
                prev = new Interval(current.start, current.end);
            }
        }
        res.add(prev);
        return res;
    }

}
