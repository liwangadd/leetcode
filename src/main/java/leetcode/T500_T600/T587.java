package leetcode.T500_T600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class T587 {

    // Jarvis
    public int[][] outerTrees1(int[][] trees) {
        int len = trees.length;
        if (len < 4) return trees;
        int leftMost = 0;
        for (int i = 1; i < len; ++i) {
            if (trees[i][0] < trees[leftMost][0] || trees[i][0] == trees[leftMost][0] && trees[i][1] < trees[leftMost][1])
                leftMost = i;
        }
        List<int[]> fence = new ArrayList<>();
        boolean[] visited = new boolean[len];
        int p = leftMost;
        do {
            int q = (p + 1) % len;
            for (int i = 0; i < len; ++i) {
                if (cross(trees[p], trees[q], trees[i]) < 0)
                    q = i;
            }
            for (int i = 0; i < len; ++i) {
                if (i != p && i != q && !visited[i] && cross(trees[p], trees[q], trees[i]) == 0) {
                    fence.add(trees[i]);
                    visited[i] = true;
                }
            }
            if (!visited[q]) {
                fence.add(trees[q]);
                visited[q] = true;
            }
            p = q;
        } while (p != leftMost);
        return fence.toArray(new int[0][]);
    }

    // -----------------------------------------------------------------------------------------------------------------
    public int[][] outerTrees2(int[][] trees) {
        int len = trees.length;
        if (len < 4) return trees;
        int bottom = 0;
        for (int i = 0; i < len; i++) {
            if (trees[i][1] < trees[bottom][1])
                bottom = i;
        }
        swap(trees, 0, bottom);
        Arrays.sort(trees, 1, len, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int diff = cross(trees[0], o1, o2);
                if (diff == 0) return distance(trees[0], o1) - distance(trees[0], o2);
                return -diff;
            }
        });
        int start = len - 1, end = len - 1;
        while (start >= 0 && cross(trees[0], trees[end], trees[start]) == 0)
            --start;
        ++start;
        for (; start < end; ++start, --end)
            swap(trees, start, end);
        Deque<int[]> stack = new LinkedList<>();
        stack.addLast(trees[0]);
        stack.add(trees[1]);
        for (int i = 2; i < len; ++i) {
            int[] top = stack.pollLast();
            while (!stack.isEmpty() && cross(stack.getLast(), top, trees[i]) < 0)
                top = stack.pollLast();
            stack.addLast(top);
            stack.addLast(trees[i]);
        }
        return stack.toArray(new int[0][]);
    }

    // -----------------------------------------------------------------------------------------------------------------
    private int distance(int[] p, int[] q) {
        return (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
    }

    private void swap(int[][] trees, int i, int j) {
        int prevX = trees[i][0], prevY = trees[i][1];
        trees[i][0] = trees[j][0];
        trees[i][1] = trees[j][1];
        trees[j][0] = prevX;
        trees[j][1] = prevY;
    }

    private int cross(int[] p, int[] q, int[] r) {
        return (q[0] - p[0]) * (r[1] - q[1]) - (r[0] - q[0]) * (q[1] - p[1]);
    }
}
