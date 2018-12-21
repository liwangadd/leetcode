package leetcode.T100_T200;

import leetcode.utils.TreeNode;

public class T101 {


    private static boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        return left == null && right == null || left != null && right != null
                && left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

}
