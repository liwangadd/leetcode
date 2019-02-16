package leetcode.T200_T300;

import utils.TreeNode;

public class T250 {

    private int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        count = 0;
        isSubTreeSame(root);
        return count;
    }

    private boolean isSubTreeSame(TreeNode node) {
        if(node == null)
            return true;
        if(node.left ==null && node.right == null) {
            count++;
            return true;
        }
        boolean left = isSubTreeSame(node.left);
        boolean right = isSubTreeSame(node.right);
        if(left && right && (node.left == null || node.left.val == node.val) && (node.right == null || node.right.val == node.val)) {
            count++;
            return true;
        }
        return false;
    }

}
