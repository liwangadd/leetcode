package leetcode.T900_T1000;

import utils.TreeNode;

public class T968 {

    private int res;

    public int minCameraCover(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }

    private int helper(TreeNode node) {
        if (node == null) return 2;
        int left = helper(node.left), right = helper(node.right);
        if (left == 1 || right == 1) {
            ++res;
            return 0;
        }
        return left == 0 || right == 0 ? 2 : 1;
    }

}
