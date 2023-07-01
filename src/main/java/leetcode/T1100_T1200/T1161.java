package leetcode.T1100_T1200;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class T1161 {

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 1, maxSum = Integer.MIN_VALUE, maxLevel = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size(), sum = 0;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (sum > maxSum) {
                maxSum = sum;
                maxLevel = level;
            }
            ++level;
        }
        return maxLevel;
    }

}
