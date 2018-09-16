public class T112 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return hasPathSum(root, 0, sum);
    }

    private static boolean hasPathSum(TreeNode root, int current, int sum) {
        if (root.left == null && root.right == null) {
            return current + root.val == sum;
        }
        boolean flag1 = false, flag2 = false;
        if (root.left != null)
            flag1 = hasPathSum(root.left, current + root.val, sum);
        if (root.right != null) {
            flag2 = hasPathSum(root.right, current + root.val, sum);
        }
        return flag1 || flag2;
    }

}
