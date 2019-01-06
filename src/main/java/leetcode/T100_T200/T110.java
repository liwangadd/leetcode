package leetcode.T100_T200;

import utils.TreeNode;

public class T110 {

    private boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int length1 = maxDepth(root.left);
        int length2 = maxDepth(root.right);
        if (length1 == -1 || length2 == -1) return false;
        return true;
    }

    private int maxDepth(TreeNode node) {
        int length1 = 0, length2 = 0;
        if (node == null) return 0;
        length1 = maxDepth(node.left);
        length2 = maxDepth(node.right);
        if (length1 == -1 || length2 == -1) return -1;
        if (Math.abs(length1 - length2) > 1) return -1;
        else return Math.max(length1, length2) + 1;
    }
}
