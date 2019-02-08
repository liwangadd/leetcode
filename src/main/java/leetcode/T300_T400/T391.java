package leetcode.T300_T400;

import java.util.HashSet;

public class T391 {

    public boolean isRectangleCover(int[][] rectangles) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int top = Integer.MIN_VALUE;
        int bottom = Integer.MAX_VALUE;
        int n = rectangles.length;
        HashSet<String> flags = new HashSet<>();
        int totalArea = 0;
        for (int i = 0; i < n; i++) {
            left = Math.min(left, rectangles[i][0]);
            bottom = Math.min(bottom, rectangles[i][1]);
            right = Math.max(right, rectangles[i][2]);
            top = Math.max(top, rectangles[i][3]);
            totalArea += (rectangles[i][3] - rectangles[i][1]) * (rectangles[i][2] - rectangles[i][0]);
            String pointLT = rectangles[i][0] + " " + rectangles[i][3];
            String pointLB = rectangles[i][0] + " " + rectangles[i][1];
            String pointRT = rectangles[i][2] + " " + rectangles[i][3];
            String pointRB = rectangles[i][2] + " " + rectangles[i][1];
            if (!flags.contains(pointLT)) flags.add(pointLT);
            else flags.remove(pointLT);
            if (!flags.contains(pointLB)) flags.add(pointLB);
            else flags.remove(pointLB);
            if (!flags.contains(pointRT)) flags.add(pointRT);
            else flags.remove(pointRT);
            if (!flags.contains(pointRB)) flags.add(pointRB);
            else flags.remove(pointRB);
        }
        if (flags.size() == 4 && flags.contains(left + " " + top) && flags.contains(left + " " + bottom) && flags.contains(right + " " + bottom) && flags.contains(right + " " + top)) {
            return totalArea == (right - left) * (top - bottom);
        }
        return false;
    }

}
