package leetcode.T200_T300;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class T272 {

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // write your code here
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null || k <= 0) return res;
        inOrder(root, target, k, res);
        return res;
    }

    private void inOrder(TreeNode node, double target, int k, LinkedList<Integer> res) {
        if (node == null) return;
        if (node.left != null) inOrder(node.left, target, k, res);
        if (res.size() < k) res.add(node.val);
        else {
            if (Math.abs(node.val - target) >= Math.abs(node.val - res.getFirst())) {
                return;
            } else {
                res.removeFirst();
                res.add(node.val);
            }
        }
        if (node.right != null) inOrder(node.right, target, k, res);
    }

}
