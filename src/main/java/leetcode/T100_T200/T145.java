package leetcode.T100_T200;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class T145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        postorderTraversal(root, res);
        return res;
    }

    private void postorderTraversal(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        postorderTraversal(node.left, res);
        postorderTraversal(node.right, res);
        res.add(node.val);
    }
}
