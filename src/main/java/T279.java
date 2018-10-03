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

    public int numSquares(int n) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.add(new Node(n, 0));
        visited[n] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 1; ; ++i) {
                int nodeNum = node.num - i * i;
                if (nodeNum < 0) break;
                if (nodeNum == 0) return node.step + 1;
                if (!visited[nodeNum]) {
                    visited[nodeNum] = true;
                    queue.add(new Node(nodeNum, node.step + 1));
                }
            }
        }
        return -1;
    }

}
