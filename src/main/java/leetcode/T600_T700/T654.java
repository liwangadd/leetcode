package leetcode.T600_T700;

import utils.TreeNode;

public class T654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums==null||nums.length==0) return null;
        return buildTree(nums, 0, nums.length);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left >= right) return null;
        int maxIndex = left, max = nums[left];
        for (int i = left + 1; i < right; ++i) {
            if (nums[i] > nums[maxIndex]) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = buildTree(nums, left, maxIndex);
        node.right = buildTree(nums, maxIndex + 1, right);
        return node;
    }

}
