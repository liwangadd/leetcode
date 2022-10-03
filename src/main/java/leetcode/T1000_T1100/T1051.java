package leetcode.T1000_T1100;

import java.util.Arrays;
import java.util.stream.IntStream;

public class T1051 {

    public int heightChecker(int[] heights) {
        int[] orderedHeights = IntStream.of(heights).sorted().toArray();
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            res += heights[i] == orderedHeights[i] ? 0 : 1;
        }
        return res;
    }

}
