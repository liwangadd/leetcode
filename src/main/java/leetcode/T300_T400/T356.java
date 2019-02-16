package leetcode.T300_T400;

import java.util.*;

public class T356 {

    public boolean isReflected(int[][] points) {
        Arrays.sort(points, (p1, p2) -> {
            if (p1[0] != p2[0]) return p1[0] - p2[0];
            else return p1[1] - p2[1];
        });
        int first = 0, last = points.length - 1;
        double middle = (points[first][0] + points[last][0]) / 2.0;
        while (first < last) {
            if (Double.compare((points[first][0] + points[last][0]) / 2.0, middle) != 0 || points[first][1] != points[last][1]) {
                return false;
            }
            while (first < points.length - 1 && points[first][0] == points[first + 1][0] && points[first][1] == points[first + 1][1])
                ++first;
            while (last > 0 && points[last][0] == points[last - 1][0] && points[last][1] == points[last][1])
                --last;
            ++first;
            --last;
        }
        return true;
    }

}
