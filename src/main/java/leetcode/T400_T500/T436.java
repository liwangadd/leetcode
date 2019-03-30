package leetcode.T400_T500;

import utils.Interval;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class T436 {


    public int[] findRightInterval(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return null;
        if (intervals.length == 1) return new int[]{-1};
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; ++i) {
            map.put(intervals[i].start, i);
        }
        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; ++i) {
            Interval interval = intervals[i];
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(interval.end);
            if (entry != null) {
                res[i] = entry.getValue();
            } else {
                res[i] = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[3];
        intervals[0]=new Interval(1,4);
        intervals[1]=new Interval(2,3);
        intervals[2]=new Interval(3,4);
        T436 solution=new T436();
        for (int index : solution.findRightInterval(intervals)) {
            System.out.println(index);
        }
    }

}
