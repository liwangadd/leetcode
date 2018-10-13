package T1_T100;

import java.util.Stack;

public class T100 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        return (p != null && q != null && q.val == p.val)
                && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
                || p == null && q == null;
    }

}
