package leetcode;

import utils.TreeNode;

public class T1339 {

    private static final int MOD = (int) (1e9 + 7);

    private long maxRes;

    private long sum;

    public int maxProduct(TreeNode root) {
        maxRes = 0;
        sum = calcTreeSum(root);
        calcSubTreeSum(root);
        return (int) (maxRes % MOD);
    }

    private long calcSubTreeSum(TreeNode node) {
        if (node == null) return 0;
        long leftSum = calcSubTreeSum(node.left);
        long rightSum = calcSubTreeSum(node.right);
        maxRes = Math.max(maxRes, Math.max(leftSum * (sum - leftSum), rightSum * (sum - rightSum)));
        return node.val + leftSum + rightSum;
    }

    private long calcTreeSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + calcTreeSum(node.left) + calcTreeSum(node.right);
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }

}
