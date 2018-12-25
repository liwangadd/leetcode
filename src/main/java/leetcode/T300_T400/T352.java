package leetcode.T300_T400;

import java.util.*;

public class T352 {

    private static class Interval {
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

    private List<Integer> list;

    public T352() {
        list = new LinkedList<>();
    }

    public void addNum(int val) {
        if (!list.contains(val))
            list.add(val);
    }

    public List<Interval> getIntervals() {
        List<Interval> res = new LinkedList<>();
        if (list.size() == 0) return res;
        Collections.sort(list);
        Iterator<Integer> iter = list.iterator();
        int start = iter.next();
        int current, end = start;
        while (iter.hasNext()) {
            current = iter.next();
            if (current - end != 1) {
                Interval interval = new Interval(start, end);
                res.add(interval);
                start = current;
            }
            end = current;
        }
        res.add(new Interval(start, end));
        return res;
    }

}
