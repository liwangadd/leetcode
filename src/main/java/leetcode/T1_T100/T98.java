package leetcode.T1_T100;

import utils.TreeNode;

import java.util.Stack;

public class T98 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root, prev = null;

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (prev != null && prev.val > node.val) return false;
            prev = node;
            node = node.right;
        }
        return true;
    }

}
