package T100_T200;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 1;
        while (!queue.isEmpty()) {
            int currentCount = count;
            count = 0;
            while (currentCount-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                    ++count;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    ++count;
                }
                if (currentCount == 0) res.add(node.val);
            }
        }
        return res;
    }

}
