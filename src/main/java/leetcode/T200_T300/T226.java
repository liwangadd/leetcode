package leetcode.T200_T300;

import utils.TreeNode;

public class T226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        invertTree1(root);
        return root;
    }

    public void invertTree1(TreeNode node) {
        if (node != null) {
            invertTree1(node.left);
            invertTree1(node.right);
            TreeNode leftTmp = node.left;
            node.left = node.right;
            node.right = leftTmp;
        }
    }

}
