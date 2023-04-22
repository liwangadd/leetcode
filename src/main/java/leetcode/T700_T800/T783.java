package leetcode.T700_T800;

import utils.TreeNode;

public class T783 {

    private int minVal;

    public int minDiffInBST(TreeNode root) {
        this.minVal = Integer.MAX_VALUE;
        calcMinMax(root);
        return minVal;
    }

    private int[] calcMinMax(TreeNode node) {
        if (node == null) return null;
        int[] leftRes = calcMinMax(node.left);
        int[] rightRes = calcMinMax(node.right);
        if (leftRes == null && rightRes == null) return new int[]{node.val, node.val};
        if (leftRes == null) {
            this.minVal = Math.min(this.minVal, rightRes[0] - node.val);
            return new int[]{node.val, rightRes[1]};
        } else if (rightRes == null) {
            this.minVal = Math.min(this.minVal, node.val - leftRes[1]);
            return new int[]{leftRes[0], node.val};
        } else {
            this.minVal = Math.min(this.minVal, Math.min(node.val - leftRes[1], rightRes[0] - node.val));
            return new int[]{leftRes[0], rightRes[1]};
        }
    }

}
