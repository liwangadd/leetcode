package T100_T200;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class T144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        preorderTraversal(root, res);
        return res;
    }

    public void preorderTraversal(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        preorderTraversal(node.left, res);
        preorderTraversal(node.right, res);
    }
}
