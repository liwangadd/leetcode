package leetcode.T800_T900;

import utils.TreeNode;

public class T814 {

    public TreeNode pruneTree(TreeNode node) {
        if (node == null) return null;
        TreeNode left = pruneTree(node.left);
        TreeNode right = pruneTree(node.right);
        if (left == null) node.left = null;
        if (right == null) node.right = null;
        if (left == null && right == null && node.val == 0) return null;
        return node;
    }

}
