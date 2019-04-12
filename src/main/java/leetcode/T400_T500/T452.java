package leetcode.T400_T500;

import java.util.Arrays;

public class T452 {

    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, (p1, p2) -> {
            if (p1[1] != p2[1]) return p1[1] - p2[1];
            return p1[0] - p2[0];
        });
        int prevEnd = points[0][1];
        int res = 0;
        for (int i = 1; i < points.length; ++i) {
            if (points[i][0] > prevEnd) {
                ++res;
                prevEnd = points[i][1];
            }
        }
        return res + 1;
    }

    public static void main(String[] args) {
        T452 solution = new T452();
        System.out.println(solution.findMinArrowShots(new int[][]{
                {10, 16}, {2, 8}, {1, 6}, {7, 12}
        }));
    }

}
