package leetcode.T1_T100;

import utils.TreeNode;

public class T100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return (p != null && q != null && q.val == p.val)
                && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
                || p == null && q == null;
    }

}
