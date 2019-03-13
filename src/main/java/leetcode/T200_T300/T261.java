package leetcode.T200_T300;

public class T261 {

    public boolean validTree(int n, int[][] edges) {
        if (n != edges.length + 1) return false;
        int[] parents = new int[n];
        for (int i = 0; i < n; ++i) parents[i] = i;
        for (int[] edge : edges) {
            int point1 = edge[0], point2 = edge[1];
            while (parents[point1] != point1) {
                parents[point1] = parents[parents[point1]];
                point1 = parents[point1];
            }
            while (parents[point2] != point2) {
                parents[point2] = parents[parents[point2]];
                point2 = parents[point2];
            }
            if (point1 != point2) {
                parents[point2] = point1;
                --n;
            }
        }
        return n == 1;
    }

}
