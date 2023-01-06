package leetcode;

public class T1971 {

    private int find(int[] uf, int target) {
        if (uf[target] == target) return target;
        uf[target] = find(uf, uf[target]);
        return uf[target];
    }

    private void union(int[] uf, int a, int b) {
        int aboss = find(uf, a);
        int bboss = find(uf, b);
        uf[aboss] = bboss;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] uf = new int[n];
        for (int i = 0; i < n; i++) uf[i] = i;
        for (int[] e : edges) {
            union(uf, e[0], e[1]);
        }
        int aboss = find(uf, source);
        int bboss = find(uf, destination);
        return aboss == bboss;
    }

}
