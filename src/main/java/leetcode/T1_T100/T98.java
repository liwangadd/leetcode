package leetcode.T1_T100;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class T98 {

//    public boolean isValidBST(TreeNode root) {
//        List<Integer> list = new LinkedList<>();
//        inOrder(root, list);
//        for (int i = 0; i < list.size() - 1; ++i) {
//            if (list.get(i + 1) <= list.get(i)) return false;
//        }
//        return true;
//    }

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

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

}
