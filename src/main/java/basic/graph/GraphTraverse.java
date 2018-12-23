package basic.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphTraverse {

    /**
     * 图的广度优先遍历
     *
     * @param graph
     */
    public void BFS(int[][] graph) {
        int N = graph.length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; ++i) { // 用于处理非连通图
            if (!visited[i]) {
                queue.add(i);
                visited[i] = true;
                while (!queue.isEmpty()) {
                    int front = queue.poll();
                    for (int j = 0; j < N; ++j) {
                        if (!visited[j] && graph[front][j] == 1) { // 结点没有被访问过，且两节点之间存在边
                            queue.add(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
    }

    /**
     * 图的深度优先遍历，递归实现
     *
     * @param graph
     */
    public void recursionDFS(int[][] graph) {
        int N = graph.length;
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; ++i) {
            if (!visited[i]) {
                recursionDFS(graph, i, visited);
            }
        }
    }

    private void recursionDFS(int[][] graph, int front, boolean[] visited) {
        visited[front] = true;
        for (int i = 0; i < graph.length; ++i) {
            if (!visited[i] && graph[front][i] == 1) {
                recursionDFS(graph, i, visited);
            }
        }
    }

    /**
     * 图的深度优先遍历，非递归实现
     *
     * @param graph
     */
    public void DFS(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; ++i) {
            if (!visited[i]) {
                DFS(graph, i, visited);
            }
        }
    }

    private void DFS(int[][] graph, int front, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(front);
        visited[front] = true;
        boolean isPush;
        while (!stack.isEmpty()) {
            isPush = false;
            int v = stack.peek();
            for (int i = 0; i < graph.length; ++i) {
                if (graph[v][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    stack.push(i);
                    isPush = true;
                    break;
                }
            }
            if (!isPush) {
                stack.pop();
            }
        }
    }

}
