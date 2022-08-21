package leetcode.T900_T1000;

import java.util.LinkedList;
import java.util.List;

public class T986 {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new LinkedList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int lo = Math.max(firstList[i][0], secondList[j][0]);
            int hi = Math.min(firstList[i][1], secondList[j][1]);
            if (lo <= hi) res.add(new int[]{lo, hi});
            if (firstList[i][1] < secondList[j][1]) ++i;
            else ++j;
        }
        return res.toArray(new int[0][]);
    }

}
