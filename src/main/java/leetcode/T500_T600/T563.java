package leetcode.T500_T600;

import utils.TreeNode;

public class T563 {

    private int sum = 0;

    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        calcNodeTilt(root);
        return sum;
    }

    private int calcNodeTilt(TreeNode node) {
        if (node == null) return 0;
        int leftSum = calcNodeTilt(node.left);
        int rightSum = calcNodeTilt(node.right);
        int val = node.val;
        node.val = Math.abs(leftSum - rightSum);
        sum += node.val;
        return leftSum + rightSum + val;
    }

}
