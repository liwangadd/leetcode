package T1_T100;

import utils.TreeNode;

public class T99 {

    private TreeNode firstElement = null;
    private TreeNode secondElement = null;

    private TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {

        traverse(root);

        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    private void traverse(TreeNode root) {

        if (root == null)
            return;

        traverse(root.left);

        if (firstElement == null && prevElement.val >= root.val) {
            firstElement = prevElement;
        }

        if (firstElement != null && prevElement.val >= root.val) {
            secondElement = root;
        }
        prevElement = root;

        traverse(root.right);

    }
}
