package leetcode;

import utils.TreeNode;

public class T1379 {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || target == null) return null;
        if (original == target) return cloned;
        TreeNode clonedTarget = getTargetCopy(original.left, cloned.left, target);
        if (clonedTarget != null) return clonedTarget;
        return getTargetCopy(original.right, cloned.right, target);
    }

}
