package leetcode.T500_T600;

import java.util.LinkedList;
import java.util.List;

public class T590 {

    public List<Integer> postorder(Node root) {
        List<Integer> res = new LinkedList<>();
        postorder(root, res);
        return res;
    }

    private void postorder(Node node, List<Integer> res) {
        if (node == null) return;
        List<Node> children = node.children;
        for (Node child : children) {
            postorder(child, res);
        }
        res.add(node.val);
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
