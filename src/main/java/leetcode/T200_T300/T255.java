package leetcode.T200_T300;

public class T255 {

    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return true;
        return verifyPreorder(preorder, 0, preorder.length - 1);
    }

    private boolean verifyPreorder(int[] preorder, int start, int end) {
        if (start >= end) return true;
        int val = preorder[start];
        int i = start + 1;
        for (; i <= end; ++i) {
            if (preorder[i] > val) break;
        }
        for (int j = i; j <= end; ++j) {
            if (preorder[j] < val) return false;
        }
        return verifyPreorder(preorder, start + 1, i - 1) && verifyPreorder(preorder, i, end);
    }

}
