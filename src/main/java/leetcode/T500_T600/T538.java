package leetcode.T500_T600;

import utils.TreeNode;

public class T538 {

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convert(root, 0);
        return root;
    }

    private int convert(TreeNode node, int sum) {
        int leftSum = 0;
        if (node.right != null) {
            int rightSum = convert(node.right, sum);
            node.val += rightSum;
        } else {
            node.val += sum;
        }
        if (node.left != null) {
            leftSum = convert(node.left, node.val);
        }
        return node.val + leftSum;
    }

}
