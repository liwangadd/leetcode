package T100_T200;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 1;
        while (!queue.isEmpty()) {
            int currentCount = count;
            count = 0;
            List<Integer> resItem = new LinkedList<>();
            while (currentCount-- > 0) {
                TreeNode node = queue.poll();
                resItem.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                    ++count;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    ++count;
                }
            }
            res.add(resItem);
        }
        return res;
    }
}
