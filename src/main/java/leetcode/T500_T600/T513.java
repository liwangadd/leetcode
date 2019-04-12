package leetcode.T500_T600;

import leetcode.T300_T400.T347;
import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class T513 {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean hasChild = false;
        int res = root.val;
        while (!queue.isEmpty()) {
            int size = queue.size();
            res = queue.peek().val;
            while (size-- != 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                    hasChild = true;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    hasChild = true;
                }
            }
            if (!hasChild) return res;
            else hasChild = false;
        }
        return res;
    }

}
