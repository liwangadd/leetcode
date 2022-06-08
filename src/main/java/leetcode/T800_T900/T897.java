package leetcode.T800_T900;

import utils.TreeNode;

public class T897 {

    private TreeNode head, prev;

    public TreeNode increasingBST(TreeNode root) {
        head = null;
        prev = null;
        helper(root);
        return head;
    }

    private void helper(TreeNode node) {
        if (node == null) return;
        helper(node.left);
        node.left = null;
        if (head == null) {
            head = prev = node;
        } else {
            prev.right = node;
            prev = prev.right;
        }
        helper(node.right);
    }

}
