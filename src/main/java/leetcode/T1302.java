package leetcode;

import leetcode.T300_T400.T347;
import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class T1302 {

    public int deepestLeavesSum(TreeNode root) {
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                res += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (!queue.isEmpty()) {
                res = 0;
            }
        }
        return res;
    }

}
