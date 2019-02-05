package leetcode.T200_T300;

import utils.TreeNode;

public class T298 {

    public int longestConsecutive(TreeNode root) {
        // write your code here
        if (root == null) return 0;
        return longestConsecutive(root, 1);
    }

    private int longestConsecutive(TreeNode node, int len) {
        if (node.left == null && node.right == null) return len;
        int leftLen = -1, rightLen = -1;
        if (node.left != null) {
            if (node.val + 1 == node.left.val)
                leftLen = longestConsecutive(node.left, len + 1);
            else leftLen = longestConsecutive(node.left, 0);
        }
        if (node.right != null) {
            if (node.right.val == node.val + 1) {
                rightLen = longestConsecutive(node.right, len + 1);
            } else {
                rightLen = longestConsecutive(node.right, 0);
            }
        }
        return Math.max(Math.max(leftLen, rightLen), len);
    }

}
