package T1_T100;

import java.util.LinkedList;
import java.util.List;

public class T94 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

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

}
