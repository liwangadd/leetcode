package leetcode.T500_T600;

import utils.TreeNode;

public class T530 {

    private int globalMin = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode node) {
        innerFindMinimumDifference(node);
        return globalMin;
    }

    private void innerFindMinimumDifference(TreeNode node) {
        if (node == null) return;
        if (node.left != null) {
            globalMin = Math.min(globalMin, node.val - findMax(node.left));
        }
        if (node.right != null) {
            globalMin = Math.min(globalMin, findMin(node.right) - node.val);
        }
        innerFindMinimumDifference(node.left);
        innerFindMinimumDifference(node.right);
    }

    private int findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }

    private int findMax(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.val;
    }

}
