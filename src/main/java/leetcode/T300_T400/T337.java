package leetcode.T300_T400;

import leetcode.utils.TreeNode;

public class T337 {

    public int rob(TreeNode root) {
        if (root == null) return 0;
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSub(TreeNode node) {
        if (node == null) return new int[2];
        int[] res1 = robSub(node.left);
        int[] res2 = robSub(node.right);
        int[] res = new int[2];
        res[0] = Math.max(res1[0], res1[1]) + Math.max(res2[0], res2[1]);
        res[1] = node.val + res1[0] + res2[0];
        return res;
    }
}
