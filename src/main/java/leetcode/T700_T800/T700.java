package leetcode.T700_T800;

import utils.TreeNode;

public class T700 {

    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode node = root;
        while (node != null) {
            if (node.val < val) node = node.right;
            else if (node.val > val) node = node.left;
            else break;
        }
        if (node == root && root.val != val) return null;
        return node;
    }

}
