package leetcode.T100_T200;

import utils.TreeNode;

public class T124 {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        maxSubPathSum(root);
        return maxSum;
    }

    private int maxSubPathSum(TreeNode root) {
        if (root == null)
            return 0;
        int curValue = root.val;
        int lmax = maxSubPathSum(root.left);
        int rmax = maxSubPathSum(root.right);
        if (lmax > 0)
            curValue += lmax;
        if (rmax > 0)
            curValue += rmax;
        maxSum = Math.max(curValue, maxSum);
        return Math.max(Math.max(lmax + root.val,
                rmax + root.val),
                root.val);
    }

    public static void main(String[] args) {
        T124 solution=new T124();
        TreeNode root = new TreeNode(0);
        System.out.println(solution.maxPathSum(root));
    }

}
