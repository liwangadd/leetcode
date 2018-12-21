package leetcode.T400_T500;

import leetcode.utils.TreeNode;

public class T437 {

    public int pathSum(TreeNode root, int sum) {
        return pathSum1(root, sum);
    }

    private int pathSum1(TreeNode node, int sum) {
        if (node == null || sum < 0) return 0;
        if (sum == 0) return 1;
        int count1 = pathSum(node.left, sum - node.val) + pathSum(node.right, sum - node.val);
        int count2 = pathSum(node.left, sum) + pathSum(node.right, sum);
        return count1 + count2;
    }

}
