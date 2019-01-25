package leetcode.T400_T500;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T406 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.parallelSort(people, (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        List<int[]> res = new LinkedList<>();
        for (int[] person : people) {
            res.add(person[1], person);
        }
        return res.toArray(new int[0][0]);
    }

}
