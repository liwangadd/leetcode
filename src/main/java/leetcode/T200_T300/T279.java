package leetcode.T200_T300;

import java.util.LinkedList;
import java.util.Queue;

public class T279 {

    public class Node {
        int num;
        int step;

        public Node(int num, int step) {
            this.num = num;
            this.step = step;
        }
    }

//    public int numSquares(int n) {
//        Queue<Node> queue = new LinkedList<>();
//        boolean[] visited = new boolean[n + 1];
//        queue.add(new Node(n, 0));
//        visited[n] = true;
//        while (!queue.isEmpty()) {
//            Node node = queue.poll();
//            for (int i = 1; ; ++i) {
//                int nodeNum = node.num - i * i;
//                if (nodeNum < 0) break;
//                if (nodeNum == 0) return node.step + 1;
//                if (!visited[nodeNum]) {
//                    visited[nodeNum] = true;
//                    queue.add(new Node(nodeNum, node.step + 1));
//                }
//            }
//        }
//        return -1;
//    }

    public int numSquares(int n) {
        if (n <= 0) return 0;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; i - j * j >= 0; ++j) {
                min = Math.min(min, dp[i - j * j] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        T279 solution = new T279();
        System.out.println(solution.numSquares(12));
        System.out.println(solution.numSquares(13));
    }

}
