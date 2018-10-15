package T400_T500;

import utils.TreeNode;

public class T450 {

    private int findReplacement(TreeNode parent, TreeNode node, boolean isLeft) {
        if (node.right == null) {
            if (isLeft) parent.left = node.left;
            else parent.right = node.left;
            return node.val;
        }
        return findReplacement(node, node.right, false);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            root.val = findReplacement(root, root.left, true);
        } else {
            if (root.val > key) root.left = deleteNode(root.left, key);
            else root.right = deleteNode(root.right, key);
        }
        return root;
    }

}
