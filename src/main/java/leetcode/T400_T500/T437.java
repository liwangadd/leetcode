package leetcode.T400_T500;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class T437 {

    private int count;

    public int pathSum(TreeNode root, int sum) {
        count = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        helper(root, 0, sum, preSum);
        return count;
    }

    private void helper(TreeNode node, int curSum, int sum, Map<Integer, Integer> preSum) {
        if (node == null) return;
        curSum += node.val;
        if (preSum.containsKey(curSum - sum)) {
            count += preSum.get(curSum - sum);
        }
        preSum.put(curSum, preSum.getOrDefault(curSum, 0) + 1);
        helper(node.left, curSum, sum, preSum);
        helper(node.right, curSum, sum, preSum);
        preSum.put(curSum, preSum.getOrDefault(curSum, 0) - 1);
    }

}
