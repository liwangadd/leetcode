package T100_T200;

import java.util.LinkedList;
import java.util.List;

public class T145 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

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
