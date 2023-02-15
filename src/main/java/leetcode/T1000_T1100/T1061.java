package leetcode.T1000_T1100;

import java.util.Arrays;

public class T1061 {

    private int[] parents;

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        this.parents = new int[26];
        for (int i = 0; i < 26; i++) {
            parents[i] = i;
        }
        for (int i = 0, len = s1.length(); i < len; ++i) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0, len = baseStr.length(); i < len; ++i) {
            sb.append((char) (find(baseStr.charAt(i) - 'a') + 'a'));
        }
        return sb.toString();
    }

    private int find(int node) {
        return parents[node] == node ? node : find(parents[node]);
    }

    private void union(int node1, int node2) {
        int parent1 = find(node1);
        int parent2 = find(node2);
        parents[Math.max(parent1, parent2)] = Math.min(parent1, parent2);
    }

    public static void main(String[] args) {
        System.out.println(new T1061().smallestEquivalentString(
                "parker",
                "morris",
                "parser"
        ));
    }

}
