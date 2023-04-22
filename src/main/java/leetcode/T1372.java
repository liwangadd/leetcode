package leetcode;

import utils.TreeNode;

public class T1372 {

    private int maxLen;

    public int longestZigZag(TreeNode root) {
        this.maxLen = 0;
        longestZigZag(root, 0, 0);
        return this.maxLen;
    }

    private void longestZigZag(TreeNode node, int leftLen, int rightLen) {
        if (node == null) return;
        this.maxLen = Math.max(this.maxLen, Math.max(leftLen, rightLen));
        longestZigZag(node.left, rightLen + 1, 0);
        longestZigZag(node.right, 0, leftLen + 1);
    }

}
