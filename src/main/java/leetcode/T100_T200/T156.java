package leetcode.T100_T200;

import leetcode.utils.TreeNode;

public class T156 {

    TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) return null;
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }

}
