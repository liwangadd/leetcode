package leetcode.T700_T800;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class T722 {

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (c1, c2) -> c1[1] - c2[1]);
        int time = 0;
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int[] course : courses) {
            time += course[0];
            queue.add(course[0]);
            if (time > course[1]) time -= queue.poll();
        }
        return queue.size();
    }

}
