package leetcode;

public class T1779 {

    public int nearestValidPoint(int x, int y, int[][] points) {
        int minIndex = -1, minDis = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] == x || point[1] == y) {
                int dis = Math.abs(point[0] - x) + Math.abs(point[1] - y);
                if (dis < minDis) {
                    minIndex = i;
                    minDis = dis;
                }
            }
        }
        return minIndex;
    }

}
