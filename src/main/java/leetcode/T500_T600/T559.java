package leetcode.T500_T600;

import java.util.List;

public class T559 {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        for (Node child : root.children) {
            depth = Math.max(depth, maxDepth(child));
        }
        return depth;
    }

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
