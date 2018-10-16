package T100_T200;

import utils.TreeNode;

public class T114 {

    public void flatten(TreeNode root) {
        if (root == null) return;
        flattenChild(root);
    }

    private TreeNode flattenChild(TreeNode node) {
        if (node == null) return null;
        TreeNode left = flattenChild(node.left);
        TreeNode right = flattenChild(node.right);

        node.left = null;
        node.right = left;
        TreeNode tmp = node;
        while (tmp.right != null)
            tmp = tmp.right;
        tmp.right = right;

        return node;
    }

}
