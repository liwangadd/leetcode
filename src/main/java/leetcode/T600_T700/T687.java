package leetcode.T600_T700;

import utils.TreeNode;

public class T687 {

    private int res;

    public int longestUnivaluePath(TreeNode node) {
        if (node == null) return 0;
        res = 1;
        longestUnivaluePath2(node);
        return res - 1;
    }

    private int longestUnivaluePath2(TreeNode node) {
        if (node == null) return 0;
        int length = 1;
        int leftLen = longestUnivaluePath2(node.left);
        int rightLen = longestUnivaluePath2(node.right);
        if (node.left != null && node.left.val == node.val && node.right != null && node.right.val == node.val) {
            res = Math.max(res, leftLen + rightLen + 1);
        }
        if (node.left != null && node.left.val == node.val) {
            res = Math.max(res, leftLen + 1);
            length = Math.max(leftLen, leftLen + 1);
        }
        if (node.right != null && node.right.val == node.val) {
            res = Math.max(res, rightLen + 1);
            length = Math.max(length, rightLen + 1);
        }
        return length;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(4);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(4);
        root.right=new TreeNode(5);
        root.right.right = new TreeNode(5);
        new T687().longestUnivaluePath(root);
    }

}
