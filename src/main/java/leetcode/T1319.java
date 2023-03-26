package leetcode;

public class T1319 {

    public int makeConnected(int n, int[][] connections) {
        if (n > connections.length + 1) return -1;
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int[] connection : connections) {
            int p1 = findParent(connection[0], parent);
            int p2 = findParent(connection[1], parent);
            if (p1 != p2) {
                if (size[p1] > size[p2]) {
                    parent[p2] = p1;
                    size[p1] += size[p2];
                } else {
                    parent[p1] = p2;
                    size[p2] += size[p1];
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) ++res;
        }
        return res - 1;
    }

    private int findParent(int i, int[] parent) {
        return parent[i] == i ? i : findParent(parent[i], parent);
    }

}
