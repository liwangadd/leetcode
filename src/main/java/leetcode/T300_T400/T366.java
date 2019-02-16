package leetcode.T300_T400;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T366 {

    private List<List<Integer>> res;

    public List<List<Integer>> findLeaves(TreeNode root) {
        // write your code here
        res = new ArrayList<>();
        if (root == null) return res;
        helper(root);
        return res;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = helper(node.left);
        int rightDepth = helper(node.right);
        int index = Math.max(leftDepth, rightDepth);
        if (res.size() > index) {
            res.get(index).add(node.val);
        } else {
            List<Integer> item = new ArrayList<>();
            item.add(node.val);
            res.add(item);
        }
        return index + 1;
    }

}
