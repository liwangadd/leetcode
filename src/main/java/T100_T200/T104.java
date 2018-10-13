package T100_T200;

import utils.TreeNode;

public class T104 {

    private static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
