package leetcode.T200_T300;

import utils.Interval;

import java.util.List;

public class T252 {

    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return true;
        intervals.sort((o1, o2) -> {
            if (o1.start != o2.start) return o1.start - o2.start;
            return o1.end - o2.end;
        });
        for (int i = 0; i < intervals.size() - 1; ++i) {
            if (intervals.get(i + 1).start < intervals.get(i).end) return false;
        }
        return true;
    }
}
