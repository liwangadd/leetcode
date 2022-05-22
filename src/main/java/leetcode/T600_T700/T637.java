package leetcode.T600_T700;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T637 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelCount = 1;
        while (!queue.isEmpty()) {
            double sum = 0.0;
            int tempCount = 0;
            for (int i = 0; i < levelCount; ++i) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                    ++tempCount;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    ++tempCount;
                }
            }
            res.add(sum / levelCount);
            levelCount = tempCount;
        }
        return res;
    }

}
