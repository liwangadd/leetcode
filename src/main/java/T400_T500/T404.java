package T400_T500;

import utils.TreeNode;

public class T404 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return sumOfLeftLeaves(root, false);
    }

    public int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root.left == null && root.right == null) {
            if (isLeft)
                return root.val;
            else return 0;
        }
        int sum1 = 0, sum2 = 0;
        if (root.left != null) {
            sum1 = sumOfLeftLeaves(root.left, true);
        }
        if (root.right != null) {
            sum2 = sumOfLeftLeaves(root.right, false);
        }
        return sum1 + sum2;
    }

}
