package leetcode.T600_T700;

import utils.TreeNode;

public class T669 {

    public TreeNode trimBST(TreeNode node, int low, int high) {
        if (node == null) return null;
        if (node.val > high) return trimBST(node.left, low, high);
        else if (node.val < low) return trimBST(node.right, low, high);
        else {
            node.left = trimBST(node.left, low, high);
            node.right = trimBST(node.right, low, high);
            return node;
        }
    }

}
