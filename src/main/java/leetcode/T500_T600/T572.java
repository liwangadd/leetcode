package leetcode.T500_T600;

import utils.TreeNode;

public class T572 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return s != null && t != null && (s.val == t.val && isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t));
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        return s == null && t == null || s != null && t != null && s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
    }

}
