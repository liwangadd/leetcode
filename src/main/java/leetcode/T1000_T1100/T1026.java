package leetcode.T1000_T1100;

import utils.TreeNode;

public class T1026 {

    private int res;

    public int maxAncestorDiff(TreeNode root) {
        res = 0;
        maxAncestorDiff(root, root.val, root.val);
        return res;
    }

    private void maxAncestorDiff(TreeNode node, int min, int max) {
        if (node == null) return;
        res = Math.max(res, Math.max(Math.abs(min - node.val), Math.abs(max - node.val)));
        maxAncestorDiff(node.left, Math.min(node.val, min), Math.max(node.val, max));
        maxAncestorDiff(node.right, Math.min(node.val, min), Math.max(node.val, max));
    }

}
