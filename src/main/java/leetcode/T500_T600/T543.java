package leetcode.T500_T600;

import utils.TreeNode;

public class T543 {

    private int maxLen = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxLen(root);
        return maxLen - 1;
    }

    private int maxLen(TreeNode node) {
        if (node == null) return 0;
        int len1 = maxLen(node.left);
        int len2 = maxLen(node.right);
        maxLen = Math.max(len1 + len2 + 1, maxLen);
        return Math.max(len1, len2) + 1;
    }

    public static void main(String[] args) {
        T543 solution = new T543();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(solution.diameterOfBinaryTree(root));
    }

}
