package leetcode.T1_T100;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class T94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        inorderTraversal(root, res);
        return res;
    }

    private void inorderTraversal(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, res);
        res.add(node.val);
        inorderTraversal(node.right, res);
    }

    private void inorderTraversal2(TreeNode node, List<Integer> res) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            res.add(node.val);
            node = node.right;
        }
    }

}
