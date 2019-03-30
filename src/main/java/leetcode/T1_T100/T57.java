package leetcode.T1_T100;

import utils.Interval;

import java.util.LinkedList;
import java.util.List;

public class T57 {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new LinkedList<>();
        boolean isInsert = false;
        if (intervals.size() == 0 || intervals.get(0).start > newInterval.end) {
            res.add(newInterval);
            res.addAll(intervals);
        } else if (intervals.get(intervals.size() - 1).end < newInterval.start) {
            res.addAll(intervals);
            res.add(newInterval);
        } else {
            Interval insertInterval = new Interval(newInterval.start, newInterval.end);
            for (int i = 0; i < intervals.size(); ++i) {
                Interval interval = intervals.get(i);
                if (interval.end < newInterval.start) res.add(interval);
                else if (interval.start > newInterval.end) {
                    if (!isInsert) {
                        res.add(newInterval);
                        res.add(interval);
                        isInsert = true;
                    } else {
                        res.add(interval);
                    }
                } else {
                    insertInterval.start = Math.min(interval.start, newInterval.start);
                    while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
                        insertInterval.end = Math.max(intervals.get(i).end, newInterval.end);
                        ++i;
                    }
                    isInsert = true;
                    res.add(insertInterval);
                    --i;
                }
            }
        }
        return res;
    }
}
