package leetcode;

import utils.TreeNode;

public class T1145 {

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode xNode = findNode(root, x);
        int leftCount = countNode(xNode.left);
        int rightCount = countNode(xNode.right);
        if ((leftCount + rightCount + 1) <= n / 2 || rightCount > n / 2 || leftCount > n / 2)
            return true;
        return false;
    }

    private TreeNode findNode(TreeNode node, int x) {
        if (node == null) return null;
        if (node.val == x) return node;
        TreeNode leftChild = findNode(node.left, x);
        if (leftChild != null) return leftChild;
        return findNode(node.right, x);
    }

    private int countNode(TreeNode node) {
        if (node == null) return 0;
        return 1 + countNode(node.left) + countNode(node.right);
    }

}
