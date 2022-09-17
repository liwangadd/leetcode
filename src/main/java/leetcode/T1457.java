package leetcode;

import utils.TreeNode;

public class T1457 {

    private int[] counts;

    private int res;

    public int pseudoPalindromicPaths(TreeNode root) {
        this.counts = new int[10];
        this.res = 0;
        visit(root);
        return res;
    }

    private void visit(TreeNode node) {
        if (node == null) return;
        counts[node.val]++;
        if (node.left == null && node.right == null && isPalindromic()) {
            ++res;
        }
        visit(node.left);
        visit(node.right);
        counts[node.val]--;
    }

    private boolean isPalindromic() {
        int oddCount = 0;
        for (int count : counts) {
            if ((count & 1) == 1) {
                if (oddCount > 0) return false;
                ++oddCount;
            }
        }
        return true;
    }

}
