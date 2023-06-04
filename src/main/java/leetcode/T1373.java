package leetcode;

import utils.TreeNode;

public class T1373 {

    private int res = 0;

    public int maxSumBST(TreeNode root) {
        this.res = 0;
        dfs(root);
        return this.res;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) return new int[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        int[] leftRes = dfs(node.left), rightRes = dfs(node.right);
        if (leftRes[0] == 0 && rightRes[0] == 0 && node.val > leftRes[2] && node.val < rightRes[1]) {
            int sum = node.val + leftRes[3] + rightRes[3];
            this.res = Math.max(res, sum);
            return new int[]{0, Math.min(leftRes[1], node.val), Math.max(rightRes[2], node.val), sum};
        } else {
            return new int[]{1, 0, 0, 0};
        }
    }

}
