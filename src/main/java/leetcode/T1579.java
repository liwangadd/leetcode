package leetcode;

import com.sun.xml.internal.ws.client.sei.ValueSetter;

import java.util.Arrays;

public class T1579 {

    public static void main(String[] args) {
        new T1579().maxNumEdgesToRemove(
                4,
                new int[][]{{3, 1, 2}, {3, 2, 3}, {1, 1, 3}, {1, 2, 4}, {1, 1, 2}, {2, 3, 4}}
        );
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (e1, e2) -> e2[0] - e1[0]);
        int edgeAdded = 0;
        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);
        for (int[] edge : edges) {
            switch (edge[0]) {
                case 1:
                    if (alice.union(edge[1], edge[2])) ++edgeAdded;
                    break;
                case 2:
                    if (bob.union(edge[1], edge[2])) ++edgeAdded;
                    break;
                case 3:
                    if (alice.union(edge[1], edge[2]) | bob.union(edge[1], edge[2])) ++edgeAdded;
                    break;
            }
            if (alice.isUnion() && bob.isUnion()) return edge.length - edgeAdded;
        }
        return -1;
    }

    private static final class UnionFind {

        private int[] parents;

        private int[] components;

        private int edgeCount;

        public UnionFind(int n) {
            parents = new int[n + 1];
            components = new int[n + 1];
            edgeCount = n;
            for (int i = 1; i <= n; i++) {
                parents[i] = i;
                components[i] = 1;
            }
        }

        public boolean union(int i, int j) {
            int parent1 = findParent(i);
            int parent2 = findParent(j);
            if (parent1 != parent2) {
                if (components[parent1] > components[parent2]) {
                    parents[parent2] = parent1;
                    components[parent1] += components[parent2];
                } else {
                    parents[parent1] = parent2;
                    components[parent2] += components[parent1];
                }
                --edgeCount;
                return true;
            }
            return false;
        }

        public boolean isUnion() {
            return edgeCount == 1;
        }

        private int findParent(int i) {
            return parents[i] = parents[i] == i ? i : findParent(parents[i]);
        }
    }

}
