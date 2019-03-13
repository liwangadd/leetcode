package leetcode.T200_T300;

import utils.TreeNode;

import java.util.concurrent.ExecutorService;

public class T285 {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        if (p.right != null) {
            p = p.right;
            while (p.left != null) p = p.left;
            return p;
        }
        TreeNode ans = null;
        while (root != null) {
            if (root.val < p.val) root = root.right;
            else if (root.val > p.val) {
                ans = root;
                root = root.left;
            } else {
                break;
            }
        }
        return ans;
    }

}
