package leetcode.T900_T1000;

import utils.TreeNode;

public class T938 {

    public int rangeSumBST(TreeNode node, int low, int high) {
        if (node == null) return 0;
        if (node.val < low) {
            return rangeSumBST(node.right, low, high);
        } else if (node.val > high) {
            return rangeSumBST(node.left, low, high);
        } else {
            return node.val + rangeSumBST(node.left, low, high) + rangeSumBST(node.right, low, high);
        }
    }

}
