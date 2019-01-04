package leetcode.T200_T300;

import utils.TreeNode;

public class T222 {

    public int leftMost(TreeNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.left;
        }
        return count;
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftmost = leftMost(root.left);

        int count = 1;
        int middle = leftMost(root.right);
        if (leftmost == middle) {
            count += (1 << leftmost) - 1;
            count += countNodes(root.right);
        } else {
            count += (1 << middle) - 1;
            count += countNodes(root.left);
        }
        return count;
    }

}
