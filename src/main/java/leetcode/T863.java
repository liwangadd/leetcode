package leetcode;

import utils.TreeNode;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class T863 {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        dfs(root, target, stack);
        while (!stack.isEmpty() && k >= 0) {
            TreeNode node = stack.pop();
            if (!visited.contains(node)) {
                res.addAll(findDownDistance(node, visited, k--));
                visited.add(node);
            }
        }
        return res;
    }

    private boolean dfs(TreeNode root, TreeNode target, Stack<TreeNode> stack) {
        if (root == null) {
            return false;
        } else if (root == target) {
            stack.add(target);
            return true;
        }
        stack.add(root);
        boolean res = dfs(root.left, target, stack);
        if (res) {
            return true;
        }
        res = dfs(root.right, target, stack);
        if (res) {
            return true;
        }
        stack.pop();
        return false;
    }


    private List<Integer> findDownDistance(TreeNode root, Set<TreeNode> visited, int k) {
        if (root == null || visited.contains(root)) {
            return Collections.emptyList();
        }
        if (k == 0) {
            return Collections.singletonList(root.val);
        }
        List<Integer> res = new LinkedList<>();
        res.addAll(findDownDistance(root.left, visited, k - 1));
        res.addAll(findDownDistance(root.right, visited, k - 1));
        return res;
    }

}
