package leetcode.T500_T600;

import java.util.LinkedList;
import java.util.List;

public class T589 {

    public List<Integer> preorder(Node root) {
        List<Integer> res = new LinkedList<>();
        preorder(root, res);
        return res;
    }

    private void preorder(Node node, List<Integer> res) {
        if (node == null) return;
        res.add(node.val);
        List<Node> children = node.children;
        for (Node child : children) {
            preorder(child, res);
        }
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
