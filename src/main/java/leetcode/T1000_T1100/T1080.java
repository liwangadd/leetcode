package leetcode.T1000_T1100;

import utils.TreeNode;

public class T1080 {

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        TreeNode dummyRoot = new TreeNode(-1);
        dummyRoot.left = root;
        removeInsufficientSubset(root, dummyRoot, 0, limit, true);
        return dummyRoot.left;
    }

    private int removeInsufficientSubset(TreeNode node, TreeNode parentNode, int prefixSum, int limit, boolean isLeft) {
        if (node.left == null && node.right == null) {
            int sum = prefixSum + node.val;
            if (sum < limit) {
                if (isLeft) parentNode.left = null;
                else parentNode.right = null;
            }
            return sum;
        }
        int max = Integer.MIN_VALUE;
        if (node.left != null) {
            int leftRes = removeInsufficientSubset(node.left, node, prefixSum + node.val, limit, true);
            max = Math.max(max, leftRes);
        }
        if (node.right != null) {
            int rightRes = removeInsufficientSubset(node.right, node, prefixSum + node.val, limit, false);
            max = Math.max(max, rightRes);
        }
        if (max < limit) {
            if (isLeft) parentNode.left = null;
            else parentNode.right = null;
        }
        return max;
    }

}
