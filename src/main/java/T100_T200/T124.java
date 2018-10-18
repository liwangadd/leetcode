package T100_T200;

import utils.TreeNode;

public class T124 {

    private static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        maxSubPathSum(root);
        return maxSum;
    }

    private static int maxSubPathSum(TreeNode root) {
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
        TreeNode root = new TreeNode(-10);
        System.out.println(maxPathSum(root));
    }

}
