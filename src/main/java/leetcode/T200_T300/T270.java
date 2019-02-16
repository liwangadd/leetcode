package leetcode.T200_T300;

import utils.TreeNode;

public class T270 {

    public int closestValue(TreeNode root, double target) {
        if (root == null) return -1;
        double min = Math.abs(root.val - target);
        int val;
        if (root.val < target) {
            val = closestValue(root.right, target);
        } else if (root.val > target) {
            val = closestValue(root.left, target);
        } else {
            return root.val;
        }
        if (val == -1) return root.val;
        else if (min < Math.abs(val - target)) return root.val;
        else return val;
    }

}
