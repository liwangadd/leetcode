package leetcode.T600_T700;

import utils.TreeNode;

public class T623 {

    public TreeNode addOneRow(TreeNode node, int val, int depth) {
        if (depth == 1) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = node;
            return newNode;
        }
        TreeNode newNode = addOneRow(node, val, depth, true);
        return newNode;
    }

    public TreeNode addOneRow(TreeNode node, int val, int depth, boolean isLeft) {
        if (node == null) {
            if (depth == 1) return new TreeNode(val);
            else return null;
        }
        if (depth == 1) {
            TreeNode newNode = new TreeNode(val);
            if (isLeft) newNode.left = node;
            else newNode.right = node;
            return newNode;
        }
        node.left = addOneRow(node.left, val, depth - 1, true);
        node.right = addOneRow(node.right, val, depth - 1, false);
        return node;
    }

}
